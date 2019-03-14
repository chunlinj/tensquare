package com.chunlin.recruit.service;

import com.chunlin.common.service.impl.BaseServiceImpl;
import com.chunlin.recruit.dao.EnterpriseDao;
import com.chunlin.recruit.pojo.Enterprise;
import com.chunlin.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by  HASEE on 2018-12-10
 */
@Service
@Transactional
public class EnterpriseService extends BaseServiceImpl {
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Override
    protected JpaRepository getRepository() {
        return enterpriseDao;
    }

    @Override
    protected JpaSpecificationExecutor getSpecification() {
        return enterpriseDao;
    }

    /**
     * 热门企业列表
     * @return
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIshot("1");
    }

}
