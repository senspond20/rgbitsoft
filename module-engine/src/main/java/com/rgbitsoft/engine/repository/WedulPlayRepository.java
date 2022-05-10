package com.rgbitsoft.engine.repository;


import com.rgbitsoft.engine.index.WedulPlay;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * study
 *
 * @author wedul
 * @since 2019-02-09
 **/
@Repository("wedulPlayRepository")
public interface WedulPlayRepository extends ElasticsearchRepository<WedulPlay, String> {

    WedulPlay findByUser(String user);

}


