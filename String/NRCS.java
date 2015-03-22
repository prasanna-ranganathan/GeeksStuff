import java.util.*;
import java.io.*;
import java.lang.*;

class NRCS {
  public static int LongestUniqueSubStr(String s) {
    int N = s.length();
    int cur_len = 1;
    int max_len = 1;
    int prev_index;

    int[] visited = new int[256];

    for(int i = 0; i < N; i++)
      visited[s.charAt(i)] = -1;

    visited[s.charAt(0)] = 0;

    for(int i = 1; i < N; i++) { //start from 1 becoz 0 is arleted visited.

      prev_index = visited[s.charAt(i)];

      if(prev_index == -1 || i - cur_len > prev_index)
        cur_len++;

      else {

        if(cur_len > max_len)
          max_len = cur_len;

        cur_len = i - prev_index;
      }

      visited[s.charAt(i)] = i;
    }

    if(cur_len > max_len)
      max_len = cur_len;

    return max_len;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(LongestUniqueSubStr(br.readLine()));
  }
}


