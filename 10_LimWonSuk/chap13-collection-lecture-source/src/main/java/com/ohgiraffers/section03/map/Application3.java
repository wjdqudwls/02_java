package com.ohgiraffers.section03.map;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {
        /* 파일 읽어오기 */
        Properties prop = new Properties();
        try {
            // prop.load(new FileInputStream("driver.dat"));
            // prop.load(new FileReader("driver.txt"));
            prop.loadFromXML(new FileInputStream("driver.xml"));

            System.out.println(prop.getProperty("driver"));
            System.out.println(prop.getProperty("url"));
            System.out.println(prop.getProperty("user"));
            System.out.println(prop.getProperty("password"));
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
