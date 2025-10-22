package com.example.demo.mybatis.mapper;

import com.example.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> findAll();

//    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Long id);

    void insert(Student student);

    void update(Student student);

    void delete(Long id);
}
