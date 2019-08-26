package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import Dao.Dao;
import Service.user;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        user user=new user();
        user.setUsername(username);
        user.setPassword(password);
        Dao dao=new Dao();
        user resultUser=dao.login(user);
        //判断
        if(resultUser==null)
        {
            //登录失败
            req.setAttribute("login_msg","用户名密码错误");
            req.getRequestDispatcher("/").forward(req,resp);
        }else {
            //登陆成功
            HttpSession session=req.getSession();
            /*
            long logintime=System.currentTimeMillis();
            int i=(int)(1+Math.random()*(10-1+1));
            String cookie=String.valueOf(logintime)+String.valueOf(i);
            session.setAttribute("login",cookie);

             */
            session.setAttribute("resultUser",resultUser);
            session.setAttribute("login",true);
            req.setAttribute("user",resultUser);
            req.getRequestDispatcher("/mypageServlet").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
