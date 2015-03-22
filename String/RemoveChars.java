import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveChars {
    public static String DeleteChars(String s1,String s2) {
        if(s1 == null || s2 == null)
            return s1;

        char[] c = s1.toCharArray();

        HashMap<Character,Boolean> htable = new HashMap<Character,Boolean>();
        for(int i = 0; i < s2.length(); i++)
            htable.put(s2.charAt(i),true);

        int end = 0;
        for(int i = 0; i < c.length; i++) {
            if(htable.containsKey(c[i]))
                continue;
            
            c[end++] = c[i];
        }
        return new String(c,0,end);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(DeleteChars(s1,s2));
    }
}

