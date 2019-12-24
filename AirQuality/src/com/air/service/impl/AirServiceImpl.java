package com.air.service.impl;

import java.util.List;

import com.air.dao.AirDao;
import com.air.dao.impl.AirDaoImpl;
import com.air.pojo.Air;
import com.air.pojo.AirQuality;
import com.air.pojo.District;
import com.air.service.AirService;

public class AirServiceImpl implements AirService {

	AirDao air=new AirDaoImpl();
	
	@Override
	public List<Air> selectAir() {
		// TODO Auto-generated method stub
		return air.selectAir();
	}

	@Override
	public Integer insertAir(AirQuality airquality,District district) {
		return air.insertAir(airquality,district);
	}


	@Override
	public Integer insertDist(District district,String cName) {
		return air.insertDist(district,cName);
	}

	@Override
	public List<Air> selectAirName(String cName) {
		// TODO Auto-generated method stub
		return air.selectAirName(cName);
	}

}
