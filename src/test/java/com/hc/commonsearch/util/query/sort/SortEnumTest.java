package com.hc.commonsearch.util.query.sort;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hc.commonsearch.config.SearchConfig.DATE_FIELD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class SortEnumTest {

    @Test
    void findSort(){
        boolean success = false;
        String sort="oldest";
        String findResult= SortEnum.find(sort).toString();
        if(findResult.equals("OLDEST"))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

    @Test
    void testSearchSourceBuilderContainsSort(){
        boolean success = false;
        String sort="newest";
        SearchSourceBuilder searchSourceBuilder=SortEnum.buildSortOrderBySort(sort,new SearchSourceBuilder());
        if(searchSourceBuilder.toString().contains("asc") && searchSourceBuilder.toString().contains(DATE_FIELD))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

    @Test
    void testFindUnUsedSortOrder(){
        boolean success = false;
        String sort= "strangeString$%@#";
        String findResult=SortEnum.find(sort).toString();
        if(findResult.equals("NONE"))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

}