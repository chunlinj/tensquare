package com.chunlin.common.util;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by  HASEE on 2018-12-10
 */
public class BaseSpecification<T> implements Specification {
    private Map searchMap;
    private T pojo;

    public BaseSpecification(Map searchMap, T t) {
        this.searchMap = searchMap;
        this.pojo = t;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
        List<Predicate> predicateList=new ArrayList<>();
        Class clazz=pojo.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields){
            f.setAccessible(true);
            String name = f.getName();
            if (name.equals("id")) continue;
            if(searchMap.get(name)!=null &&
                    !"".equals(searchMap.get(name))){
                predicateList.add(cb.like(
                        root.get(name).as(String.class), "%" + (String) searchMap.get(name) + "%"));
            }
        }
        return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
    }
}
