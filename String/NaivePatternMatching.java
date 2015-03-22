import java.util.*;
import java.io.*;
import java.lang.*;

class NaviePatternMatching {
  public static void SearchPattern(String text,String pat) {
    int N = text.length();
    int M = pat.length();
    for(int i = 0; i <= N-M; i++) {
      int j;
      for(j = 0; j < M; j++) {
          if(text.charAt(i+j) != pat.charAt(j))
            break;
      }
      if(j == M)
        System.out.println("FOund at index" + i);
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String text = br.readLine();
    String pat = br.readLine();
    SearchPattern(text,pat);
  }
}
