package com.hc.commonSearch.util.sort.sortOrders;

import com.hc.commonSearch.util.sort.AbstractSort;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class Newest extends AbstractSort {

    public Newest(){
        this.sort = "newest";
    }

    @Override
    public SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder) {
        return searchSourceBuilder.sort(DATE_FIELD, SortOrder.ASC);
    }
}
