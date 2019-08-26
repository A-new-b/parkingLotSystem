package servlet;

import Dao.Dao;
import Service.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String name =request.getParameter("name");
        String sex =request.getParameter("sex");
        String phone =request.getParameter("phone");
        user user=new user();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        user.setPhone(phone);
        Dao add=new Dao();
        add.add(user);

        request.setAttribute("login_msg","注册成功");
        request.getRequestDispatcher("/").forward(request,response);

    }

}
