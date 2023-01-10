package com.hc.commonsearch.util.sort.sortOrders;

import com.hc.commonsearch.util.sort.AbstractSort;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class None  extends AbstractSort {

    public None(){
        this.sort = "none";
    }

    @Override
    public SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder) {
        return searchSourceBuilder;
    }
}
