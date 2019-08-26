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
import java.text.SimpleDateFormat;

@WebServlet("/occupyInfoServlet")
public class occupyInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        user user=(user) session.getAttribute("resultUser");
        if(user!=null){
            String position=(String) session.getAttribute("position");
            String username = user.getUsername();
            Dao postform=new Dao();
            car car=new car();
            car.setCar_number(request.getParameter("car_number"));
            //occupy
            postform.occupy(position,car.getCar_number());
            car.setCar_brand(request.getParameter("car_brand"));

            long logintime=System.currentTimeMillis();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateformat.format(logintime);

            car.setCar_intime(dateStr);
            car.setCar_info(request.getParameter("car_info"));
            car.setCar_position(position);
            //
            postform.carAdd(car,username);
            request.setAttribute("post_msg","预约成功");
            request.getRequestDispatcher("/occupy.jsp").forward(request,response);
            session.removeAttribute("position");



        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);


    }
}
