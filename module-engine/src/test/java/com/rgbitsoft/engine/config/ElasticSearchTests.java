package com.rgbitsoft.engine.config;

import com.rgbitsoft.engine.index.Content;
import com.rgbitsoft.engine.index.WedulPlay;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTests {

//    @Qualifier("elasticsearchOperations")
//    @Autowired
//    private ElasticsearchOperations template;

    @Autowired
    private ElasticsearchRestTemplate template;

    @Test
    public void creatIndexTest(){

    }
    @Test
    public void searchTest(){
       // WedulPlay play =elasticsearchOperations.queryForObject(GetQuery.getById("KnZjwoAB5yjmurfPjBa0"), WedulPlay.class);

        Content content = template.queryForObject(GetQuery.getById("sHb4woAB5yjmurfPiySj"), Content.class);
        System.out.println(content);
    }

    @Test
    public void queryDslSearchTest(){

        // queryDSL
        QueryBuilder query = QueryBuilders.boolQuery()
                                         .must(QueryBuilders.matchQuery("title", "제목입니다"))
                                         .mustNot(QueryBuilders.matchQuery("title", "사랑"));

        Query nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();

        SearchHits<Content> contents = template.search(nativeSearchQuery, Content.class);
        System.out.println(contents);
        contents.stream().map(x -> x.getContent()).forEach(System.out::println);




//        contents.getSearchHits()

//        contents.forEach();

//        List<Content> contents = template.queryForList(nativeSearchQuery, Content.class);
//        contents.forEach(System.out::println);
    }
    @Test
    void test(){
        Content c = Content.builder().title("Title").content("Content is Content").build();
        System.out.println(c);
    }
}
