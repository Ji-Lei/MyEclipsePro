package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommConn {
	
	public static SqlSession getSqlSession() throws IOException {
//		创建会话工厂
//		mybatis配置文件
		String resource="SqlMapConfig.xml";
//		得到配置文件流
		InputStream input=Resources.getResourceAsStream(resource);
//		创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
//		通过工厂得到SQLSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	

}
