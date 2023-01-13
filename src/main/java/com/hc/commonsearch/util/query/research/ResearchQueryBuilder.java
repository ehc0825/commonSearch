package com.hc.commonsearch.util.query.research;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import static com.hc.commonsearch.config.SearchConfig.DEFAULT_SEARCH_FIELD;

@UtilityClass
public class ResearchQueryBuilder {

    public SearchParam buildResearchQuery(SearchParam searchParam) {
        if (searchParam.isResearch()) {
            String[] oldMustQueries = splitOldMustQuery(searchParam);
            buildOldMustQuery(searchParam, oldMustQueries);
            setOldQuery(searchParam);
        }
        return searchParam;
    }

    private void setOldQuery(SearchParam searchParam) {
        String oldQuery = searchParam.getOldQuery();
        oldQuery += "," + searchParam.getQuery();
        searchParam.setOldQuery(oldQuery);
    }

    private void buildOldMustQuery(SearchParam searchParam, String[] oldMustQueries) {
        BoolQueryBuilder boolQueryBuilder = searchParam.getBoolQueryBuilder();
        for (String mustQuery : oldMustQueries) {
            boolQueryBuilder.must(QueryBuilders.termQuery(DEFAULT_SEARCH_FIELD, mustQuery));
        }
        searchParam.setBoolQueryBuilder(boolQueryBuilder);
    }

    private String[] splitOldMustQuery(SearchParam searchParam) {
        return searchParam.getOldQuery().split(",");
    }

}
