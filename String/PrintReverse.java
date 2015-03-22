import java.util.*;
import java.lang.*;
import java.io.*;

class PrintReverse {
    public static void printreverse(char[] c,int next) {
        if(next >= c.length)
            return;
        printreverse(c,next + 1);
        System.out.print(c[next]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printreverse(br.readLine().toCharArray(),0);
        System.out.println();
    }
}
    
