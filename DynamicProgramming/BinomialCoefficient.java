import java.util.*;
import java.io.*;

class BinomialCoefficient {
  public int BCRecursive(int n,int k) {
    if(k == 0 || n == k)
      return 1;
    else 
      return BCRecursive(n-1,k-1) + BCRecursive(n-1,k);
  }

  public int BCDP(int n,int k) {
    int[][] out = new int[n+1][k+1];
    for(int i = 0; i <= n; i++) {
      for(int j = 0; i <= Math.min(i,k); j++) {
        if(j == 0 || i == j)
          out[i][j] = 1;
        else
          out[i][j] = out[i-1][j-1] + out[i-1][j];
      }
    }
    return out[n][k];
  }
  //More Space Optimized DP
  public int BCDP2(int n,int k) {
    int[] c = new int[k+1];
    c[0] = 1;
    for(int i = 1; i <= n; i++) {
      for(int j = Math.min(i,k); j > 0; j--) {
          c[j] = c[j] + c[j-1];
      }
    }
    return c[k];
  }

  public static void main(String[] args) throws Exception {
    BinomialCoefficient ob = new BinomialCoefficient();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    System.out.println(ob.BCDP2(n,k));
  }
}

