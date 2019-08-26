package servlet;

import Dao.Dao;
import Service.car;
import Service.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/mypageServlet")
public class mypageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        user user=(user) session.getAttribute("resultUser");
        String username = user.getUsername();
        Dao findcars = new Dao();
        List<car> cars = findcars.selectCar(username);
        if(cars!=null) {
            request.setAttribute("cars", cars);
            request.setAttribute("haveCar",true );
        }else {
            request.setAttribute("haveCar",false );
        }
        request.getRequestDispatcher("/mypage.jsp").forward(request,response);


    }
}
