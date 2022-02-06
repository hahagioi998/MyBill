package com.levy.service;

import com.levy.bean.Record;
import com.levy.dao.RecordDao;

import java.util.Date;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-05 23:17
 */
public class RecordService {
    public RecordDao recordDao = new RecordDao();

    public void add(double spend, int cid, String note, Date date){
        recordDao.add(new Record(spend,cid,note,date));
    }
}
