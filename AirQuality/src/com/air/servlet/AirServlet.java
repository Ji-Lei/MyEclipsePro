package com.air.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//import net.sf.json.JSONArray;


/**
 * Servlet implementation class AirServlet
 */
@WebServlet("/AirServlet")
public class AirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AirServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirService service=new AirServiceImpl();
		List<Air> list=service.selectAir();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
