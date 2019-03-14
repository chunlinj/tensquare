package com.chunlin.common.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by  HASEE on 2018-12-10
 */
public interface BaseService<T> {
    /**
     * 查询全部
     * @param searchMap
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    List<T> findSearch(Map searchMap) throws IllegalAccessException, InstantiationException, ClassNotFoundException;

    /**
     * 分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<T> findSearchPage(Map searchMap, int page, int size) throws IllegalAccessException, InstantiationException, ClassNotFoundException;
}
