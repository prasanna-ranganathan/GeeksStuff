import java.lang.*;
import java.io.*;
import java.util.*;

class AnagramsTogether {
  public static String[] SortAllWords(String[] arr) {
    String[] res = new String[arr.length];
    int i = 0;
    for(String s : arr) {
      char[] a = s.toCharArray();
      Arrays.sort(a);
      s = new String(a);
      res[i++] = s;
    }
    return res;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    String[] sortedword = SortAllWords(s);
    HashMap<String,String> map = new HashMap<String,String>();
    int i = 0;
    for(String str : sortedword) {
      if(map.containsKey(str)) {
        map.put(str,map.get(str) + "," + s[i++]);
      } else
        map.put(str,s[i++]);
    }
    for(String str : map.keySet()) 
      System.out.println(map.get(str));
  }
}


