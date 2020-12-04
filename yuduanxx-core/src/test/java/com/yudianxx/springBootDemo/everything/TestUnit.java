package com.yudianxx.springBootDemo.everything;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangyongwen
 * @date 2020/11/26
 * @Description
 */
public class TestUnit {
    @Test
    public void a (){
        String sysRegion = "1,2,";
        System.out.println(sysRegion.substring(0,sysRegion.length()-1));

        sysRegion="";
        String[] strings = sysRegion.split(",");

        for (String str : strings){
            System.out.println(str);
        }

        List<Map<String,String>> mapList = new ArrayList<>();

        HashMap<String,String> hashMap = new HashMap<>();

        hashMap.put("1","2");

        mapList.add(hashMap);

        System.out.println(mapList);

        HashMap<String,String> hashMap2 = new HashMap<>();
        hashMap2.put("1","2");

        System.out.println(mapList.contains(hashMap2));

    }
}
