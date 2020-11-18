package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Category;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category")
    List<Category> findAll();

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category findOne(int id);

    @Insert("INSERT category (title, titleEng) "+
    		"VALUES (#{title}, #{titleEng}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Category category);

    @Update("UPDATE category SET       " +
            "  title = #{title}        ")
    void update(Category category);


    @Delete("DELETE FROM category WHERE id = #{id}")
    void delete(int id);
}

