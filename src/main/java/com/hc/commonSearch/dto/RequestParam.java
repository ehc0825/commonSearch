package com.hc.commonSearch.dto;

import lombok.Data;

@Data
public class RequestParam {

    private String query;

    private String oldQuery;

    private int minPrice;

    private int maxPrice;

    private boolean research;

    private String sort;

}
