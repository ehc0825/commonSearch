package com.hc.commonSearch.util.sort;

import com.hc.commonSearch.util.sort.sortOrders.Newest;
import com.hc.commonSearch.util.sort.sortOrders.None;
import com.hc.commonSearch.util.sort.sortOrders.Oldest;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Arrays;

public enum SortEnum {

    NEWEST(new Newest()),
    OLDEST(new Oldest()),
    NONE(new None());

    private AbstractSort abstractSort;
    SortEnum(AbstractSort abstractSort) {this.abstractSort=abstractSort;}


    public static SearchSourceBuilder buildSortOrderBySort(String sort, SearchSourceBuilder searchSourceBuilder)
    {
        return find(sort).abstractSort.buildSort(searchSourceBuilder);
    }

    public static SortEnum find(String sort)
    {
        return Arrays.stream(values())
                .filter(sortEnum -> sortEnum.abstractSort.sort.equals(sort))
                .findAny()
                .orElse(NONE);
    }

}
