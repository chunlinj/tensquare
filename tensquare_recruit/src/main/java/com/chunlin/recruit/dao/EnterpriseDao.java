package com.chunlin.recruit.dao;

import com.chunlin.recruit.pojo.Enterprise;
import com.chunlin.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by  HASEE on 2018-12-10
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise> {
    /**
     * 根据热门状态获取企业列表
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);



}
