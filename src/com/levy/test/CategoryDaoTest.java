package com.levy.test;

import com.levy.bean.Category;
import com.levy.dao.CategoryDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description：
 * @author：LevyXie
 * @create：2022-02-05 11:32
 */
public class CategoryDaoTest {

    private CategoryDao cgo = new CategoryDao();

    @Test
    public void getTotal() {
        System.out.println(cgo.getTotal());
    }

    @Test
    public void add() {
        Category test = new Category(1, "test",1);
        cgo.add(test);
    }

    @Test
    public void update() {
        Category test = new Category(1, "test1",1);
        cgo.update(test);
    }

    @Test
    public void delete() {
        cgo.delete(1);
    }

    @Test
    public void get() {
        System.out.println(cgo.get(2));
    }

    @Test
    public void list() {
        System.out.println(cgo.list());
    }
}