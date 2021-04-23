package com.demo.login.test;

import com.demo.login.dao.UserDao;
import com.demo.login.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testlogin(){
        User userLogin = new User();
        userLogin.setUserName("Jackie");
        userLogin.setUserPassword("1002Jackie");

        User userDetailed = new UserDao().login(userLogin);
        System.out.println(userDetailed.toString());

    }
}
