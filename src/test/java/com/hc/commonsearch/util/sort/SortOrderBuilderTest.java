package com.hc.commonsearch.util.sort;

import com.hc.commonsearch.dto.SearchParam;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        searchParam=SortOrderBuilder.buildSortOrder(searchParam);
        SearchSourceBuilder searchSourceBuilder= searchParam.getSearchSourceBuilder();
        if(searchSourceBuilder.toString().contains(AbstractSort.DATE_FIELD)
                &&searchSourceBuilder.toString().contains("desc")) {
            success=true;
        }
        assertThat(success).isTrue();
    }

}