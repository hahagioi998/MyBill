package com.levy.util;

import java.io.*;


/**
 * @description：数据库备份、恢复工具类
 * @author：LevyXie
 * @create：2022-02-06 13:59
 */
public class MysqlUtil {
    public static void dump(String sqlPath,String dumpFile){
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
        String command = String.format(commandFormat, sqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port,
                DBUtil.database, dumpFile);

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resume(String sqlPath,String resumeFile) {
        try {
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
            String command = String.format(commandFormat, sqlPath, DBUtil.loginName, DBUtil.password,
                    DBUtil.database);

            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(resumeFile), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
