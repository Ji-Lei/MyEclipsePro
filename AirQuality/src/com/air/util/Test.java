package com.air.util;

import java.util.List;

import com.air.pojo.Air;
import com.air.pojo.District;
import com.air.service.AirService;
import com.air.service.impl.AirServiceImpl;

public class Test {
	public static void main(String[] args) {
		AirService service=new AirServiceImpl();
//		List<Air> list=service.selectAir();//查询全部
//		List<Air> list=service.selectAirName("合肥");//按城市查询
//		for(Air air:list) {
//			System.out.println(air.getName()+"\t"+air.getMonitorTime()+"\t"+air.getPm10()+"\t"+air.getPm25()+"\t"+air.getMonitoringStation());
//		}
//		插入区域
//		District district=new District("包河区");
//		String cName="合肥";
//		System.out.println(service.insertDist(district, cName));
//		System.out.println(NowTime.nowTime());
	}
}
