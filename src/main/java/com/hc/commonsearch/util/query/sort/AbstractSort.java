package com.hc.commonsearch.util.query.sort;

import org.elasticsearch.search.builder.SearchSourceBuilder;


public abstract class AbstractSort {

    protected String sort;

    public abstract SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder);
}
