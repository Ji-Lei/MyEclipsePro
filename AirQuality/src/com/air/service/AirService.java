package com.air.service;

import java.util.List;
import com.air.pojo.Air;
import com.air.pojo.AirQuality;
import com.air.pojo.District;

public interface AirService {
	public List<Air> selectAir();
	public List<Air> selectAirName(String cName);
	public Integer insertAir(AirQuality airquality,District district);
	public Integer insertDist(District district,String cName);
}
