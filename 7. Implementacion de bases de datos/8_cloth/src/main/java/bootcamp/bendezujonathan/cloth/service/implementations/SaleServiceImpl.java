package bootcamp.bendezujonathan.cloth.service.implementations;


import bootcamp.bendezujonathan.cloth.dto.request.ClothSaleRequest;
import bootcamp.bendezujonathan.cloth.dto.request.SaleRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.dto.response.SaleResponse;
import bootcamp.bendezujonathan.cloth.exception.NotFoundException;
import bootcamp.bendezujonathan.cloth.model.Cloth;
import bootcamp.bendezujonathan.cloth.model.Sale;
import bootcamp.bendezujonathan.cloth.model.SaleDetail;
import bootcamp.bendezujonathan.cloth.repository.interfaces.SaleRepository;
import bootcamp.bendezujonathan.cloth.service.interfaces.ClothService;
import bootcamp.bendezujonathan.cloth.service.interfaces.SaleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final ClothService clothService;
    private final ModelMapper mapper;

    @Override
    public void create(SaleRequest request) {
        Sale toSave = requestToModel(request);
        repository.save(toSave);
    }

    @Override
    public void delete(Long id) {
        Sale model = findModelById(id);
        repository.delete(model);
    }

    @Override
    public void update(Long id, SaleRequest request) {
        Sale model = findModelById(id);
        Sale modelReq = requestToModel(request);
        mapper.map(modelReq, model);
        repository.save(modelReq);
    }

    @Override
    public List<SaleResponse> findAll() {
        return modelsToResponse(repository.findAll());
    }

    @Override
    public SaleResponse findById(Long id) {
        return modelToResponse(findModelById(id));
    }

    @Override
    public List<SaleResponse> findByDate(LocalDate date) {
        return modelsToResponse(repository.findAllByFecha(date));
    }

    @Override
    public List<ClothResponse> findAllBySale(Long id) {
        return repository.findClothBySale(id)
                .stream()
                .map(clothService::modelToResponse)
                .toList();
    }


    private Sale findModelById(long id) {
        return  repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Sale no found id [%d]", id)));
    }

    private SaleResponse modelToResponse(Sale model) {
        return mapper.map(model, SaleResponse.class);
    }

    private List<SaleResponse> modelsToResponse(List<Sale> models){
        return models.stream()
                .map(this::modelToResponse)
                .toList();
    }


    private Sale requestToModel(SaleRequest request) {
        Sale model = Sale.builder()
                .medioDePago(request.getMedioDePago())
                .build();

        Set<SaleDetail> details = requestToDetails(request.getPrendas(), model);

        Double total = details.stream()
                .mapToDouble(SaleDetail::calculateSubTotal)
                .sum();

        model.setTotal(total);
        model.setSaleDetails(details);
        return model;
    }

    private Set<SaleDetail> requestToDetails(List<ClothSaleRequest> requests, Sale model) {
        return requests
                .stream()
                .map(cloth -> toSaleDetail(cloth, model))
                .collect(Collectors.toSet());
    }

    private SaleDetail toSaleDetail(ClothSaleRequest request, Sale saleModel) {
        Cloth clothModel = clothService.findModelById(request.getId());
        return SaleDetail.builder()
                .precioIndividual(clothModel.getPrecioVenta())
                .cantidad(request.getCantidad())
                .sale(saleModel)
                .cloth(clothModel)
                .build();
    }


}
