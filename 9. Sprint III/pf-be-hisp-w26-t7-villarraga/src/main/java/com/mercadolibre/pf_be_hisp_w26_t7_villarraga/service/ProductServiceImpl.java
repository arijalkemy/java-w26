package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ListProductRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.LocationForProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductCreateResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.ProductSeller;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper.StockQuantityMapper;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper.WarehouseMapper;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.CategoryUtils;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.ProductUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private AuthDataUtil auth;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBatchRepository batchRepository;
    @Autowired
    private IProductSellerRepository productSellerRepository;
    @Autowired
    private IWarehouseRepository warehouseRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    @Autowired
    private IStorageTypeRepository storageTypeRepository;

    @Transactional(readOnly = true)
    protected Seller sellerById(Long id) throws NotFoundException {
        return sellerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.SELLER_NOT_FOUND.getMessage()));
    }

    @Transactional(readOnly = true)
    protected StorageType storageTypeByName(String name) throws NotFoundException {
        return storageTypeRepository.findByName(name).orElseThrow(() ->
                new NotFoundException(MessageError.STORAGE_TYPE_NOT_FOUND.getMessage(name)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getProducts(String category) {
        if (category != null) {
            if (!CategoryUtils.categoryExists(category)) throw new NotFoundException(
                    MessageError.INVALID_CATEGORY.getMessage());

            List<IProductResponseProjection> products = productSellerRepository.findAllByCategory(CategoryUtils.getCategory(category)
                    .toString());

            if (products.isEmpty()) throw new NotFoundException(
                    MessageError.PRODUCTS_CATEGORY_NOT_FOUND.getMessage());

            return ProductMapper.mapList(products);
        }

        List<IProductResponseProjection> products = productSellerRepository.findAllJoinProduct();

        if (products.isEmpty()) throw new NotFoundException(MessageError.PRODUCTS_NOT_FOUND.getMessage());

        return ProductMapper.mapList(products);
    }

    /**
     * Obtiene una lista de almacenes con información de id del Warehouse, la contienen el producto y el id del producto.
     * Si no se encuentran lotes del producto especificado en ningún almacén, se devuelve un código de estado "404 Not Found".
     *
     * @param idProduct El identificador del producto del cual se desea obtener la lista de lotes.
     * @return Un StockQuantityResponseDto que contiene la lista de almacenes con detalles de los lotes encontrados
     * @throws NotFoundException Si no se encuentra el producto o no hay lotes disponibles para el producto.
     */

    @Override
    @Transactional(readOnly = true)
    public StockQuantityResponseDto findStockQuantityForEachWarehouse(Long idProduct) {

        ProductSeller productSeller = productSellerRepository.findById(idProduct).orElse(null);
        if (productSeller == null)
            throw new NotFoundException(MessageError.PRODUCTS_NOT_FOUND.getMessage());

        List<IWarehouseBatchProduct> listFoodContainers = warehouseRepository
                .CalculationCuantityTheProductWarehouse(idProduct);

        if (listFoodContainers.isEmpty())
            throw new NotFoundException(MessageError.PRODUCTS_STOCK.getMessage());

        List<WarehouseResponseDTO> warehouseResponseDTOS = listFoodContainers
                .stream()
                .map(WarehouseMapper::mapToWarehouseResponseDTO)
                .toList();

        return StockQuantityMapper.mapToStockQuantityResponseDto(
                idProduct.intValue(),
                warehouseResponseDTOS);
    }

    @Override
    @Transactional(readOnly = true)
    public LocationForProductDTO checkLocationForProduct(Long idProduct, String order) {

        Long representativeId = auth.getIdSession();

        if (!ProductUtil.orderValidation(order)) {
            throw new BadRequestException(MessageError.INVALID_SORTING.getMessage());
        }
        ProductSeller product = productSellerRepository.findById(idProduct).orElseThrow(() ->
                new NotFoundException(MessageError.PRODUCT_NOT_FOUND.getMessage(idProduct)));

        List<IBatchSectionProductProjection> projections = batchRepository.findProductBySectionWarehouse(idProduct, representativeId);

        if (projections.isEmpty()) {
            throw new NotFoundException("The product was not found in any of the batches");
        }

        Set<Integer> batchNumbers = new HashSet<>();
        for (IBatchSectionProductProjection projection : projections) {
            if (!batchNumbers.add(projection.getBatchNumber())) {
                throw new BadRequestException("Product appears in the same batch multiple times");
            }
        }

        if (batchNumbers.size() < 2) {
            throw new BadRequestException("Product must appear in at least two different batches");
        }

        LocalDate currentDate = LocalDate.now();
        for (IBatchSectionProductProjection projection : projections) {
            LocalDate dueDate = projection.getDueDate();
            if (dueDate.isBefore(currentDate) || dueDate.minusWeeks(3).isBefore(currentDate)) {
                throw new BadRequestException("Product is expired or close to expiration");
            }
        }
        return ProductMapper.mapLocationForProductDTO(projections, order);
    }


    @Transactional
    protected Product createAndSaveProduct(String description, StorageType type) {
        Product newProduct = Product
                .builder()
                .description(description)
                .storageType(type)
                .build();
        return productRepository.save(newProduct);
    }

    /**
     * funcion para crear y ligar el producto a un vendedor
     *
     * @param price   precio de venta del producto
     * @param seller  vendedor al que se asociado el producto
     * @param product
     */
    @Transactional
    protected void createAndSaveProductSeller(BigDecimal price,
                                              Seller seller,
                                              Product product) {
        ProductSeller newProductSeller = ProductSeller
                .builder()
                .price(price)
                .seller(seller)
                .product(product)
                .build();
        productSellerRepository.save(newProductSeller);
    }

    @Transactional(readOnly = true)
    protected Seller validSellerLogonWithId(Long sellerId) {
        Long sellerLogon = auth.getIdSession();
        if (!Objects.equals(sellerLogon, sellerId)) {
            throw new NotFoundException(MessageError.SELLER_LOGGED_NO_HAS_PERMISSIONS.getMessage(sellerLogon));
        }
        return sellerById(sellerLogon);
    }

    /**
     * crear productos en base a una lista y asociarlo al vendedor
     * @param sellerId id del vendedor
     * @param products lista de productos a crear
     * @return objeto que indica la cantidad de productos que se procesaron
     */
    @Override
    @Transactional
    public ProductCreateResponseDto createProduct(Long sellerId, ListProductRequestDto products) {
        List<String> productFailed = new ArrayList<>();
        AtomicLong process = new AtomicLong();

        Seller seller = validSellerLogonWithId(sellerId);

        // Validar que tipo de storage es el producto
        products.getProducts().forEach(product -> {
            StorageType storageType = storageTypeByName(product.getStorageType());
            Optional<Product> productExists = productRepository.findByDescriptionAndStorageType(
                    product.getDescription(), storageType);
            Product productToSeller = productExists.orElse(null);
            if (productExists.isEmpty()) {
                productToSeller = createAndSaveProduct(product.getDescription(), storageType);
            }
            Optional<ProductSeller> productSellerExists = productSellerRepository.findByProductAndSeller(
                    productToSeller,
                    seller);
            if (productSellerExists.isPresent()) {
                productFailed.add(product.getDescription());
                return;
            }

            // asociar el producto al vendedor
            createAndSaveProductSeller(BigDecimal.valueOf(product.getPrice()), seller, productToSeller);
            process.getAndIncrement();
        });
        String messageResponse = !productFailed.isEmpty() ?
                (MessageError.PRODUCT_SELLER_DUPLICATED.getMessage(String.join(",", productFailed))) :
                "Productos creados";
        return ProductCreateResponseDto.builder()
                .code(200L)
                .message(messageResponse)
                .operation(process.get())
                .build();
    }

    /**
     * funcion para actualizar los productos asociados al vendedor
     * @param sellerId vendedor a consultar
     * @param products lista de productos que se insertan en product-seller
     * @return objeto que indica la cantidad de productos que se procesaron
     */
    @Override
    @Transactional
    public ProductCreateResponseDto updateProduct(Long sellerId, ListProductRequestDto products) {
        List<String> productFailed = new ArrayList<>();
        AtomicLong process = new AtomicLong();
        Seller seller = validSellerLogonWithId(sellerId);
        products.getProducts().forEach(currentProduct -> {
            StorageType storageType = storageTypeByName(currentProduct.getStorageType());
            Optional<Product> productExists = productRepository.findByDescriptionAndStorageType(
                    currentProduct.getDescription(), storageType);
            Product productToSeller = productExists.orElse(null);
            if (productExists.isEmpty()) {
                productFailed.add(currentProduct.getDescription());
                return;
            }
            Optional<ProductSeller> productSellerExists = productSellerRepository.findByProductAndSeller(
                    productToSeller,
                    seller);
            /*
            Si los productos se encuentran asoaciados al cliente se actualiza el mismo
            y se incrementa la cantidad de procesados
             */
            if (productSellerExists.isPresent()) {
                ProductSeller newProductSeller = productSellerExists.get();
                newProductSeller.setPrice(BigDecimal.valueOf(currentProduct.getPrice()));
                productSellerRepository.save(newProductSeller);
                process.getAndIncrement();
                return;
            }
            productFailed.add(currentProduct.getDescription());
        });
        String messageResponse = productFailed.isEmpty() ? "Productos actualizados" :
                MessageError.PRODUCT_SELLER_NOT_ASSOCIATED.getMessage(String.join(",", productFailed));
        return ProductCreateResponseDto.builder()
                .code(200L)
                .message(messageResponse)
                .operation(process.get())
                .build();
    }
}
