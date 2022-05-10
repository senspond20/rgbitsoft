package com.rgbitsoft.engine.repository;

import com.rgbitsoft.engine.index.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomUserSearchRepository {
    public List<User> searchByName(String name, Pageable pageable);
}
