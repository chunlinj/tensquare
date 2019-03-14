package com.chunlin.recruit.controller;

import com.chunlin.common.entity.Result;
import com.chunlin.common.entity.StatusCode;
import com.chunlin.recruit.service.EnterpriseService;
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
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(value="/search/hotlist",method=RequestMethod.GET)
//    @ApiImplicitParams({@ApiImplicitParam(value="searchMap",name ="searchMap")} )
    @ApiOperation(value="Get Result hotlist",response= Result.class)
    public Result hotlist(){
        return new Result(true, StatusCode.OK, "查询成功",
                enterpriseService.hotlist());
    }




}
