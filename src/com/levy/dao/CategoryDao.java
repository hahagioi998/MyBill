package com.levy.dao;

import com.levy.bean.Category;
import com.levy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description：Mysql中category表的访问对象
 * @author：LevyXie
 * @create：2022-02-05 11:02
 */
public class CategoryDao extends BaseDao{
    public int getTotal(){
        String sql = "select count(1) from category";
        Number total = (Number) queryForSingleValue(sql);
        return total.intValue();
    }
    public void add(Category category){
        String sql = "insert into category(`name`) values(?)";
        update(sql, category.getName());
    }
    public void update(Category category){
        String sql = "update category set `name` = ? where id = ?";
        update(sql, category.getName(),category.getId());
    }
    public void delete(int id){
        String sql = "delete from category where id = ?";
        update(sql, id);
    }
    public Category get(int id){
        String sql = "select `id`,`name` from category where id = ?";
        return queryForOne(Category.class, sql, id);
    }
    public List<Category> list() {
        String sql = "select `id`,`name` from category";
        return queryForList(Category.class, sql);
    }

    public List<Category> list(int begin,int end){
        String sql = "select `id`,`name` from category where id >= ? and id <= ?";
        return queryForList(Category.class, sql, begin, end);
    }
}
