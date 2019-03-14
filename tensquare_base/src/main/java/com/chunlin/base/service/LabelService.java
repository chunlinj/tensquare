package com.chunlin.base.service;

import com.chunlin.base.dao.LabelDao;
import com.chunlin.base.pojo.Label;
import com.chunlin.common.service.impl.BaseServiceImpl;
import com.chunlin.common.util.BaseSpecification;
import com.chunlin.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by  HASEE on 2018-12-07
 */
@Service
public class LabelService extends BaseServiceImpl<Label> {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList=new ArrayList<>();
                if(searchMap.get("labelname")!=null &&
                        !"".equals(searchMap.get("labelname"))) {
                    predicateList.add(cb.like(
                            root.get("labelname").as(String.class), "%" + (String) searchMap.get("labelname") + "%"
                    ));
                }
                if(searchMap.get("recommend")!=null &&
                        !"".equals(searchMap.get("recommend"))){
                    predicateList.add(cb.like(
                            root.get("recommend").as(String.class), "%" + (String) searchMap.get("recommend") + "%"));
                }
                if(searchMap.get("state")!=null &&
                        !"".equals(searchMap.get("state"))){
                    predicateList.add(cb.like(
                            root.get("state").as(String.class), "%" + (String) searchMap.get("state") + "%" ));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    private Specification<Label> createSpecificationBase(Map searchMap){
        return new BaseSpecification(searchMap,new Label());
    }
    /**
     * 条件查询
     * @param searchMap
     * @return
     */
   /* public List<Label> findSearch(Map searchMap){
        Specification specification= createSpecification(searchMap);
        return labelDao.findAll( specification);
    }*/

    @Override
    protected JpaRepository<Label, String> getRepository() {
        return (JpaRepository<Label, String>) labelDao;
    }

    @Override
    protected JpaSpecificationExecutor<Label> getSpecification() {
        return (JpaSpecificationExecutor<Label>) labelDao;
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Label> findSearchBase(Map searchMap){
        Specification specification= createSpecificationBase(searchMap);
        return labelDao.findAll( specification);
    }

    /*public Page<Label> findSearchPage(Map searchMap, int page, int size) {
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification, pageRequest);
    }*/

}
