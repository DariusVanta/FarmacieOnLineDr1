package Service;
import java.util.*;

public class Palindrome {

    public boolean Palindrome(String palindrom) {

        String original = "";
        String reverse = ""; // Objects of String class
        //Scanner in = new Scanner(System.in);

        //System.out.println("Enter a string to check if it is a palindrome");
        //original = in.nextLine();


       // Scanner in = new Scanner(System.in);

        //System.out.println("Enter a string to check if it is a palindrome");
        original = palindrom;

        int length = original.length();

        for (
                int i = length - 1;
                i >= 0; i--)
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse))
            return true;// System.out.println("The string is a palindrome.");
        else
            return false;//     System.out.println("The string isn't a palindrome.");

    }
}

/*
    String wort = "reliefpfpfeiller";
    char[] warray = wort.toCharArray();
        System.out.println(istPalindrom(warray));

    public static boolean istPalindrom(char[] wort){
        boolean palindrom = false;
        if(wort.length%2 == 0){
            for(int i = 0; i < wort.length/2-1; i++){
                if(wort[i] != wort[wort.length-i-1]){
                    return false;
                }else{
                    palindrom = true;
                }
            }
        }else{
            for(int i = 0; i < (wort.length-1)/2-1; i++){
                if(wort[i] != wort[wort.length-i-1]){
                    return false;
                }else{
                    palindrom = true;
                }
            }
        }
        return palindrom;
    }
    */
