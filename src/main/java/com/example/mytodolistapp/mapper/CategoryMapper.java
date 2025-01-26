package com.example.mytodolistapp.mapper;

import com.example.mytodolistapp.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM categories")
    List<Category> findAllCateogry();

    @Select("SELECT * FROM categories where id=#{id}")
    Category findCategoryById(Long id);

    @Insert("INSERT INTO categories(name, created_at) VALUES (#{name}, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertCategory(Category category);

    @Delete("DELETE FROM categories WHERE id=#{id}")
    void deleteCategory(Long id);
}
