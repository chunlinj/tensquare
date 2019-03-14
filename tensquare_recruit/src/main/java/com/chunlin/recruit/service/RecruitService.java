package com.chunlin.recruit.service;

import com.chunlin.common.service.impl.BaseServiceImpl;
import com.chunlin.recruit.dao.EnterpriseDao;
import com.chunlin.recruit.dao.RecruitDao;
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
public class RecruitService extends BaseServiceImpl {
    @Autowired
    private RecruitDao recruitDao;
    @Override
    protected JpaRepository getRepository() {
        return recruitDao;
    }

    @Override
    protected JpaSpecificationExecutor getSpecification() {
        return recruitDao;
    }


    /**
     * 更具时间倒序查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }
    /**
     * 状态不为0
     * @param
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc() {
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
