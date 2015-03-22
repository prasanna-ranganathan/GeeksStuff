import java.util.HashMap;
import java.io.*;

class NRCSExcerise {
  public static String UniqueSubstr(String s) {
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();

    char c = s.charAt(0);
    map.put(c,0);

    if(s == null || s.length() < 0)
      return "";

    int N = s.length();
    int cur_len = 1;
    int max_len = 1;
    int startIndex = 0;
    String str = null;

    for(int i = 1; i < N; i++) {

      char X = s.charAt(i);
      if(!map.containsKey(X) || i - cur_len > map.get(X) || X == ' ')
        cur_len++;

      else {
        if(cur_len > max_len) {
          max_len = cur_len;
          str = s.substring(startIndex,startIndex + max_len);
        }
        cur_len = i - map.get(X);
        startIndex = cur_len + 1;
      }
      map.put(X,i);
    }
    if(cur_len > max_len) {
      max_len = cur_len;
      str = s.substring(startIndex,startIndex + max_len);
    }
    return str;
  }
  public static void main(String[] args) throws Exception {
    String[] test={"GeeksForGeeks","king of japan","aaabbbc","aabbbbabc"};
    for(String s : test)
      System.out.println(UniqueSubstr(s));
  }
}
