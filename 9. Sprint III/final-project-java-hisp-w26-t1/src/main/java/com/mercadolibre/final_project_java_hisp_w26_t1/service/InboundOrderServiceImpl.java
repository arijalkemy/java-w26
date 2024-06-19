package com.mercadolibre.final_project_java_hisp_w26_t1.service;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.*;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.*;
import com.mercadolibre.final_project_java_hisp_w26_t1.exceptions.ApiException;
import com.mercadolibre.final_project_java_hisp_w26_t1.repository.IInboundOrderRepository;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.*;
import com.mercadolibre.final_project_java_hisp_w26_t1.util.BatchMapper;
import com.mercadolibre.final_project_java_hisp_w26_t1.util.InboundOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class InboundOrderServiceImpl implements IInboundOrdenService {

    private final IInboundOrderRepository inboundOrderRepository;
    private final IWarehouseServiceInternal warehouseService;
    private final ISectionServiceInternal sectionServiceInternal;
    private final IProductServiceInternal productServiceInternal;
    private final IBatchService batchService;
    private final IBatchServiceInternal batchServiceInternal;


    /**
     * Este método crea y guarda en la bade de datosuna orden de ingreso, valida que el warehouse exista,
     * que el usuario sea representante del warehouse y si el sector del warehouse tiene suficiente espacio para
     * guardar la carga, en caso de que alguna de estas validaciones falle se lanzará una excepción.
     * @param inboundOrderRequestDTO InboundOrderRequestDTO
     * @param emailUser String
     * @return List<Batch>
     */
    @Override
    @Transactional
    public BatchStockResponseDTO create(InboundOrderDto inboundOrderRequestDTO, String emailUser) {

        if(inboundOrderRepository.existsById(inboundOrderRequestDTO.getOrderNumber())){
            throw new ApiException
                            ("Bad request",
                            "Ya existe una orden con el order_number: " + inboundOrderRequestDTO.getOrderNumber(),
                            400);
        }

        //valida que le warehouse exista
        int idWarehouse = inboundOrderRequestDTO.getSection().getWarehouse_code();
        Warehouse warehouse = warehouseService.findWarehouseById(idWarehouse);

        // Valida que el usuario es representante del warehouse
        userIsManagerWarehouse(warehouse, emailUser);

        //Valida el sector, si tiene espacio suficiente y si pertenece al warehouse
        int idSection = inboundOrderRequestDTO.getSection().getSection_code();
        Section section = sectionServiceInternal
                .searchAndValidateByWarehouseAndQuantity(
                        idSection, idWarehouse, inboundOrderRequestDTO.getBatchStock().size());

        //Valida los productos del lote, y devuelve la lista
        List<Batch> batchList = createBatchList(inboundOrderRequestDTO.getBatchStock(), section);

        //Guardar inboundOrder
        InboundOrder inboundOrder = InboundOrderMapper.InboundOrderRequestDtoToInboundOrder
                                                        (inboundOrderRequestDTO, section);

        InboundOrder inboundOrderResponse = inboundOrderRepository.save(inboundOrder);

        batchList.forEach(batch ->{
            batch.setInboundOrder(inboundOrderResponse);
        });

        List<BatchStockDTO> batchStockDTOS =  batchService.addBatchesList(batchList);

        return new BatchStockResponseDTO(batchStockDTOS);
    }

    @Override
    public BatchStockResponseDTO update(InboundOrderDto inboundOrderRequestDTO, String emailUser) {

        InboundOrder inboundOrder = inboundOrderRepository.findById(inboundOrderRequestDTO.getOrderNumber())
                .orElseThrow(() -> new ApiException("NotFound", "No se encontró la orden de ingreso", 404));

        //valida que le warehouse exista
        int idWarehouse = inboundOrderRequestDTO.getSection().getWarehouse_code();
        Warehouse warehouse = warehouseService.findWarehouseById(idWarehouse);

        // Valida que el usuario es representante del warehouse
        userIsManagerWarehouse(warehouse, emailUser);

        int idSection = inboundOrderRequestDTO.getSection().getSection_code();
        Section section = sectionServiceInternal
                        .searchAndValidateByWarehouseAndQuantity(
                        idSection, idWarehouse, inboundOrderRequestDTO.getBatchStock().size());


        List<BatchStockDTO> batchentrantes = inboundOrderRequestDTO.getBatchStock();
        List<Batch>batchActuales = inboundOrder.getBatches();


        //recorremos la lista de batch
        // los que no existen en la base de datos los agregamos
        // si existen en la base de datos los actualizamos
        List<Batch> batchList = new ArrayList<>();

        batchentrantes.forEach( b ->{
            //validamos si el batch tiene producto valido
            Product product = validateProduct(b.getProduct_id(), section);
            Batch batch = batchServiceInternal.getEntityByIdOrNull(b.getBatch_number());
            if(batch == null ){
                // este batch no existe, hay que crearlo
                batch = BatchMapper.toBatch(b, product);
                batch.setInboundOrder(inboundOrder);
            }else{
                //si este batch existe se se guadra con nuevos datos
                batch = BatchMapper.toBatch(b, product);
            }

            batchList.add(batch);
        });


        //los batchs que no vienen en la peticion de put se deben borrar
        List<Batch> batchesABorrar = batchActuales.stream().filter(
                b -> !batchentrantes.contains(BatchMapper.toBatchStockDTO(b))
        ).toList();
        batchServiceInternal.DeleteBatchList(batchesABorrar);

        inboundOrder.setBatches(batchList);
        inboundOrderRepository.save(inboundOrder);

        List<BatchStockDTO> batchStockDTOS =  batchService.addOrUpdateBatchesList(batchList);

        return new BatchStockResponseDTO(batchStockDTOS);
    }




    /**
     * Este método crea una lista de batch primero verifica que el producto sea valido y luego los asigna al batch.
     * IMPORTANTE: este metodo no guarda en la base de datos
     * @param listBatchStock List<BatchStockDTO>
     * @param section Section
     * @return List<Batch>
     */

     private List<Batch> createBatchList(List<BatchStockDTO> listBatchStock, Section section){
        //verifica que todos los productos sean validos
         List<Batch> batchList = new ArrayList<>();
        listBatchStock.stream().forEach( b ->{
           Product product = validateProduct(b.getProduct_id(), section);
           Batch batch = BatchMapper.toBatch(b, product);
           batchList.add(batch);
        });
        return batchList;
    }
    /**
     * Este método valida que el producto exista y que pertenezca al mismo tipo de producto
     * @param idProduct int
     * @param section Section
     * @return boolean
     */
    private Product validateProduct(int idProduct, Section section){
        Product product = productServiceInternal.findById(idProduct);

        if(!section.getCategory().getId().equals(product.getCategory().getId())){
            throw new ApiException("NotFound","El producto con id: "+product.getCategory().getId()+", no " +
                    "corresponde al mismo tipo que sección.",400);
        }

        return product;
    }

    /**
     * Este método valida que el usuario sea el manager del warehouse
     * @param warehouse
     * @param emailUser
     * @return boolean or throw exception
     */
    private boolean userIsManagerWarehouse(Warehouse warehouse, String emailUser){
        if(!warehouse.getManager().getEmail().equals(emailUser))    {
            throw new ApiException("","El usuario no es representante del warehouse",400);
        }

        return true;
    }


}
