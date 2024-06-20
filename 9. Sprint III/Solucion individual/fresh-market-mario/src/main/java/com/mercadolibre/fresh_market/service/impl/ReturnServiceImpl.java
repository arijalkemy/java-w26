package com.mercadolibre.fresh_market.service.impl;

import com.mercadolibre.fresh_market.config.ProductNotFoundException;
import com.mercadolibre.fresh_market.dtos.*;
import com.mercadolibre.fresh_market.exceptions.ErrorUpdatingReturnException;
import com.mercadolibre.fresh_market.exceptions.ReturnAlreadyExistsException;
import com.mercadolibre.fresh_market.exceptions.ReturnNotFoundException;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.PurchaseOrder;
import com.mercadolibre.fresh_market.model.Returns;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.repository.IPurchaseOrderRepository;
import com.mercadolibre.fresh_market.repository.IReturnRepository;
import com.mercadolibre.fresh_market.service.IReturnService;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnServiceImpl implements IReturnService {

    @Autowired
    private IReturnRepository returnRepository;

    @Autowired
    private IPurchaseOrderRepository iPurchaseOrderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    @PreAuthorize("hasRole('ROLE_BUYER')")
    @Transactional
    public ResponseCreateReturnDTO createReturn(RequestReturnDTO newReturnDTO) {

        Returns newReturn = new Returns();

        PurchaseOrder order = iPurchaseOrderRepository.findById(newReturnDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(newReturnDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        newReturn.setPurchaseOrder(order);
        newReturn.setProduct(product);
        newReturn.setReason(newReturnDTO.getReason());
        newReturn.setDetails(newReturnDTO.getDetails());
        newReturn.setStatus("PENDIENTE");
        newReturn.setCreatedAt(LocalDateTime.now());
        newReturn.setUpdatedAt(null);

        Optional<Returns> existingReturn = returnRepository.findByPurchaseOrderAndProduct(order, product);
        if (existingReturn.isPresent()) {
            throw new ReturnAlreadyExistsException("Return already exists");
        }

        Returns savedReturn = returnRepository.save(newReturn);

        ResponseCreateReturnDTO response = new ResponseCreateReturnDTO();
        response.setReturnId(savedReturn.getId());
        response.setStatus(savedReturn.getStatus());
        response.setMessage("Return request created successfully");

        return response;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public List<ResponseReturnsDTO> getAllReturnsByStatus(String status) {

        List<Returns> returnsList;
        List<ResponseReturnsDTO> responseReturnsDTOList = List.of();

        if (status.equals("ALL")) {
            returnsList = returnRepository.findAll();
        } else {
            returnsList = returnRepository.findByStatusIgnoreCase(status);
        }

        responseReturnsDTOList = returnsList.stream()
                                    .map(this::convertToResponseReturnsDTO)
                                    .toList();

        if(responseReturnsDTOList.isEmpty()){
            throw new ReturnNotFoundException("No returns found whis status: " + "'" + status + "´  ");
        }

        return responseReturnsDTOList;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public ResponseUpdateReturnStatusDTO updateReturnStatus(Long id, RequestUpdateReturnStatusDTO requestUpdateReturnStatusDTO) {

        Returns returnToUpdate = returnRepository.findById(id)
                .orElseThrow(() -> new ReturnNotFoundException("Return not found"));

        returnToUpdate.setStatus(requestUpdateReturnStatusDTO.getStatus());
        returnToUpdate.setComments(requestUpdateReturnStatusDTO.getComments());
        returnToUpdate.setUpdatedAt(LocalDateTime.now());

        try {
            returnRepository.save(returnToUpdate);
        } catch (Exception e) {
            throw new ErrorUpdatingReturnException("Error updating return status");
        }

        return ResponseUpdateReturnStatusDTO.builder()
                .returnId(returnToUpdate.getId())
                .status(returnToUpdate.getStatus())
                .message("Return status updated successfully")
                .build();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_SELLER')")
    public ResponseReturnsDTO getReturnById(Long id) {

        Returns returns = returnRepository.findById(id)
                .orElseThrow(() -> new ReturnNotFoundException("Return not found"));

        return convertToResponseReturnsDTO(returns);
    }


    private ResponseReturnsDTO convertToResponseReturnsDTO(Returns returns) {
        return ResponseReturnsDTO.builder()
                .returnId(returns.getId())
                .status(returns.getStatus())
                .orderId(returns.getPurchaseOrder().getId())
                .productId(returns.getProduct().getId())
                .reason(returns.getReason())
                .timestamp(returns.getCreatedAt())
                .comments(returns.getComments())
                .build();
    }
}
