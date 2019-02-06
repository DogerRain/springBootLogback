package com.yudainxx.springBootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
//    @Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 0 23 30 * ?")
    public  void cronJobSch(){
        logger.info("进入方法....");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now=new Date();
        String strDate=sdf.format(now);
        logger.info("Java now time "+ strDate);
    }
}
