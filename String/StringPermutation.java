import java.util.*;
import java.io.*;

class StringPermutation {
  public static void perm1(String s) { perm1("",s); }
  //Permutation of elements in Order
  private static void perm1(String prefix,String s) {
    int N = s.length();
    if(N == 0) System.out.println(prefix);

    else {
      for(int i = 0; i < N; i++) {
//        System.out.print(" Prefix: " + prefix + s.charAt(i) + " Substring(o,i): " + s.substring(0,i) + " Substring(i+1,N):  " + s.substring(i+1,N) + " ");
        perm1(prefix + s.charAt(i) ,s.substring(0,i) + s.substring(i+1,N));
      }
    }
  }

  //Permutatio of Elements Not in order
  public static void perm2(String s) {
    int N = s.length();
    char[] a = new char[N];
    for(int i = 0; i <  N; i++)
      a[i] = s.charAt(i);
    perm2(a,N);
  }

  private static void perm2(char[] a,int n) {
    if( n == 1 ) {
      System.out.println(a);
      return;
    }
    
    for(int i = 0; i < n; i++) {
      swap(a,i,n-1);
      perm2(a,n-1);
      swap(a,i,n-1);
    }
  }

  private static void swap(char[] a,int i,int j) {
    char c;
    c = a[i]; a[i] = a[j]; a[j] = c;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    perm1(s);
    System.out.println();
//    perm2(s);
  }
}
