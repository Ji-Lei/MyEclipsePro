package com.air.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.air.pojo.Air;
import com.air.service.AirService;
import com.air.service.impl.AirServiceImpl;

/**
 * Servlet implementation class AirCityServlet
 */
@WebServlet("/AirCityServlet")
public class AirCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AirCityServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city=request.getParameter("city");
		
		AirService service=new AirServiceImpl();
		List<Air> list=service.selectAirName(city);
//		JSONArray array=new JSONArray.fromObject(list)
		JSONArray array=new JSONArray();
		for(Air air:list) {
			JSONObject date=new JSONObject();
			date.put("name", air.getName());
			date.put("monitorTime", air.getMonitorTime());
			date.put("pm10", air.getPm10());
			date.put("pm25", air.getPm25());
			date.put("monitoringStation", air.getMonitoringStation());
			array.put(date);
		}
		
		PrintWriter out=response.getWriter();
		out.write(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
