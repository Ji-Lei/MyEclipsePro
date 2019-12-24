package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Student;

public interface StudentMapper {
	//根据学号查询和查询所有共用一个方法（动态sql）
	public List<Student> getStudentsByCno(@Param("cno")Integer cno);
	//根据学号修改信息
	public Integer updataStudent(Student student);
}
