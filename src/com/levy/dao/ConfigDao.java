package com.levy.dao;

import com.levy.bean.Config;

import java.util.List;

/**
 * @description：Mysql中billconfig表的访问对象
 * @author：LevyXie
 * @create：2022-02-05 9:55
 */
public class ConfigDao extends BaseDao{
    public int getTotal(){
        String sql = "select count(1) from billconfig";
        Number total = (Number) queryForSingleValue(sql);
        return total.intValue();
    }
    public void add(Config config){
        String sql = "insert into billconfig(`key`,`value`) values(?,?)";
        update(sql, config.getKey(),config.getValue());
    }
    public void update(Config config){
        String sql = "update billconfig set `key` = ?, `value` = ? where id = ?";
        update(sql, config.getKey(),config.getValue(),config.getId());
    }
    public void delete(int id){
        String sql = "delete from billconfig where id = ?";
        update(sql, id);
    }
    public Config get(int id){
        String sql = "select `id`,`key`,`value` from billconfig where id = ?";
        return queryForOne(Config.class, sql, id);
    }
    public Config getByKey(String key){
        String sql = "select `id`,`key`,`value` from billconfig where `key` = ?";
        return queryForOne(Config.class, sql, key);
    }
    public List<Config> list(){
        String sql = "select `id`,`key`,`value` from billconfig";
        return queryForList(Config.class, sql);
    }
    public List<Config> list(int begin,int end){
        String sql = "select `id`,`key`,`value` from billconfig where id >= ? and id <= ?";
        return queryForList(Config.class, sql, begin, end);
    }
}
