package com.levy.dao;

import com.levy.bean.Record;
import com.levy.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * @description：Mysql中record表的访问对象
 * @author：LevyXie
 * @create：2022-02-05 11:37
 */
public class RecordDao extends BaseDao{
    public int getTotal(){
        String sql = "select count(1) from record";
        Number total = (Number) queryForSingleValue(sql);
        return total.intValue();
    }
    public void add(Record record){
        String sql = "insert into record(`spend`,`cid`,`note`,`date`) values(?,?,?,?)";
        update(sql, record.getSpend(),record.getCid(),record.getNote(),record.getDate());
    }
    public void update(Record record){
        String sql = "update record set `spend` = ?, `cid` = ?,`note` = ?,`date` = ? where id = ?";
        update(sql, record.getSpend(),record.getCid(),record.getNote(),record.getDate(),record.getId());
    }
    public void delete(int id){
        String sql = "delete from record where id = ?";
        update(sql, id);
    }
    public Record get(int id){
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record where id = ?";
        return queryForOne(Record.class, sql, id);
    }
    public List<Record> list(){
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record";
        return queryForList(Record.class, sql);
    }
    public List<Record> list(int begin,int end){
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record where id >= ? and id <= ?";
        return queryForList(Record.class, sql, begin, end);
    }
    public List<Record> list(int cid){
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record where `cid` = ?";
        return queryForList(Record.class, sql, cid);
    }

    public List<Record> list(Date date){
        //sql和util包下的不同Date需进行转换，否则无法在数据库中查询到对象
        java.sql.Date sqlDate = DateUtil.util2sql(date);
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record where `date` = ?";
        return queryForList(Record.class, sql,sqlDate);
    }
    public List<Record> list(Date dateBegin,Date dateEnd){
        java.sql.Date sqlBegin = DateUtil.util2sql(dateBegin);
        java.sql.Date sqlEnd = DateUtil.util2sql(dateEnd);
        String sql = "select `id`,`spend`,`cid`,`note`,`date` from record where `date` >= ? and date <= ?";
        return queryForList(Record.class, sql,sqlBegin,sqlEnd);
    }
    public List<Record> listToday(){
        return list(DateUtil.today());
    }
    public List<Record> listThisMonth(){
        return list(DateUtil.monthBegin(),DateUtil.monthEnd());
    }

}
