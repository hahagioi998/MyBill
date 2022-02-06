package com.levy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description：数据库工具类
 * @author：LevyXie
 * @create：2022-02-04 22:41
 */
public class DBUtil {
    private static DataSource dds;
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "mybill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static{
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
        try {
            pros.load(is);
            dds = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        Connection conn = dds.getConnection();
        return conn;
    }
    public static void close(Connection conn){
        JdbcUtils.close(conn);
    }

}
