package com.hc.commonSearch.util.sort;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hc.commonSearch.util.sort.AbstractSort.DATE_FIELD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class SortEnumTest {

    @Test
    void findSort(){
        boolean success = false;
        String sort="oldest";
        String findResult=SortEnum.find(sort).toString();
        if(findResult.equals("OLDEST"))
        {
            success=true;
        }
        assertThat(success).isTrue();
    }


    @Test
    void testBuildSortOrder(){
        boolean success = false;
        String sort="newest";
        SearchSourceBuilder searchSourceBuilder=SortEnum.buildSortOrderBySort(sort,new SearchSourceBuilder());
        if(searchSourceBuilder.toString().contains("asc") && searchSourceBuilder.toString().contains(DATE_FIELD))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

}