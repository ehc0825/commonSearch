package com.hc.commonsearch.util.query.category;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.QueryBuilders;

import static com.hc.commonsearch.config.SearchConfig.CATEGORY_FIELD;

@UtilityClass
public class CategoryQueryBuilder{

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
