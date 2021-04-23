package com.demo.login.web.servlet;

import com.demo.login.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User detailedUser =(User) req.getAttribute("detailedUser");
        resp.setContentType("text/html,charset=utf-8");
        resp.getWriter().write(detailedUser.toString()+"  "+"loginSuccess");
    }
}
