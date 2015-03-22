import java.lang.*;
import java.io.*;
import java.util.*;

class Atoi {
  public static int atoi(String s) {
    int res = 0;
    
    for(int i = 0; i < s.length(); i++) 
      res = res * 10 + s.charAt(i) - '0';
    
    return res;
  }

  //For Negative Numbers and errors
  
  public static int atoi(String s) {
    
    if(s == null || s.length() < 0)
      return 0;
    
    s = s.trim();

    char flag = '+';

    int i = 0;

    if(s.charAt(0) == '-') {
      flag = '-';
      i++;
    } else if( s.charAt(0) == '+') 
      i++;
    
    double res = 0;

    while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
      res = res *  10 + s.charAt(i) - '0';
      i++;
    }

    if(flag == '-')
      res = -res;

    if(res > Integer.MAX_VALUE)
       return Integer.MAX_VALUE;
    
    if(res < Integer.MIN_VALUE)
      return Integer.MIN_VALUE;

    return (int) res;
  }

  public static void main(String args[] ) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Atoi a = new Atoi();
    System.out.println(a.atoi(br.readLine()));
  }
}
  
