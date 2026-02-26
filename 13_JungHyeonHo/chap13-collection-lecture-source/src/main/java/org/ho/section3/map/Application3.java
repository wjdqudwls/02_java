package org.ho.section3.map;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class Application3 {
  public static void main(String[] args) {
    /* 파일 읽어오기 */
    Properties prop = new Properties();

    try{
      //파일을 가져와 prop에 적재
//      prop.load(new FileInputStream("driver.dat")); //바이트 단위
//      prop.load(new FileReader("driver.txt")); //문자 기반 단위
      prop.loadFromXML(new FileInputStream("driver.xml"));//바이트 단위


      System.out.println(prop.getProperty("driver"));
      System.out.println(prop.getProperty("url"));
      System.out.println(prop.getProperty("user"));
      System.out.println(prop.getProperty("password"));

    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
