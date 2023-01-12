package com.hc.commonsearch.util.pagination;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PageTest {

    @Test
    void testPageWhenCurrentPageIsSevenThenBeginPageIsSix(){
        boolean success=false;

        Page page=new Page(100,7);

        if(page.getBeginPage()==6 && page.getEndPage()==10)
        {
            success=true;
        }

        assertThat(success).isTrue();
    }

}