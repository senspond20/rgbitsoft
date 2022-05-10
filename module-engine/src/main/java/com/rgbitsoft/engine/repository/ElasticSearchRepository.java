package com.rgbitsoft.engine.repository;

import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

@NoRepositoryBean
public interface ElasticSearchRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

    Page<T> searchSimilar(T entity, @Nullable String[] fields, Pageable pageable);

}
