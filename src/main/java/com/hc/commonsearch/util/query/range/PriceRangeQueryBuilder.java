package com.hc.commonsearch.util.query.range;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.QueryBuilders;

import static com.hc.commonsearch.config.SearchConfig.PRICE_FIELD;

@UtilityClass
public class PriceRangeQueryBuilder {


    public static SearchParam buildPriceRangeQuery(SearchParam searchParam)
    {
        if(isMinRange(searchParam))
        {
            buildMinPriceRangeQuery(searchParam);
        }
        else if(isBothRange(searchParam))
        {
            buildBothPriceRangeQuery(searchParam);
        }
        return searchParam;
    }

    private SearchParam buildBothPriceRangeQuery(SearchParam searchParam) {
        searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                .must(QueryBuilders.rangeQuery(PRICE_FIELD).gte(searchParam.getMinPrice()).lte(searchParam.getMaxPrice())));
        return searchParam;
    }

    private SearchParam buildMinPriceRangeQuery(SearchParam searchParam) {
        searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                .must(QueryBuilders.rangeQuery(PRICE_FIELD).gte(searchParam.getMinPrice())));
        return searchParam;
    }

    private boolean isMinRange(SearchParam searchParam) {
        return searchParam.getMinPrice() != 0 && searchParam.getMaxPrice() == 0;
    }

    private boolean isBothRange(SearchParam searchParam) {
        return searchParam.getMinPrice() != 0 || searchParam.getMaxPrice() != 0;
    }
}
