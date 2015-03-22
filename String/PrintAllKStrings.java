import java.util.*;
import java.io.*;

class PrintAllKStrings {
  private static int N;
  public static void PrintAllStrings(String s,int k) {
    N = s.length();
    PrintAllStrings(s,"",k);
  }

  private static void PrintAllStrings(String s,String prefix,int K) {
    if(K == 0) {
      System.out.println(prefix);
      return;
    }

    for(int i = 0; i < N; i++) {
      String newPrefix = prefix + s.charAt(i);
      PrintAllStrings(s,newPrefix,K-1);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int K = in.nextInt();
    PrintAllStrings(s,K);
  }
}

