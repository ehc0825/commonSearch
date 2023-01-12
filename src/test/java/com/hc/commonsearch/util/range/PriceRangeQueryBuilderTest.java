package com.hc.commonsearch.util.range;

import com.hc.commonsearch.dto.SearchParam;
import com.hc.commonsearch.util.query.range.PriceRangeQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class PriceRangeQueryBuilderTest {

    @Test
    void testMinPriceRangeQuery()
    {
        boolean success = false;
        SearchParam searchParam=new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam.setMinPrice(10);
        searchParam= PriceRangeQueryBuilder.buildPriceRangeQuery(searchParam);
        if(searchParam.getBoolQueryBuilder().toString().contains("\"to\" : null")
                && searchParam.getBoolQueryBuilder().toString().contains("\"from\" : 10"))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

    @Test
    void testBothPriceRangeQuery()
    {
        boolean success = false;
        SearchParam searchParam= new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam.setMinPrice(10);
        searchParam.setMaxPrice(20);
        searchParam=PriceRangeQueryBuilder.buildPriceRangeQuery(searchParam);
        if(searchParam.getBoolQueryBuilder().toString().contains("\"to\" : 20")
                && searchParam.getBoolQueryBuilder().toString().contains("\"from\" : 10"))
        {
            success = true;
        }
        assertThat(success).isTrue();

    }
}