package servlet;

import Dao.Dao;
import Service.seat;
import Service.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/occupyServlet")
public class occupyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Dao findSeat = new Dao();
        List<seat> seats = findSeat.selectseat();
        if(seats!=null) {
            request.setAttribute("seats", seats);
            request.setAttribute("haveSeats",true );
        }else {
            request.setAttribute("haveSeats",false );
        }
        request.getRequestDispatcher("/occupy.jsp").forward(request,response);
    }
}
