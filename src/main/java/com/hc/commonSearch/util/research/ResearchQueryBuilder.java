package com.hc.commonSearch.util.research;

import com.hc.commonSearch.dto.SearchParam;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public class ResearchQueryBuilder {

    public SearchParam buildResearchQuery(SearchParam searchParam) {
        if (searchParam.isResearch()) {
            String[] oldMustQueries = splitOldMustQuery(searchParam);
            searchParam = buildOldMustQuery(searchParam, oldMustQueries);
            searchParam = setOldQuery(searchParam);
        }
        return searchParam;
    }

    private SearchParam setOldQuery(SearchParam searchParam) {
        String oldQuery = searchParam.getOldQuery();
        oldQuery += "," + searchParam.getQuery();
        searchParam.setOldQuery(oldQuery);
        return searchParam;
    }

    private SearchParam buildOldMustQuery(SearchParam searchParam, String[] oldMustQueries) {
        BoolQueryBuilder boolQueryBuilder = searchParam.getBoolQueryBuilder();
        for (String mustQuery : oldMustQueries) {
            boolQueryBuilder.must(QueryBuilders.termQuery(searchParam.getSearchField(), mustQuery));
        }
        searchParam.setBoolQueryBuilder(boolQueryBuilder);
        return searchParam;
    }

    private String[] splitOldMustQuery(SearchParam searchParam) {
        return searchParam.getOldQuery().split(",");
    }

}
