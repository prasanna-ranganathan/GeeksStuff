import java.util.*;
import java.lang.*;
import java.io.*;

class NaivePatternMatchingImproved {
  public static void searchPattern(String text,String pat) {
    int N = text.length();
    int M = pat.length();

    for(int i = 0; i <= N-M;i++) {
      int j;
      for(j = 0; j < M; j++) {
        if(text.charAt(i+j) != pat.charAt(j))
          break;
      }
      if( j == M ) {
        System.out.println("Found at index" + i);
        i = i + M;
      }
      else
        i = i + j;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String text = br.readLine();
    String pat = br.readLine();
    searchPattern(text,pat);
  }
}

