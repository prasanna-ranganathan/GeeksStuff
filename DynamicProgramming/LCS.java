import java.util.*;
import java.io.*;

class LCS {
  //Recursion (Exponential Time)
  public int lcsRecurse(String X,String Y) {
    int M = X.length();
    int N = Y.length();
    return lcsRecurse(X,Y,M,N);
  }

  private int lcsRecurse(String X,String Y,int M,int N) {
    if(M == 0 || N == 0)
      return 0;
    if(X.charAt(M-1) == Y.charAt(N-1))
      return 1 + lcsRecurse(X,Y,M-1,N-1);
    else
      return Math.max(lcsRecurse(X,Y,M-1,N),lcsRecurse(X,Y,M,N-1));
  }

  //DP
  public int lcsDP(String X,String Y) {
    int M = X.length();
    int N = Y.length();
    int[][] opt = new int[M+1][N+1];

    for(int i = M-1; i >= 0; i--) {
      for(int j = N-1; j >= 0; j--) {
        if(X.charAt(i) == Y.charAt(j))
          opt[i][j] = opt[i+1][j+1] + 1;
        else
          opt[i][j] = Math.max(opt[i+1][j],opt[i][j+1]);
      }
    }

    return opt[0][0];
  }
  public static void main(String[] args) throws Exception {
    LCS out = new LCS();
    Scanner in = new Scanner(System.in);
    String X = in.nextLine();
    String Y = in.nextLine();
    System.out.println(out.lcsRecurse(X,Y));
    System.out.println(out.lcsDP(X,Y));
  }
}


