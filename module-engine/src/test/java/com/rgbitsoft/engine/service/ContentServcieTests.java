package com.rgbitsoft.engine.service;

import com.google.common.collect.Lists;
import com.rgbitsoft.engine.index.Content;
import com.rgbitsoft.engine.index.WedulPlay;
import com.rgbitsoft.engine.repository.ContentRepository;
import com.rgbitsoft.engine.repository.WedulPlayRepository;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServcieTests {

    @Autowired
    ContentService contentService;

    @Autowired(required = true)
    @Qualifier("contentRepository")
    ContentRepository contentRepository;


    @Test
    public void create(){
//        contentService = new ContentService(contentRepository);

        contentService.save(Content.builder().title("엘라스틴 하세요").content("엘라스틱헤어~ 부드러워요").build());
        contentService.save(Content.builder().title("자바씨에게 고백할래요").content("자바씨를 보다보니 빠져드네요").build());
        contentService.save(Content.builder().title("제목입니다").content("내용입니다").build());
        contentService.save(Content.builder().title("Title").content("Content is Content").build());
        contentService.findAll().forEach(System.out::println);
    }

    @Test
    public void select(){
//        contentService = new ContentService(contentRepository);
        contentService.findAll().forEach(System.out::println);
    }

    @Test
    public void update(){
        Content lc = contentService.findAll().get(0);
        String id = lc.getId();
        Content content = contentService.findById(id);

        assertEquals(lc, content);
        System.out.println(content);

        contentService.save(content.update("엘라스틱 틱 틱 !", "좋아용!!"));
        System.out.println(contentService.findById(id));
    }
}

