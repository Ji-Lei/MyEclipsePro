package com.air.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.air.dao.AirDao;
import com.air.pojo.Air;
import com.air.pojo.AirQuality;
import com.air.pojo.District;
import com.air.util.DBUtil;

public class AirDaoImpl implements AirDao{

	Connection conn=null;
	PreparedStatement ps = null;
    ResultSet rs = null;
	
	
//    查询所有结果
	public List<Air> selectAir() {
		List<Air> list=new ArrayList<Air>();
		try {
			String sql="SELECT district.name,air_quality_index.monitorTime,air_quality_index.pm10,air_quality_index.`pm25`,air_quality_index.monitoringStation FROM district,air_quality_index WHERE air_quality_index.districtId=district.id";
			Object[] obj= {};
			rs=DBUtil.select(sql, obj);
			while(rs.next()) {
				String name=rs.getString(1);
				String monitorTime=rs.getString(2);
				int pm10=rs.getInt(3);
				int pm25=rs.getInt(4);
				String monitoringStation=rs.getString(5);
				Air air=new Air(name, monitorTime, pm10, pm25, monitoringStation);
				list.add(air);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(conn, ps, rs);
		}
		
		return list;
	}

	@Override
	public Integer insertAir(AirQuality airquality,District district) {
		Integer count=0;
		String sql="INSERT into air_quality_index VALUES(null,(SELECT id from district WHERE name=?),?,?,?,?)";
		Object[] obj= {district.getName(),airquality.getMonitorTime(),airquality.getPm10(),airquality.getPm25(),airquality.getMonitoringStation()};
		count=DBUtil.update(sql, obj);
		return count;
	}


	@Override
	public Integer insertDist(District district,String cName) {
		Integer count=0;
		String sql="insert into district VALUES(null,?,(SELECT id from city WHERE name=?))";
		Object[] obj= {district.getName(),cName};
		count=DBUtil.update(sql, obj);
		return count;
	}

	@Override
//	根据城市名查询结果集
	public List<Air> selectAirName(String cName) {
		List<Air> list=new ArrayList<Air>();
		try {
			String sql="SELECT district.name,air_quality_index.monitorTime,air_quality_index.pm10,air_quality_index.`pm25`,air_quality_index.monitoringStation FROM district,air_quality_index WHERE air_quality_index.districtId=district.id AND district.cid=(SELECT city.id FROM city WHERE city.`name`= ? )";
			Object[] obj= {cName};
			rs=DBUtil.select(sql, obj);
			while(rs.next()) {
				String name=rs.getString(1);
				String monitorTime=rs.getString(2);
				int pm10=rs.getInt(3);
				int pm25=rs.getInt(4);
				String monitoringStation=rs.getString(5);
				Air air=new Air(name, monitorTime, pm10, pm25, monitoringStation);
				list.add(air);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(conn, ps, rs);
		}
		
		return list;
	}

}
