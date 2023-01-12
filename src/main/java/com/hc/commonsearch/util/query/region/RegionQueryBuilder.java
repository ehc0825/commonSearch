package com.hc.commonsearch.util.query.region;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.QueryBuilders;

import static com.hc.commonsearch.config.SearchConfig.REGION_FIELD;

@UtilityClass
public class RegionQueryBuilder {


    public SearchParam buildRegionQuery(SearchParam searchParam) {
        if (isRegionNotNull(searchParam)) {
            searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                    .must(QueryBuilders.termQuery(REGION_FIELD, searchParam.getRegion())));
        }
        return searchParam;
    }

    private static boolean isRegionNotNull(SearchParam searchParam) {
        return searchParam.getRegion() != null;
    }

}
