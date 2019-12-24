package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import pojo.Phone;
import pojo.Student;
import utils.CommConn;

public class StudentDaoimpl {
	
//	利用动态SQL查询结果
	public List<Student> getStudentsByCno(Integer cno) throws IOException {
		SqlSession sqlSession=CommConn.getSqlSession();
		List<Student> list=sqlSession.getMapper(StudentMapper.class).getStudentsByCno(cno);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
// 	修改操作，利用动态sql的set或trim加if标签实现可控的值设置
	@Test
	public void updataStudent() throws IOException {
		SqlSession sqlSession=CommConn.getSqlSession();
		Student student=new Student();
		student.setCno(160111);
		student.setSex("男");//可以自定义想设置的属性值
		Integer count=sqlSession.getMapper(StudentMapper.class).updataStudent(student);
		System.out.println(count);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test() throws IOException {
		List<Student> list1=this.getStudentsByCno(160109);
		List<Student> list2=this.getStudentsByCno(null);
		for(Student student:list1) {
			System.out.print(
						"学号："+student.getCno()+"\t"+
						"姓名："+student.getName()+"\t"+
						"性别："+student.getSex()+"\t"+
						"年级："+student.getClass1().getClassname()+"\t"+"手机号："
					);
			for(Phone phone:student.getPhoneList()) {
				System.out.print(phone.getPhone()+" ");
			}
			System.out.println();
		}
		System.out.println("*******************************************************");
		for(Student student:list2) {
			System.out.print(
					"学号："+student.getCno()+"\t"+
					"姓名："+student.getName()+"\t"+
					"性别："+student.getSex()+"\t"+
					"年级："+student.getClass1().getClassname()+"\t"+"手机号："
				);
			for(Phone phone:student.getPhoneList()) {
				System.out.print(phone.getPhone()+" ");
			}
			System.out.println();
		}
	}

}
