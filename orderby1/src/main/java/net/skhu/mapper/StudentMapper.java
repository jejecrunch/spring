package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT s.*, d.departmentName                              "
          + "FROM student s JOIN department d ON s.departmentID = d.id "
          + "ORDER BY                                                  "
          + "  (CASE WHEN #{order} = 0 THEN studentNumber END) ASC,    "
          + "  (CASE WHEN #{order} = 1 THEN studentNumber END) DESC,   "
          + "  (CASE WHEN #{order} = 2 THEN year END) ASC,             "
          + "  (CASE WHEN #{order} = 3 THEN year END) DESC,            "
          + "  (CASE WHEN #{order} = 4 THEN d.departmentName END) ASC  ")
    List<Student> findAll(int order);
}

