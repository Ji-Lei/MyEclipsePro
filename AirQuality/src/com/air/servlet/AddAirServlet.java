package com.air.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.pojo.AirQuality;
import com.air.pojo.District;
import com.air.service.AirService;
import com.air.service.impl.AirServiceImpl;
import com.air.util.NowTime;


@WebServlet("/AddAirServlet")
public class AddAirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddAirServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirService service=new AirServiceImpl();
		AirQuality quality=new AirQuality();
		District dist=new District();
		
		String district=request.getParameter("district");
		String pm1=request.getParameter("pm10");
		String pm2=request.getParameter("pm25");
//		int pm10=Integer.parseInt(pm1);
//		int pm25=Integer.parseInt(pm2);
		String monitoringStation=request.getParameter("monitoringStation");
		String city=request.getParameter("city");
		String monitorTime=NowTime.nowTime();
		
		dist.setName(district);
		
		quality.setMonitorTime(monitorTime);
		quality.setPm10(10);
		quality.setPm25(25);
		quality.setMonitoringStation(monitoringStation);
		
		service.insertDist(dist, city);
		service.insertAir(quality, dist);
		
		
		PrintWriter out=response.getWriter();
		out.write("true");
		
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
