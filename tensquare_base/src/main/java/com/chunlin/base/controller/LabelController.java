package com.chunlin.base.controller;

import com.chunlin.base.service.LabelService;
import com.chunlin.common.entity.Result;
import com.chunlin.common.entity.StatusCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by  HASEE on 2018-12-07
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

  /*  @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearch(searchMap));
    }

    @RequestMapping(value = "/search/base",method = RequestMethod.POST)
    public Result findSearchBase(@RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearchBase(searchMap));
    }*/

    @RequestMapping(value = "/search/baseService",method = RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(value="searchMap",name ="searchMap")} )
    @ApiOperation(value="Get Label List",response= Result.class)
    public Result findSearchbaseService(@RequestBody Map searchMap) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearch(searchMap));
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(value="searchMap",name ="searchMap"),@ApiImplicitParam(value="page",name ="page"),@ApiImplicitParam(value="size",name ="size")} )
    @ApiOperation(value="Get Label List",response= Result.class)
    public Result  findSearch(@RequestBody Map searchMap,@PathVariable int page,@PathVariable int size) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearchPage(searchMap,page,size));
    }
}
