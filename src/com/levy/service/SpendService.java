package com.levy.service;

import com.levy.bean.Record;
import com.levy.dao.RecordDao;

import java.util.List;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-05 16:43
 */
public class SpendService {
    RecordDao rcd = new RecordDao();

    public List<Record> getThisMonth(){
        return rcd.listThisMonth();
    }
    public List<Record> getToday(){
        return rcd.listToday();
    }

}
