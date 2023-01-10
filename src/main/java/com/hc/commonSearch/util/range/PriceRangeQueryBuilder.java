package com.hc.commonSearch.util.range;

import com.hc.commonSearch.dto.SearchParam;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

public class PriceRangeQueryBuilder {

    public final static String PRICE_FIELD="price";

    public SearchParam buildPriceRangeQuery(SearchParam searchParam)
    {
        if(isMinRange(searchParam))
        {
            searchParam=buildMinPriceRangeQuery(searchParam);
        }
        else if(isBothRange(searchParam))
        {
            searchParam=buildBothPriceRangeQuery(searchParam);
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
        if(searchParam.getMinPrice()!=0&&searchParam.getMaxPrice()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isBothRange(SearchParam searchParam) {
        if(searchParam.getMinPrice()==0&&searchParam.getMaxPrice()==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
