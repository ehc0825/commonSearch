package com.hc.commonSearch.util.sort;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public abstract class AbstractSort {

    public static final String DATE_FIELD="createDate";

    protected String sort;

    public abstract SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder);
}
