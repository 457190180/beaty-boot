package com.yimew.service.demo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.entity.demo.Demo;
import com.yimew.entity.demo.DemoQuery;
import com.yimew.entity.sys.BusinessLog;
import com.yimew.entity.sys.User;
import com.yimew.service.demo.DemoService;
import com.yimew.utils.PageUtils;
import com.yimew.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Service("demoService")
@Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = {Throwable.class})
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public DemoQuery getQuery(BasePage basePage) throws Exception {
        // 分页
        Integer limit = basePage.getLimit();
        Integer offset = basePage.getOffset();
        Integer pageNo = PageUtils.getPage(offset, limit);

        DemoQuery q = new DemoQuery();
        q.setPageNo(pageNo);
        q.setPageSize(limit);
        q.setStartRow(offset);
        //排序
        String sort = basePage.getSort();
        String order = basePage.getOrder();
        if (sort != null && order != null) {
            q.setOrderByClause(sort + " " + order);
        }

        //查询条件如下
        //......
        return q;
    }

    @Override
    public Demo getById(String id) throws Exception {
        return demoDao.selectByPrimaryKey(id);
    }

    @BusinessLog(description = "获取列表")
    @Override
    public PageInfo<Demo> getList(DemoQuery demoQuery) throws Exception {
        PageHelper.startPage(demoQuery.getPageNo(), demoQuery.getPageSize());
        PageInfo<Demo> pageInfo = new PageInfo<Demo>(demoDao.selectByExample(demoQuery));
        return pageInfo;
    }

    @Override
    public Integer countList(DemoQuery demoQuery) throws Exception {
        return demoDao.countByExample(demoQuery);
    }

    @Override
    public Demo insertSelective(Demo demo, User user) throws Exception {
        // Optional<User> optionalUser = Optional.ofNullable(user);
        // optionalUser.ma
        //boolean present = optionalUser.isPresent(demoDao.insertSelective(demo));
        demo.setDemoId(UUIDUtils.getUUID());
        demo.setCreateBy(user.getUserCode());
        demo.setCreateTime(new Date());
        demoDao.insertSelective(demo);
        return demo;
    }

    @Override
    public Demo insert(Demo demo, User user) throws Exception {
        demo.setCreateBy(user.getUserCode());
        demo.setCreateTime(new Date());
        demoDao.insert(demo);
        return demo;
    }

    @Override
    public Demo updateByPrimaryKeySelective(Demo demo, User user) throws Exception {
        demo.setUpdateBy(user.getUserCode());
        demo.setUpdateTime(new Date());
        demoDao.updateByPrimaryKeySelective(demo);
        return demo;
    }

    @Override
    public Demo updateByPrimaryKey(Demo demo, User user) throws Exception {
        demo.setUpdateBy(user.getUserCode());
        demo.setUpdateTime(new Date());
        demoDao.updateByPrimaryKey(demo);
        return demo;
    }

    @Override
    public Integer del(List<Demo> demos, User user) throws Exception {
        List<String> ids = new LinkedList<>();
        demos.forEach((demo) -> ids.add(demo.getDemoId()));
        DemoQuery demoQuery = new DemoQuery();
        demoQuery.createCriteria().andDemoIdIn(ids);
        return demoDao.deleteByExample(demoQuery);
    }
}
