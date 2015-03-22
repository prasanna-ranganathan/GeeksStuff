import java.util.*;
import java.io.*;
import java.lang.*;

class PrintDups {
    public static void printDups(String s) {
        int[] count = new int[256];
        
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;

        for(int i = 0; i < 256; i++)
            if(count[i] > 1)
                System.out.printf("%c, count =  %d \n",i,count[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        printDups(line);
    }
}

