import java.io.*;
import java.math.*;
import java.util.*;

class Remove_b_ac { 
  public static String remove_chars(String str) {
    int N = str.length(),i;
    int j = 0;
    char[] C = str.toCharArray();
    for(i = 0; i < N; i++) {
      if(C[i] == 'b')
        continue;
      else if(i+1 < N &&C[i] == 'a' && C[i+1] == 'c') 
        i++;
      else
        C[j++] = C[i];
    }
    char[] ret = Arrays.copyOfRange(C,0,j);
    return new String(ret);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine().replaceAll("\\s+"," ");
    System.out.println(remove_chars(s));
  }
}



