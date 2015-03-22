import java.util.*;
import java.lang.*;
import java.io.*;

class RunLengthEncoding {
  public static String Runlength(String s) {
    if(s == null || s.length() == 0)
      return "";

    StringBuilder str = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
        str.append(s.charAt(i));
        
        int count = 1;
        while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
          count++;
          i++;
        }

        str.append(count);
    }
    return str.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(Runlength(br.readLine()));
  }
}
