package com.hc.commonsearch.util.query.region;

import com.hc.commonsearch.dto.SearchParam;
import com.hc.commonsearch.util.query.region.RegionQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hc.commonsearch.config.SearchConfig.REGION_FIELD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RegionQueryBuilderTest{
    
    @Test
    void testBuildRegionQuery() {
        boolean success = false;
        SearchParam searchParam = new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam.setRegion("지역");
        searchParam= RegionQueryBuilder.buildRegionQuery(searchParam);
        if(searchParam.getBoolQueryBuilder().toString().contains(REGION_FIELD)
                && searchParam.getBoolQueryBuilder().toString().contains(searchParam.getRegion()))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }
    
    @Test
    void testBuildRegionQueryWhenRegionIsNull()
    {
        boolean success = false;
        SearchParam searchParam = new SearchParam();
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam=RegionQueryBuilder.buildRegionQuery(searchParam);
        if(! searchParam.getBoolQueryBuilder().toString().contains(REGION_FIELD))
        {
            success = true;
        }
        assertThat(success).isTrue();
    }

}