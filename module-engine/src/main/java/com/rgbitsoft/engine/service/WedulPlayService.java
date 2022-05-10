package com.rgbitsoft.engine.service;

import com.google.common.collect.Lists;
import com.rgbitsoft.engine.index.WedulPlay;
import com.rgbitsoft.engine.repository.WedulPlayRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * study
 *
 * @author wedul
 * @since 2019-02-09
 **/
@AllArgsConstructor
@NoArgsConstructor
@Service
public class WedulPlayService {

    private WedulPlayRepository wedulPlayRepository;

    public void save(WedulPlay play) {
        wedulPlayRepository.save(play);
    }

    public List<WedulPlay> findAll() {

    //    return wedulPlayRepository.findAll();
        return Lists.newArrayList(wedulPlayRepository.findAll());
    }

    public WedulPlay findByUser(String user) {
        return wedulPlayRepository.findByUser(user);
    }

}

