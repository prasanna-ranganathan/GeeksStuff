import java.util.*;
import java.io.*;
import java.lang.*;

class StringRotation {
    public static boolean isSubString(String s1,String s2) {
        if(s1.indexOf(s2) >= 0)
            return true;
        else
            return false;
    }

    public static boolean areRotation(String s1,String s2) {

        if(s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1,s2);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        if(areRotation(s1,s2))
            System.out.println("Yes! Strings are Rotation of each other");
        else
            System.out.println("Nope! String are notRaotable");
    }
}


