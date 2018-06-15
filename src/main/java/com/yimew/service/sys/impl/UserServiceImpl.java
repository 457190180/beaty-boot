package com.yimew.service.sys.impl;

import com.github.pagehelper.PageInfo;
import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseServiceImpl;
import com.yimew.entity.exception.AuthorityException;
import com.yimew.entity.sys.User;
import com.yimew.entity.sys.UserQuery;
import com.yimew.service.sys.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年11月1日 下午1:09:  * @version 1.0
 * * @parameter * @since * @return
 */
@Service("userService")
@Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = {Throwable.class})
public class UserServiceImpl  extends BaseServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public void checkAuthority(User user, String collegeId, String departmentId) throws AuthorityException {

    }

    @Override
    public void checkAuthority(User user, String collegeId) throws AuthorityException {

    }

    @Override
    public UserQuery getQuery(BasePage basePage) throws Exception {
        return null;
    }

    @Override
    public User getById(String id) throws Exception {
        return null;
    }

    @Override
    public PageInfo<User> getList(UserQuery userQuery) throws Exception {
        return null;
    }

    @Override
    public Integer countList(UserQuery userQuery) throws Exception {
        return null;
    }


    @Override
    public User insertSelective(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public User insert(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public User updateByPrimaryKeySelective(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public User updateByPrimaryKey(User user, User user2) throws Exception {
        return null;
    }

    @Override
    public Integer del(List<User> strings, User user) throws Exception {
        return null;
    }
}
