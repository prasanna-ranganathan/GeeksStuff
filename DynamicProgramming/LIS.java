import java.util.*;
import java.io.*;

class LIS {
  public int lisDP(int[] A) {
    int N = A.length;
    int[] lis = new int[N];

    //initialize all to one
    for(int i = 0; i < N; i++)
      lis[i] = 1;

    for(int i = 1; i < N; i++) // N times
      for(int j = 0; j < i; j++) { //N times
       if(A[i] > A[j] && lis[i] < lis[j] + 1)
         lis[i] = lis[j] + 1;
      }

    int max = 0;
    for(int i = 0; i < N; i++)
      if(max < lis[i])
        max = lis[i];
    return max;
  }

  public static void main(String[] args) throws Exception {
    LIS out = new LIS();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    String[] s = br.readLine().split(" ");
    for(int i = 0; i < N; i++)
      A[i] = Integer.parseInt(s[i]);

    System.out.println(out.lisDP(A));
  }
}
