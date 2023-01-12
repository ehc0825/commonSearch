package com.hc.commonsearch.util.query.sort.sortOrders;

import com.hc.commonsearch.util.query.sort.AbstractSort;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import static com.hc.commonsearch.config.SearchConfig.DATE_FIELD;

public class Newest extends AbstractSort {

    public Newest(){
        this.sort = "newest";
    }

    @Override
    public SearchSourceBuilder buildSort(SearchSourceBuilder searchSourceBuilder) {
        return searchSourceBuilder.sort(DATE_FIELD, SortOrder.ASC);
    }
}
