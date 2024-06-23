package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.PurchaseOrder;

public interface IPurchaseOrderServiceInternal {
    PurchaseOrder findPurchaseOrderById(Integer idPurchaseOrder);
}
