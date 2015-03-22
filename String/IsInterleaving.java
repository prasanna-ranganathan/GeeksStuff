import java.io.*;
import java.math.*;
import java.util.*;

class isInterleaving {
  public static boolean isInterleave(String A,String B,String C) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();
    char[] c = C.toCharArray();

    int M = A.length();
    int N = B.length();

    if((M+N) != C.length())
      return false;
    
    if(M == 0 || N == 0 || C.length() == 0)
      return false;

    boolean[][] IL = new boolean[M+1][N+1];

    for(int i = 0; i <= M; i++) {
      for(int j = 0; j <= N; j++) {
        
        if(i == 0 && j == 0)
          IL[i][j] = true;

        //if A is emtpy
        else if(i == 0 &&  b[i-1] == c[j-1])
          IL[i][j] = 
