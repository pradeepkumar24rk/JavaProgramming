package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminHomeDAO;
import models.FlightScheduleModel;

/**
 * Servlet implementation class AdminFlightScheduleController
 */
@WebServlet("/adminFlightScheduleController")
public class AdminFlightScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FlightScheduleModel> fsList = new ArrayList<>();
		AdminHomeDAO.getFlightSchedule(fsList);
        request.setAttribute("flightSchedule",fsList);
        request.getRequestDispatcher("AdminFlightSchedule.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataOfTravel = request.getParameter("dataOfTravel");
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		if(!AdminHomeDAO.insertFlightSchedule(flightId, dataOfTravel)) {
			request.setAttribute("message", "Flight is Not Available");
			request.setAttribute("type","fail");
		} else {
			request.setAttribute("message", "Flight " + flightId + " is scheduled");
			request.setAttribute("type","success");
		}
	}

}
