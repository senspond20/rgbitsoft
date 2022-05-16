package com.rgbitsoft.engine.repository;

import com.rgbitsoft.engine.index.Content;
import com.rgbitsoft.engine.index.WedulPlay;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("contentRepository")
public interface ContentRepository extends ElasticsearchRepository<Content, String> {

}
