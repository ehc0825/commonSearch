package com.hc.commonsearch.util.query.sort;


import com.hc.commonsearch.config.SearchConfig;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public abstract class AbstractSort implements SearchConfig {

    protected String sort;

    public abstract SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder);
}
