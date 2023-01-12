package com.hc.commonsearch.util.query.region;

import com.hc.commonsearch.config.SearchConfig;
import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.QueryBuilders;

@UtilityClass
public class RegionQueryBuilder implements SearchConfig {


    public SearchParam buildRegionQuery(SearchParam searchParam)
    {
        if(isRegionNotNull(searchParam))
        {
            searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                    .must(QueryBuilders.termQuery(REGION_FIELD,searchParam.getRegion())));
        }
        return searchParam;
    }

    private static boolean isRegionNotNull(SearchParam searchParam) {
        return searchParam.getRegion() != null ;
    }

}
