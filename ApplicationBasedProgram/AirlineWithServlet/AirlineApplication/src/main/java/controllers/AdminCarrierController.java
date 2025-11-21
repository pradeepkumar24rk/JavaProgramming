package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminHomeDAO;
import models.CarrierModel;


@WebServlet("/adminCarrierController")
public class AdminCarrierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CarrierModel> carrierList = new ArrayList<>();
			AdminHomeDAO.getCarrierData(carrierList);
            request.setAttribute("carriers",carrierList);
            request.getRequestDispatcher("AdminCarrier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String editId = request.getParameter("edit_operation");
		String[] deleteIds = request.getParameterValues("delete_operation");
		ArrayList<CarrierModel> carrierList = new ArrayList<>();
		AdminHomeDAO.getCarrierData(carrierList);
        request.setAttribute("carriers",carrierList);
		if("edit".equals(action)) {
			if(editId == null) {
				request.setAttribute("message", "Please select Carrier to be Edited");
				request.setAttribute("type","fail");
			} else {
				request.setAttribute("message", "Successfully updated");
				request.setAttribute("type","success");
			}
		} else if("delete".equals(action)) {
			if(deleteIds == null) {
				request.setAttribute("message", "Please select one or more Carrier to be delete");
				request.setAttribute("type","fail");
			} else {
				request.setAttribute("message", "Deleted Successfully");
				request.setAttribute("type","success");
			}
		} else {
			request.setAttribute("message", "Some thing went wrong. Please try again");
			request.setAttribute("type","fail");
		}
		request.getRequestDispatcher("AdminCarrier.jsp").forward(request, response);
	}

}
