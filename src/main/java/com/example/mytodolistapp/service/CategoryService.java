package com.example.mytodolistapp.service;

import com.example.mytodolistapp.mapper.CategoryMapper;
import com.example.mytodolistapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
//    Dependencies Injection
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategories(){
        return categoryMapper.findAllCateogry();
    }

    public Category getCategoryById(Long id){
        return categoryMapper.findCategoryById(id);
    }

    public void createCategory(Category category){
         categoryMapper.insertCategory(category);
    }

    public void deleteCategoryById(Long id){
        categoryMapper.deleteCategory(id);
    }
}
