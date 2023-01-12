package com.hc.commonsearch.util.sort;

import com.hc.commonsearch.dto.SearchParam;
import com.hc.commonsearch.util.query.sort.SortOrderBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hc.commonsearch.config.SearchConfig.DATE_FIELD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SortOrderBuilderTest {

    @Test
    void testBuildSortOrderByOldestOption()
    {
        boolean success=false;
        SearchParam searchParam=new SearchParam();
        searchParam.setSort("oldest");
        searchParam.setSearchSourceBuilder(new SearchSourceBuilder());
        searchParam= SortOrderBuilder.buildSortOrder(searchParam);
        SearchSourceBuilder searchSourceBuilder= searchParam.getSearchSourceBuilder();
        if(searchSourceBuilder.toString().contains(DATE_FIELD)
                &&searchSourceBuilder.toString().contains("desc")) {
            success=true;
        }
        assertThat(success).isTrue();
    }

}