package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;
import net.skhu.model.Pagination;

@Mapper
public interface StudentMapper {

    List<Student> findAll(Pagination pagination);
    List<Student> findByDepartmentId(Pagination pagination);

    @Select("SELECT COUNT(id) FROM student")
    int count();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(int id);

    void insert(Student student);
    void update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteById(int id);
}

