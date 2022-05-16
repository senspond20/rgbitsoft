package com.rgbitsoft.engine.service;

import com.google.common.collect.Lists;
import com.rgbitsoft.engine.index.Content;
import com.rgbitsoft.engine.index.WedulPlay;
import com.rgbitsoft.engine.repository.ContentRepository;
import com.rgbitsoft.engine.repository.WedulPlayRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public void save(Content content) {
        contentRepository.save(content);
    }

    public Content findById(String id){
        return contentRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    public List<Content> findAll() {
        return Lists.newArrayList(contentRepository.findAll());
    }


}
