package com.levy.test;

import com.levy.bean.Config;
import com.levy.dao.ConfigDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description：
 * @author：LevyXie
 * @create：2022-02-05 10:00
 */
public class ConfigDaoTest {
    ConfigDao cfd = new ConfigDao();

    @Test
    public void getTotal() {
        System.out.println(cfd.getTotal());
    }

    @Test
    public void add() {
        Config test3 = new Config(3, "test3", "3");
        cfd.add(test3);
    }

    @Test
    public void update() {
        Config test3 = new Config(3, "test3", "33");
        cfd.update(test3);
    }

    @Test
    public void delete() {
        cfd.delete(3);
    }

    @Test
    public void get() {
        Config config = cfd.get(1);
        System.out.println(config);
    }

    @Test
    public void getByKey() {
        Config config = cfd.getByKey("test");
        System.out.println(config);
    }

    @Test
    public void list() {
        System.out.println(cfd.list());
    }

    @Test
    public void testList() {
        System.out.println(cfd.list(1, 1));
    }
}