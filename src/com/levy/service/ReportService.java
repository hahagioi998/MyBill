package com.levy.service;

import com.levy.bean.Record;
import com.levy.dao.RecordDao;
import com.levy.util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-06 12:42
 */
public class ReportService {
    public RecordDao recordDao = new RecordDao();

    public int getSpendByDay(Date day){
        int totalSpend = 0;
        List<Record> records = recordDao.list(day);
        for(Record record : records){
            totalSpend += record.getSpend();
        }
        return totalSpend;
    }
    public List<Record> getSpendByMonth(){
        ArrayList<Record> result = new ArrayList<>();
        List<Record> records = recordDao.listThisMonth();
        Date begin = DateUtil.monthBegin();
        int totalDay = DateUtil.thisMonthTotalDay();
        Calendar calendar = Calendar.getInstance();

        for(int i = 0;i < totalDay;i++){
            Record record = new Record();
            calendar.setTime(begin);
            calendar.add(Calendar.DATE,i);
            Date eachDay = calendar.getTime();
            int spendByDay = getSpendByDay(eachDay);
            record.setSpend(spendByDay);
            result.add(record);
        }
        return result;
    }
}
