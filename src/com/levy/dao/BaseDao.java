package com.levy.dao;

import com.levy.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @description：BaseDao，dao的抽象类，提供增删改查的基础方法
 * @author：LevyXie
 * @create：2022-02-05 9:42
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql,Object... args){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            return queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            //数据库连接池使用后务必及时关闭
            DBUtil.close(conn);
        }
    }

    public  <T> T queryForOne(Class<T> type,String sql,Object... args){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DBUtil.close(conn);
        }
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DBUtil.close(conn);
        }
    }

    public Object queryForSingleValue(String sql, Object ... args){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            return queryRunner.query(conn, sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            DBUtil.close(conn);
        }
    }

}
