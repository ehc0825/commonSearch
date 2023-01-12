package com.hc.commonsearch.util.query.category;

import com.hc.commonsearch.config.SearchConfig;
import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.QueryBuilders;

@UtilityClass
public class CategoryQueryBuilder implements SearchConfig {

    public SearchParam buildCategoryQuery(SearchParam searchParam) {
        if (isCategoryNotNull(searchParam)) {
            searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                    .must(QueryBuilders.termQuery(CATEGORY_FIELD, searchParam.getCategory())));
        }
        return searchParam;
    }

    private static boolean isCategoryNotNull(SearchParam searchParam) {
        return searchParam.getCategory() != null;
    }
}
