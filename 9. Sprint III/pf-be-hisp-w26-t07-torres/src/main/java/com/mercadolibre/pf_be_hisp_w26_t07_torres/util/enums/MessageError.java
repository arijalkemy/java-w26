package com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums;

import lombok.Getter;

@Getter
public enum MessageError {
    PRODUCT_LIST_NOT_EXIST("Product List Doesn't exist"),
    PRODUCT_NOT_FOUND("Product Not Found"),
    PRODUCTS_NOT_FOUND("Products Not Found"),
    PRODUCT_ID_NOT_FOUND("Products with ID %d Not Found"),
    PRODUCTS_STOCK("Products Out Of Stock"),
    PRODUCTS_INSUFFICIENT_STOCK("Product With Insufficient Stock to Fulfill Order"),
    PRODUCTS_EXPIRED("Products Expired"),
    PRODUCTS_CATEGORY_NOT_FOUND("The Product Category Doesn't Exist"),
    PRODUCTS_WAREHOUSE_NOT_FOUND("The Product Doesn't Exist In Any Warehouse"),
    PRODUCTS_BATCH_NOT_FOUND("The Product Doesn't Exist In Any Batch"),
    ORDER_NOT_FOUND("The Order With ID %d Is Not Found"),
    USER_ALREADY_HAS_AN_ORDER("The User Already Has A Pending Order"),
    WAREHOUSE_NOT_FOUND("Warehouse Not Found"),
    REPRESENTATIVE_NOT_ASSOCIATED_WITH_HOUSE("The Representative doesn't belong to the warehouse"),
    WAREHOUSE_ID_NOT_FOUND("Warehouse with ID %d Not Found"),
    REPRESENTATIVE_NOT_ASSOCIATED_WITH_WAREHOUSE("The Representative doesn't belong to the warehouse"),
    REPRESENTATIVE_NOT_FOUND("Representative Not Found"),
    REPRESENTATIVE_ID_NOT_FOUND("Representative whit ID %d Not Found"),
    BUYER_NOT_FOUND("Buyer Not Found"),
    BUYER_NOT_MATCHES_ORDER("Buyer With Id %d Does Not Match With Order's Id"),
    SELLER_NOT_FOUND("Seller Not Found"),
    SECTION_NOT_FOUND("The Sector Isn't Valid"),
    SECTION_ID_NOT_FOUND("The Sector with ID %d Isn't Valid"),
    SECTION_NOT_ASSOCIATED_WITH_PRODUCT("The Sector doesn't Correspond To The Type Of Product: %s"),
    SECTION_NO_AVAILABLE_SPACE("The Sector Has No Available space"),
    SECTION_NOT_ASSOCIATED_WITH_BATCH("The Sector Isn't Associated With a Batch"),
    SECTION_NOT_ASSOCIATED_WITH_WAREHOUSE("The sector Isn't Associated With a Warehouse"),
    BATCH_NOT_CREATED("Batch not created"),
    BATCH_NOT_UPDATED("Batch not Updated"),
    BATCH_NOT_FOUND_NUMBER("Batch with number %d Not Found"),
    BATCH_NOT_CONTAIN_PRODUCT("The Batch Doesn't Contain The Product"),
    INVENTORY_NOT_CREATED("The inventory record could not be created"),
    BATCH_SIZE_EXCCED("The Batch Size Exceeded"),
    INVENTARY_NOT_CREATED("The inventory record could not be created"),
    DATA_INVALID_SORTING("Invalid Date Sorting, Only Accepted:date_asc or date_desc"),
    INVALID_SORTING(
            "Invalid Sorting, Only Accepted: L = sorted by batch, C = sorted by current quantity, F = sorted by expiry date"),
    INVALID_CATEGORY(
            "Invalid sorting, Only Accepted: FS = Fresh, RF = Refrigerated, FF = Frozen "),
    STATUS_NOT_FOUND("The Status Has Not Been Found"),
    STATUS_INVALID("The Status Isn't Valid"),
    SELLER_LOGGED_NO_HAS_PERMISSIONS("The logged in seller with ID %d has no permissions"),
    PRODUCT_SELLER_DUPLICATED("The product %s associated to seller is duplicated"),
    STORAGE_TYPE_NOT_FOUND("Storage Type with name %s not found"),
    BATCH_DUPLICATED_PRODUCT("Batch with number %d and product is duplicated"),
    EMPTY_LIST_ERROR("The list of %s should not be empty");

    private final String message;

    MessageError(String message) {
        this.message = message;
    }

    public String getMessage(Long id) {
        return String.format(this.message, id);
    }

    public String getMessage(String additional) {
        return String.format(this.message, additional);
    }
}
