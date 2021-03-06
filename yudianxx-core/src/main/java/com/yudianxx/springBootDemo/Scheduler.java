package com.yudianxx.springBootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
//    @Scheduled(cron = "*/5 * * * * ?")
//    @Scheduled(cron = "0 0 23 30 * ?")
    public  void cronJobSch(){
        logger.info("定时任务启动，进入方法");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now=new Date();
        String strDate=sdf.format(now);
        logger.info("Java now time "+ strDate);
    }
}
