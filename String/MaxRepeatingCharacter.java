import java.util.*;
import java.lang.*;
import java.io.*;
 
class MaxRepeatingCharacter {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int count = 1,arraycount = 0;
        String str = in.nextLine();
        char[] c = new char[26];
        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                count = map.get(str.charAt(i));
                count++;
                map.remove(str.charAt(i));
                map.put(str.charAt(i),count);
            } else  {
                count = 1;
                map.put(str.charAt(i),count);
                c[arraycount++] = str.charAt(i);
            }
        }

        int max = 0,min = 0;
        char x;
        max = map.get(c[0]);
        x = c[0];
        for(int i = 1; i < c.length-1; i++) {
            if(map.containsKey(c[i])) {
                min = map.get(c[i]);
                if(max < min) {
                    max = min;
                    x = c[i];
                }
            }
        }
        System.out.println("Max charac = " + x + " Rep=" + max);
    }
}

