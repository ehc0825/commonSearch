package com.hc.commonsearch.util.query.category;

import com.hc.commonsearch.config.SearchConfig;
import com.hc.commonsearch.dto.SearchParam;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CategoryQueryBuilderTest implements SearchConfig {

    @Test
    void testBuildCategoryQuery(){
        boolean success = false;

        SearchParam searchParam = new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam.setCategory("카테고리1");
        searchParam = CategoryQueryBuilder.buildCategoryQuery(searchParam);
        if(searchParam.getBoolQueryBuilder().toString().contains(CATEGORY_FIELD)
                && searchParam.getBoolQueryBuilder().toString().contains(searchParam.getCategory()))
        {
            success = true;
        }

        assertThat(success).isTrue();
    }

    @Test
    void testBuildCategoryQueryWhenCategoryIsNull(){
        boolean success = false;

        SearchParam searchParam = new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam = CategoryQueryBuilder.buildCategoryQuery(searchParam);
        if(! searchParam.getBoolQueryBuilder().toString().contains(CATEGORY_FIELD))
        {
            success = true;
        }

        assertThat(success).isTrue();
    }
}