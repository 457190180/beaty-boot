package com.yimew.controller.api;

import com.github.pagehelper.PageInfo;
import com.yimew.config.base.controller.BaseController;
import com.yimew.config.base.page.BasePage;
import com.yimew.entity.demo.Demo;
import com.yimew.utils.ErrorUtils;
import com.yimew.utils.http.ResponseMessage;
import com.yimew.utils.http.Result;
import com.yimew.web.DataGrid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/app/demo")
@Api(description = "demoController")
public class DemoController extends BaseController<Demo> {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "demo新增")
    public @ResponseBody
    ResponseMessage add(@RequestBody @Validated Demo demo, Errors errors, HttpServletRequest request) throws Exception  {
        if (errors.hasErrors()) {
            return Result.error(ErrorUtils.getErrorInfo(errors));
        }
        return Result.success( demoService.insertSelective(demo, getUser()));
    }

    @RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation(value = "demo编辑")
    public @ResponseBody
    ResponseMessage edit(@RequestBody @Validated Demo demo, Errors errors, HttpServletRequest request) throws Exception  {
        if (errors.hasErrors()) {
            return Result.error(ErrorUtils.getErrorInfo(errors));
        }
        return Result.success( demoService.updateByPrimaryKeySelective(demo, getUser()));
    }

    @RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ApiOperation(value = "demo列表")
    public @ResponseBody
    ResponseMessage getList(@Validated BasePage basePage, Errors errors, HttpServletRequest request) throws Exception  {
        if (errors.hasErrors()) {
            return Result.error(ErrorUtils.getErrorInfo(errors));
        }

        PageInfo<Demo> demoPageInfo = demoService.getList(demoService.getQuery(basePage));
        return Result.success(new DataGrid(demoPageInfo.getTotal(),demoPageInfo.getList()));
    }

    @RequestMapping(value = "/{id}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ApiOperation(value = "demo详情")
    public @ResponseBody
    ResponseMessage getById(@PathVariable("id") String id , HttpServletRequest request) throws Exception  {
        Optional<String> optId =  Optional.ofNullable(id);
        if(!optId.isPresent()){
            return Result.error("id can't be empty");
        }
        return Result.success(demoService.getById(id));
    }

    @RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = RequestMethod.DELETE,consumes = "application/json")
    @ApiOperation(value = "demo删除")
    public @ResponseBody
    ResponseMessage del(@RequestBody @Validated List<Demo> demos , HttpServletRequest request) throws Exception  {
        demoService.del(demos, getUser());
        return Result.success();
    }




}
