package com.hc.commonsearch.util.research;

import com.hc.commonsearch.dto.SearchParam;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class ResearchQueryBuilderTest {

    @Test
    void testBuildResearchQuery() {
        boolean success = false;

        String query = "검색어";
        String oldQuery = "이전검색어1,이전검색어2";
        String searchField = "contents";

        SearchParam searchParam = new SearchParam();
        searchParam.setSearchSourceBuilder(new SearchSourceBuilder());
        searchParam.setBoolQueryBuilder(new BoolQueryBuilder());
        searchParam.setQuery(query);
        searchParam.setOldQuery(oldQuery);
        searchParam.setResearch(true);

        searchParam = ResearchQueryBuilder.buildResearchQuery(searchParam);

        if (searchParam.getOldQuery().contains(query)) {
            for (String tempQuery : oldQuery.split(",")) {
                if (searchParam.getBoolQueryBuilder().toString().contains(tempQuery)) {
                    success = true;
                } else {
                    success = false;
                }
            }
            assertThat(success).isTrue();
        }
    }
}