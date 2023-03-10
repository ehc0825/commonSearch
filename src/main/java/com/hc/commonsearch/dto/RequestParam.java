package com.hc.commonsearch.dto;

import lombok.Data;

@Data
public class RequestParam {

    private String query;

    private String oldQuery;

    private String region;

    private String category;

    private int minPrice;

    private int maxPrice;

    private boolean research;

    private String sort;

    private int currentPage;

}
