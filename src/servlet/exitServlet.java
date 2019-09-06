package servlet;

import Dao.Dao;
import Service.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/exitServlet")
public class exitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String car_number=request.getParameter("number");
        Dao leave=new Dao();
        car car=leave.carSelect(car_number);
        leave.carExit(car_number);
        leave.positionDelete(car_number);
        long nowtime=System.currentTimeMillis();
        String time=car.getCar_intime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long Time=nowtime;
        try {
             Time = dateFormat.parse(time).getTime();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        int money=(int)(nowtime-Time)/(1000);
        int min=money/60;
        request.setAttribute("car",car);
        request.setAttribute("money",money);
        request.setAttribute("min",min);
        request.getRequestDispatcher("/exit.jsp").forward(request,response);
    }
}
