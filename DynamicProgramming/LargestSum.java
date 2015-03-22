import java.util.*;
import java.io.*;

class LargestSum {

  public int maximumsum(int[] A) {
    int N = A.length;
    int Max_ending_here = 0;
    int Max_so_far = 0;
    for(int i = 0; i < N; i++) {
      Max_ending_here = Max_ending_here + A[i];
      if(Max_ending_here < 0)
        Max_ending_here = 0;
      //Optimization
      else if(Max_ending_here > Max_so_far)
        Max_so_far = Max_ending_here;
    }
    return Max_so_far;
  }

  //For All Negative Cases
  public int kandane(int[] A) {
    int N = A.length;
    int max_so_far = A[0];
    int cur_max = A[0];
    for(int i = 1; i < N; i++) {
      cur_max = Math.max(A[i],cur_max + A[i]);
      max_so_far = Math.max(max_so_far,cur_max);
    }
    return max_so_far;
  }

  public static void main(String[] args) throws Exception {
    LargestSum out = new LargestSum();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    String[] s = br.readLine().split(" ");
    for(int i = 0; i < N; i++)
      A[i] = Integer.parseInt(s[i]);

    System.out.println(out.maximumsum(A));
    System.out.println(out.kandane(A));
  }
}
