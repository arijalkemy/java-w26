package com.mercadolibre.project_be_java_hisp_w26_t7.util;

import org.springframework.data.domain.Sort;

public enum OrderEnum {

    DATE_ASC(Sort.by("dueDate").ascending()),
    DATE_DESC(Sort.by("dueDate").descending());

    private Sort sort;

    private OrderEnum(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }


}
