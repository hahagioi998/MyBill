package com.levy.service;

import com.levy.bean.Category;
import com.levy.bean.Record;
import com.levy.dao.CategoryDao;
import com.levy.dao.RecordDao;

import java.util.Collections;
import java.util.List;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-05 16:43
 */
public class CategoryService {
   CategoryDao cgd =  new CategoryDao();
   RecordDao rcd = new RecordDao();

   public List<Category> list(){
       List<Category> cs = cgd.list();
       for (Category c:cs){
           //调用RecordDao的以cid为参数的list方法，获取Record中指定cid的Record个数。
           List<Record> list = rcd.list(c.getId());
           c.setRecordNumber(list.size());
       }
       Collections.sort(cs,(c1, c2)->c2.getRecordNumber() - c1.getRecordNumber());
       return cs;
   }
   public void add(String name){
       Category category = new Category();
       category.setName(name);
       cgd.add(category);
   }
   public void update(int id,String name){
       Category category = new Category();
       category.setName(name);
       category.setId(id);
       cgd.update(category);
   }
   public void delete(int id){
       cgd.delete(id);
   }
}
