import java.util.*;
import java.io.*;

class LexicographicRank{

  public static int rank(String s) {
    int rank = 0;
    for(int i = 1; i < s.length(); i++) {
      if(s.charAt(i) < s.charAt(0))
        rank += fact(s.length()-1);
    }
    System.out.println("Rank " + rank);
    if(s.length() > 1) 
      rank += rank(s.substring(1));
    return rank;
  }

  private static int fact(int n) {
    return (n <= 1) ? 1 : n * fact(n-1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(rank(s) + 1);
  }
}
