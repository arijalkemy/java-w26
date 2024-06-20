package com.mercadolibre.fresh_market.config.dataloader;

import com.mercadolibre.fresh_market.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private List<User> users;
    private List<Warehouse> warehouses;
    private List<Section> sections;
    private List<Product> products;
    private List<PurchaseOrder> purchase_orders;
    private List<CartDetail> cart_details;
    private List<InboundOrder> inbound_orders;
    private List<Batch> batches;


}