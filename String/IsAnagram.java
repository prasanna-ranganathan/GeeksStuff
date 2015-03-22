import java.util.*;
import java.lang.*;
import java.io.*;

class IsAnagram {

  //using Sorting
  public static boolean isAnagram(String s1,String s2) {
    if(s1 == null || s2 == null)
      return false;
    if(s1.length() != s2.length())
      return false;

    char[] a = s1.replaceAll("[\\s]","").toCharArray();
    char[] b = s2.replaceAll("[\\s]","").toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a,b);
  }

  //Using Count Array
  private static boolean areAnagram(String s1,String s2){
    if(s1 == null || s2 == null)
      return false;

    if(s1.length() != s2.length())
      return false;

    HashMap<Character,Integer> map = new HashMap<Character,Integer>();

    for(int i = 0; i <s1.length(); i++) {

      char a = s1.charAt(i);
      int count1 = map.containsKey(a) ? map.get(a) : 0;

      map.put(a,++count1);

      char b = s2.charAt(i);
      int count2 = map.containsKey(b) ? map.get(b) : 0;

      map.put(b,--count2);
    }

    for(int i : map.values())
      if(i != 0)
        return false;

   return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();

    System.out.println(areAnagram(s1,s2));
  }
}
