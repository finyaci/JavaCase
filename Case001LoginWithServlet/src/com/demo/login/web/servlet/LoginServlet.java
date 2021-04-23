package com.demo.login.web.servlet;

import com.demo.login.dao.UserDao;
import com.demo.login.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");  // 防止中文乱码
        System.out.println("in do Post");

        //使用BeanUtils自动装配属性
        User loginUser = new User();
        Map<String, String[]> parameterMap = req.getParameterMap(); // 将来要被装配的属性
        for (String key : parameterMap.keySet()
        ) {
            String[] values = parameterMap.get(key);
            System.out.println(key + " " + Arrays.toString(values));
        }

        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


//        // 手动装配各个属性
//        String username = req.getParameter("userName");
//        String password = req.getParameter("userPassword");
//        User loginUser = new User();
//        loginUser.setUserPassword(password);
//        loginUser.setUserName(username);

        User detailedUser = new UserDao().login(loginUser);
        if (detailedUser != null) {
            System.out.println("Login Success");
            req.setAttribute("detailedUser", detailedUser);
            req.getRequestDispatcher("/loginSuccessServlet").forward(req, resp);
        } else {
            System.out.println("Login Failed");
            req.getRequestDispatcher("/loginFailServlet").forward(req, resp);
        }
    }
}
