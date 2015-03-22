import java.util.*;
import java.io.*;

class LCSPrint {
  public void lcsPrint(String X,String Y) {
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

    int i = 0, j = 0;
    while(i < M && j < N) {
      if(X.charAt(i) == Y.charAt(j)) {
        System.out.print(X.charAt(i));
        i++;
        j++;
      }
      else if(opt[i+1][j] >= opt[i][j+1]) i++;
      else                                j++;
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    LCSPrint ob = new LCSPrint();
    Scanner in = new Scanner(System.in);
    String X = in.nextLine();
    String Y = in.nextLine();
    ob.lcsPrint(X,Y);
  }
}
