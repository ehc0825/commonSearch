package com.hc.commonsearch.util.range;

import com.hc.commonsearch.dto.SearchParam;
import org.elasticsearch.index.query.QueryBuilders;

public class PriceRangeQueryBuilder {

    public static final String PRICE_FIELD="price";

    public SearchParam buildPriceRangeQuery(SearchParam searchParam)
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
                .must(QueryBuilders.rangeQuery(PRICE_FIELD).from(searchParam.getMinPrice()).to(searchParam.getMaxPrice())));
        return searchParam;
    }

    private SearchParam buildMinPriceRangeQuery(SearchParam searchParam) {
        searchParam.setBoolQueryBuilder(searchParam.getBoolQueryBuilder()
                .must(QueryBuilders.rangeQuery(PRICE_FIELD).from(searchParam.getMinPrice())));
        return searchParam;
    }

    private boolean isMinRange(SearchParam searchParam) {
        return searchParam.getMinPrice() != 0 && searchParam.getMaxPrice() == 0;
    }

    private boolean isBothRange(SearchParam searchParam) {
        return searchParam.getMinPrice() != 0 || searchParam.getMaxPrice() != 0;
    }
}
