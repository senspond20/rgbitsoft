package com.rgbitsoft.engine.repository;

import com.google.common.collect.Lists;
import com.rgbitsoft.engine.index.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentRepositoryTest {

    @Autowired
    @Qualifier("contentRepository")
    private ContentRepository contentRepository;

//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;
    @Test
    public void create() {

      //  elasticsearchOperations.createIndex(Content.class);

        contentRepository.save(Content.builder().title("엘라스틴 하세요").content("엘라스틱헤어~ 부드러워요").build());
        contentRepository.save(Content.builder().title("자바씨에게 고백할래요").content("자바씨를 보다보니 빠져드네요").build());
        contentRepository.save(Content.builder().title("제목입니다").content("내용입니다").build());
        contentRepository.save(Content.builder().title("Title").content("Content is Content").build());

        List<Content> list = Lists.newArrayList(contentRepository.findAll());;
        list.forEach(System.out::println);
    }
    @Test
    public void select(){
        List<Content> list = Lists.newArrayList(contentRepository.findAll());;
        list.forEach(System.out::println);
    }

    @Test
    void test(){
        Content c = Content.builder().title("Title").content("Content is Content").build();
        System.out.println(c);
    }
}
