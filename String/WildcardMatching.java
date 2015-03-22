import java.util.*;
import java.lang.*;
import java.io.*;

class WildcardMatching {
  public static boolean isMatch(String s,String p) {
    int plen = p.length();
    int slen = s.length();

    if(plen == 0) {
      if(slen == 0)
        return true;
      else
        return false;
    }

    int i = 0,j = 0;
    int nextp = -1,nexts = -1;

    while(i < slen) {

      if(j < plen && (p.charAt(j) == '?' || p.charAt(j) == p.charAt(i))) {
        i++;
        j++;
      } else if( j < plen && p.charAt(j) == '*') {
        nextp = j;
        nexts = i;
        j++; //increment only j
      } else {
        if(nextp == -1)
          return false;
        else {
          nexts++;
          i = nexts;
          j = nextp + 1;
        }
      }
    }
    while(j < plen && p.charAt(j) == '*')
      j++;

    return (j == plen);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    if(isMatch(br.readLine(),br.readLine()))
      System.out.println("Yes! Wildcard matching found");
    else
      System.out.println("No! its not found");
  }
}


