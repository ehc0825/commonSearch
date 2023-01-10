package com.hc.commonsearch.util.sort;

import com.hc.commonsearch.dto.SearchParam;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class SortOrderBuilder {

    public SearchParam buildSortOrder(SearchParam searchParam){
        SearchSourceBuilder searchSourceBuilder=
                SortEnum.buildSortOrderBySort(searchParam.getSort(),searchParam.getSearchSourceBuilder());
        searchParam.setSearchSourceBuilder(searchSourceBuilder);
        return searchParam;
    }
}
