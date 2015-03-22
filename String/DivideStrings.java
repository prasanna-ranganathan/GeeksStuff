import java.util.*;
import java.io.*;
import java.lang.*;

class DivideStrings {
    public static void divideString(String s, int n) {
        int len = s.length();
        
        if(len % n != 0){
            System.out.println("OOPs! Not divisible by n");
            return;
        }
        
        int part_size = len / n;
        for(int i = 0; i < len; i++) {
            if(i % part_size == 0)
                System.out.println();
            System.out.print(s.charAt(i));
        }
    }

    public static void main(String [] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String a = br.readLine();
       int N = Integer.parseInt(br.readLine());
       divideString(a,N);
    }
}
