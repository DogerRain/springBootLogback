package com.yudianxx.basic.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * fastjosn
 * josn 转换
 */
public class JSONTransform {
    public static void main(String[] args) {
        JSONArrayToObject();
    }

    /**
     * JSONArray 转 bject
     */
    public static void JSONArrayToObject() {

        String josnString = "[{\n" +
                "\t\"groupCount\": 0,\n" +
                "\t\"idc\": \"ns\",\n" +
                "\t\"isp\": [\"telecom\", \"unicom\"]\n" +
                "}, {\n" +
                "\t\"groupCount\": 0,\n" +
                "\t\"idc\": \"bj\",\n" +
                "\t\"isp\": [\"mobile\"]\n" +
                "}]";
        ArrayList<Group> groupArrayList = JSON.parseObject(josnString, new TypeReference<ArrayList<Group>>() {
        });

        for (Group group : groupArrayList) {
            System.out.println(group);
        }
    }

}

@Data
class Group {
    /**
     * 名称
     */
    String idc;


    String isp;

    /**
     * 城市
     */
    List<String> cities;


    /**
     * 节点数
     */
    int groupCount;
}
