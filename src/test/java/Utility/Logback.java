package Utility;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class Logback {
    public static Properties properties;
    static {
        InputStreamReader inputStream = null;
        try {
            properties = new Properties();
            //这句是关键
            inputStream = new InputStreamReader(Logback.class.getClassLoader().getResourceAsStream("element.properties"),"UTF-8");
            properties.load(inputStream);

        } catch (Exception e) {

        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        //System.out.printf(Logback.properties.getProperty("LOG_HOME"));
        Iterator iterator =properties.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }


    }

}
