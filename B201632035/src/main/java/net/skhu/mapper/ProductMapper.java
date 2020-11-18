package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Product;

@Mapper
public interface ProductMapper {

    @Select("SELECT p.*, c.title        " +
    		" FROM Product p LEFT JOIN category c " +
    		" ON p.categoryId = c.id           ")
    List<Product> findAll();

    @Select("SELECT * FROM Product WHERE id = #{id}")
    Product findOne(int id);

    @Insert("INSERT product (name, categoryId, price, quantity) "+
    		"VALUES (#{name}, #{categoryId}, #{price}, #{quantity}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Product product);

    @Update("UPDATE Product SET                     " +
            "  name = #{name},        " +
    		"  categoryId = #{categoryId},            " +
            "  price = #{price},                   " +
            "  quantity = #{quantity}             "+
            "WHERE id = #{id}" )
    void update(Product product);


    @Delete("DELETE FROM Product WHERE id = #{id}")
    void delete(int id);
}

