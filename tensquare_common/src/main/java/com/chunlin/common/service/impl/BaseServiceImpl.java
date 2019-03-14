package com.chunlin.common.service.impl;

import com.chunlin.common.service.BaseService;
import com.chunlin.common.util.BaseSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by  HASEE on 2018-12-10
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract JpaRepository<T, String> getRepository();
    protected abstract JpaSpecificationExecutor<T> getSpecification();

    @Override
    public List findSearch(Map searchMap) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Specification specification= createSpecificationBase(searchMap);
        return getSpecification().findAll(specification);
    }

    private Specification<T> createSpecificationBase(Map searchMap) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Type type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String typeName = type.getTypeName();
        Object o = Class.forName(typeName).newInstance();
        return new BaseSpecification(searchMap,o);
    }

    @Override
    public Page<T> findSearchPage(Map searchMap, int page, int size) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Specification specification = createSpecificationBase(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return getSpecification().findAll(specification, pageRequest);
    }
}
