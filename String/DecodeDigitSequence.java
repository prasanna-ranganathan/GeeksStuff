import java.util.*;
import java.io.*;

class DecodeDigitSequence {
  public static Set<String> decode(String prefix,String code) {
    Set<String> set = new HashSet<String>();
    int N = code.length();

    if(N == 0) {
      set.add(prefix);
      return set;
    }

    if(code.charAt(0) == '0')
      return set;

    set.addAll(decode((prefix + (char)(code.charAt(0) - '1' + 'a')),code.substring(1)));

    if(code.length() >= 2 && code.charAt(0) == '1')
      set.addAll(decode((prefix + (char)(10 + code.charAt(0) - '1' +  'a')),code.substring(2)));

    if(code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6')
      set.addAll(decode((prefix + (char)(20 + code.charAt(0) - '1' + 'a')),code.substring(2)));

          return set;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    for(String str : decode("",s))
        System.out.println(str);
  }
}
