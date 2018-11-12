package com.shan.json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JsonSimpleUtils
 * @Description 一些关于JSON开发中的简单的工具类
 * @Author laijingshan
 * @Date 2018/11/3 17:06
 * @Version 1.0
 **/
public class JsonSimpleUtils {


    public static void main(String[] args) throws Exception{
        List<String> guolv = new ArrayList<String>();
        guolv.add("loanId");
        guolv.add("createdBy");
        guolv.add("createdDate");
        guolv.add("updatedBy");
        guolv.add("deleteFlag");
        guolv.add("updatedDate");
        // 获取一个类的全类名
 String className = "com.shan.json.Edc51gjjOperatorUserBrief";
        final Class<?> aClass = Class.forName(className);
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
           String fieldName = field.getName();
           String humpToUnderlineName = humpToUnderline(fieldName);
           if(guolv.contains(fieldName)){
                continue;
            }
            System.out.println("@JSONField(name = \"" + humpToUnderlineName + "\")");
            System.out.println("private String " + fieldName + ";");
        }
    }

    /***
     * 下划线命名转为驼峰命名
     * @param para
     * 下划线命名的字符串
     */
    public static String underlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */
    public static String humpToUnderline(String para){
        StringBuilder sb=new StringBuilder(para);
        //定位
        int temp = 0;
        for(int i=0;i<para.length();i++){
            if(Character.isUpperCase(para.charAt(i))){
                sb.insert(i+temp, "_");
                temp+=1;
            }
        }
        return sb.toString().toLowerCase();
    }

}
