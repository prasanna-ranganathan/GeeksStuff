import java.io.*;
import java.lang.*;
import java.util.*;

class MaximumCharacter {
    private static int[] count;

    private static void getMaxOccuring(String s) {
        int count2[] = getCountArray(s);
        getIndexMaxof(count2,s);
    }

    private static int[] getCountArray(String s) {
        count = new int[26];

        for(int i = 0; !s.isEmpty(); i++)
            count[(int)s.charAt(i) - 65]++;
        
        return count;
    }

    private static void getIndexMaxof(int[] a,String s) {
        int max_index = 0;
        for(int i = 1; i<a.length; i++) 
            if(a[i] > a[max_index])
                max_index = i;
        System.out.println(s.charAt(max_index));
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        getMaxOccuring(s);
    }
}    
