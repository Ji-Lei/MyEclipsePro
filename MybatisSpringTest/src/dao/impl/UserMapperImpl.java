package dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dao.mapper.UserMapper;
import pojo.User;
import pojo.UsersList;
//使用MapperScannerConfigurer批量生产实现类将不需要此方法
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
	/**
	  * 以下代码可以继承SqlSessionDaoSupport来得到，获取的时候用继承过来的getSqlSession()方法即可获取
	 * private SqlSessionTemplate sqlSession;
	 * 
	 * public SqlSessionTemplate getSqlSession(){ 
	 * 		return sqlSession; 
	 * } 
	 * public void setSqlSession(SqlSessionTemplate sqlSession) { 
	 * 		this.sqlSession = sqlSession;
	 * }
	 */

	public List<UsersList> getUsers(String username) {
		/** 
		 * mapper.UserMapper是mapper中namespace的值，用此方式可以将其设置简单的名字
		 * mapper.UserMapper是接路径，用来下面方法直接匹配位置
		 * return sqlSession.selectList("dao.mapper.UserMapper.getUsers"); 
		 */
		/**上面或者下面的映射器方式都可以
		 *return sqlSession.getMapper(UserMapper.class).getUsers();
		 */
		return this.getSqlSession().getMapper(UserMapper.class).getUsers(username);
	}

	@Override
	public void addUser(User user) {
		this.getSqlSession().getMapper(UserMapper.class).addUser(user);
	}

	@Override
	public void deleteUser(String username) {
		this.getSqlSession().getMapper(UserMapper.class).deleteUser(username);
	}

	@Override
	public void updateUser(User user) {
		this.getSqlSession().getMapper(UserMapper.class).addUser(user);
	}
	
	
}
