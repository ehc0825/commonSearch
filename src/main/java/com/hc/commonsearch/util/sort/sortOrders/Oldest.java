package com.hc.commonsearch.util.sort.sortOrders;

import com.hc.commonsearch.util.sort.AbstractSort;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class Oldest  extends AbstractSort {

    public Oldest(){
        this.sort = "oldest";
    }

    @Override
    public SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder) {
        return searchSourceBuilder.sort(DATE_FIELD, SortOrder.DESC);
    }
}
