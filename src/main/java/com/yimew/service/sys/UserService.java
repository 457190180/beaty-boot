package com.yimew.service.sys;

import com.yimew.config.base.page.BasePage;
import com.yimew.config.base.service.BaseService;
import com.yimew.entity.exception.AuthorityException;
import com.yimew.entity.sys.User;
import com.yimew.entity.sys.UserQuery;


public interface UserService extends BaseService<User,BasePage,String,UserQuery> {

    /**
     * 检查用户权限
     *
     * @param user
     * @param departmentId
     * @param collegeId
     * @throws AuthorityException
     */
    void checkAuthority(User user, String collegeId, String departmentId) throws AuthorityException;

    void checkAuthority(User user, String collegeId) throws AuthorityException;


}
