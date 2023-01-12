package com.hc.commonsearch.dto;

import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

@Data
public class SearchParam {

    private String query;

    private String oldQuery;

    private String region;

    private String category;

    private int minPrice;

    private int maxPrice;

    private boolean research;

    private String sort;

    private int currentPage;

    private BoolQueryBuilder boolQueryBuilder;

    private SearchSourceBuilder searchSourceBuilder;

    public void setSearchParam(RequestParam requestParam)
    {
        this.query=requestParam.getQuery();
        this.oldQuery=requestParam.getOldQuery();
        this.region=requestParam.getRegion();
        this.category=requestParam.getCategory();
        this.minPrice=requestParam.getMinPrice();
        this.maxPrice=requestParam.getMaxPrice();
        this.research=requestParam.isResearch();
        this.sort=requestParam.getSort();
        this.currentPage=requestParam.getCurrentPage();
        this.boolQueryBuilder=new BoolQueryBuilder();
        this.searchSourceBuilder=new SearchSourceBuilder();
    }

}
