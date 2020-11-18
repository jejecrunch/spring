package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT e.*, d.title        " +
    		" FROM employee e LEFT JOIN department d " +
    		" ON e.departmentId = d.id           ")
    List<Employee> findAll();

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee findOne(int id);

    @Insert("INSERT employee (employeeNo, name, departmentId, salary, sex) "+
    		"VALUES (#{employeeNo}, #{name}, #{departmentId}, #{salary}, #{sex}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Employee employee);

    @Update("UPDATE employee SET                     " +
            "  employeeNo = #{employeeNo},        " +
    		"  name = #{name}            " +
            "  departmentId = #{departmentId},                   " +
            "  salary = #{salary},                 " +
            "  sex = #{sex}  " )
    void update(Employee employee);


    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(int id);
}

