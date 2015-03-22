import java.util.*;
import java.io.*;
import java.lang.*;

class RemoveDup {
    public static String removeDup(String s) {
        if(s == null || s.length() <= 0)
             return "";

        Set<String> set = new LinkedHashSet<String>();
       
        StringBuilder str = new StringBuilder();

        for(int i = 0 ; i < s.length(); i++) 
            set.add(s.valueOf(s.charAt(i)));
        
        for(String a : set)
            str.append(a);

       return str.toString();
    }
    //Method 2 O(n)
    public static String removeDup2(String s) {
        
        int[] count = new int[26];
        
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < s.length(); i++) {

            if(count[s.charAt(i) - 'a'] != 0)  {
                str.append(s.charAt(i));
                count[s.charAt(i) - 'a'] = 0;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(removeDup2(line));
    }
}
