package org.ho.section00.missions;

import java.util.Random;

public class Generator {
  private static Random rand = new Random();
  public static String makeRandomString(){
    return ""+(char)(rand.nextInt('z'-'a')+'a')
        +(char)(rand.nextInt('z'-'a')+'a')
        +(char)(rand.nextInt('z'-'a')+'a')
        +(char)(rand.nextInt('z'-'a')+'a');
  }
  public static int makeRandomInteger(int start, int end){
    return rand.nextInt(end-start)+start;
  }
  public static int makeRandomInteger(int end){
    return rand.nextInt(end);
  }
}
