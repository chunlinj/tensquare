package com.chunlin.recruit.controller;

import com.chunlin.common.entity.Result;
import com.chunlin.common.entity.StatusCode;
import com.chunlin.recruit.service.EnterpriseService;
import com.chunlin.recruit.service.RecruitService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  HASEE on 2018-12-10
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value="/search/recommend",method=RequestMethod.GET)
//    @ApiImplicitParams({@ApiImplicitParam(value="searchMap",name ="searchMap")} )
    @ApiOperation(value="findTop4ByStateOrderByCreatetimeDesc",response= Result.class)
    public Result findTop4ByStateOrderByCreatetimeDesc(){
        return new Result(true, StatusCode.OK, "查询成功",
                recruitService.findTop4ByStateOrderByCreatetimeDesc("2"));
    }
    @RequestMapping(value="/search//newlist",method=RequestMethod.GET)
//    @ApiImplicitParams({@ApiImplicitParam(value="searchMap",name ="searchMap")} )
    @ApiOperation(value="findTop12ByStateNotOrderByCreatetimeDesc",response= Result.class)
    public Result findTop12ByStateNotOrderByCreatetimeDesc(){
        return new Result(true, StatusCode.OK, "查询成功",
                recruitService.findTop12ByStateNotOrderByCreatetimeDesc());
    }




}
