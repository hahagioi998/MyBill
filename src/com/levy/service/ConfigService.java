package com.levy.service;

import com.levy.bean.Config;
import com.levy.dao.ConfigDao;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-05 15:24
 */
public class ConfigService {
    public static final String BUDGET = "budget";
    public static final String SQL_PATH = "MySqlPath";
    public static final String DUMP_PATH = "DumpPath";
    static ConfigDao cfd = new ConfigDao();
    static {
        init();
    }

    public static void init(){
        init(BUDGET, "500");
        init(SQL_PATH, "");
        init(DUMP_PATH, "");
    }

    public static void init(String key,String value){
        Config config = cfd.getByKey(key);
        Config newConfig = new Config(key, value);
        if(config != null){
            cfd.update(newConfig);
        }else {
            cfd.add(newConfig);
        }
    }

    public void update(String key,String value){
        Config config = cfd.getByKey(key);
        config.setValue(value);
        cfd.update(config);
    }

    public Config get(String key){
        return cfd.getByKey(key);
    }
}
