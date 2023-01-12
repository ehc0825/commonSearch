package com.hc.commonsearch.util.query.sort;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.search.builder.SearchSourceBuilder;
@UtilityClass
public class SortOrderBuilder {

    public SearchParam buildSortOrder(SearchParam searchParam){
        SearchSourceBuilder searchSourceBuilder=
                SortEnum.buildSortOrderBySort(searchParam.getSort(),searchParam.getSearchSourceBuilder());
        searchParam.setSearchSourceBuilder(searchSourceBuilder);
        return searchParam;
    }
}
