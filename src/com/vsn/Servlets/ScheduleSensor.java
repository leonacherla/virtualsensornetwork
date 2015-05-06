package com.vsn.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsn.SensorDataExchange.VirtualSensor;
import com.vsn.SensorState.ScheduledState;
import com.vsn.Storage.InMemoryStorageManager;

/**
 * Servlet implementation class ScheduleSensor
 */
@WebServlet("/ScheduleSensor")
public class ScheduleSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleSensor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Send vs object to a class and run a new thread forever with sleeptime equal to the the dataInterval
		InMemoryStorageManager im = new InMemoryStorageManager();
		VirtualSensor vs = im.retrieveUserSensor(request.getParameter("email"));
		vs.dataInterval = Integer.parseInt(request.getParameter("dataInterval"));
		ScheduledState ss = new ScheduledState(request.getParameter("email"), vs);
		ss.start();
		response.getWriter().write("Sensor Scheduled for reading data.");
	}

}
