package com.chunlin.recruit.dao;

import com.chunlin.recruit.pojo.Enterprise;
import com.chunlin.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by  HASEE on 2019-01-06
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit> {
    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);
    /**
     * 最新职位列表
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
