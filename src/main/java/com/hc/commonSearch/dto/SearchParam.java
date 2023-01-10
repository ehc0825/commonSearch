package com.hc.commonSearch.dto;

import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

@Data
public class SearchParam {

    private String query;

    private String oldQuery;

    private int minPrice;

    private int maxPrice;

    private String searchField;

    private boolean research;

    private String sort;

    private BoolQueryBuilder boolQueryBuilder;

    private SearchSourceBuilder searchSourceBuilder;

    public void setSearchParam(RequestParam requestParam)
    {
        this.query=requestParam.getQuery();
        this.oldQuery=requestParam.getOldQuery();
        this.minPrice=requestParam.getMinPrice();
        this.maxPrice=requestParam.getMaxPrice();
        this.research=requestParam.isResearch();
        this.sort=requestParam.getSort();
    }

}
