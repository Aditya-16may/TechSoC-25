// code is in java : PS 01 Level 1

import java.util.*;

// without using ASCII or inbuilt library : All from scratch

public class Level1{

    static String Capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String Small = "abcdefghijklmnopqrstuvwxyz";

    // checking if it is capital
    public static boolean is_Capital(char a){
        for (int j=0; j<Capital.length(); j+=1){
            if(a == Capital.charAt(j)){
                return true;
            }
        }
        return false;
    }

    // or small
    public static boolean is_Small(char a){
        for (int j=0; j<Small.length(); j+=1){
            if(a == Small.charAt(j)){
                return true;
            }
        }
        return false;
    }

    public static void Decode(StringBuilder code, int shift){
        for (int i=0; i<code.length(); i+=1){
            if(is_Capital(code.charAt(i)) == true){
                int j=0;
                
                // running a while loop to find the index of the capital letter found 
                while(code.charAt(i)!=Capital.charAt(j)){
                    j+=1;
                }
                //shifting  of the letters 
                int index = (j-shift + Capital.length())% Capital.length(); // Using modulo and before dividing adding it Capital.length() to avoid getting negative or out of bound index.
                code.setCharAt(i, Capital.charAt(index));
            }

            if(is_Small(code.charAt(i)) == true){
                int j=0;
                // same while loop to find the index for small letter 
                while(code.charAt(i)!= Small.charAt(j)){
                    j+=1;
                }
                // shfiting and replacing the letters
                int index = (j-shift + Small.length())% Small.length(); // Using modulo and before dividing adding it Capital.length() to avoid getting negative or out of bound index.
                code.setCharAt(i, Small.charAt(index));
            }
        }
        System.out.println("Decoded code is : " + code);
    }

    // creating an encode function 
    public static void Encode(StringBuilder code, int shift){
        for(int i=0; i<code.length(); i+=1){

            if(is_Capital(code.charAt(i)) == true){
                int j=0;
                
                // running a while loop to find the index of the capital letter found 
                while(code.charAt(i)!=Capital.charAt(j)){
                    j+=1;
                }
                //shifting  of the letters 
                int index = (j+shift)% Capital.length();
                code.setCharAt(i, Capital.charAt(index));
            }

            if(is_Small(code.charAt(i)) == true){
                int j=0;
                // same while loop to find the index for small letter 
                while(code.charAt(i)!= Small.charAt(j)){
                    j+=1;
                }
                // shfiting and replacing the letters
                int index = (j+shift) % Small.length();
                code.setCharAt(i, Small.charAt(index));
            }
        }
        // printing the encoded code 
        System.out.println("Encoded code is : " + code);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    // with ASCII and inbuilt library : No need of Capital and Lower String and boolean functions to check and the inner iteration to find index of letters 
    
    public static void ENCODE(StringBuilder code, int shift){

        // traversing over code to change each element 
        for(int i=0; i<code.length(); i+=1){

            // using library to check if UpperCase or not
            if(Character.isUpperCase(code.charAt(i))){
                char newchar = (char)('A' + (code.charAt(i) - 'A' + shift) % 26); // Using ASCII code for characters to shift them
                code.setCharAt(i, newchar); // replacing the new character with the odd one 
            }

            // Using library to check if lowercase or not 
            if(Character.isLowerCase(code.charAt(i))){
                char newchar = (char)('a' + (code.charAt(i) - 'a' + shift) % 26); // ASCII for small numbers
                code.setCharAt(i, newchar);
            }
        }

        System.out.println("Encoded code is : " + code);
    }

    public static void DECODE(StringBuilder code, int shift){
        for (int i=0; i<code.length(); i+=1){

            // using library to check if UpperCase or not
            if(Character.isUpperCase(i)){
                char newchar = (char)('A' + (code.charAt(i) - 'A' - shift + 26) % 26); // Using ASCII code for characters to shift them
                code.setCharAt(i, newchar); // replacing the new character with the odd one 
            }

            // Using library to check if lowercase or not 
            if(Character.isLowerCase(i)){
                char newchar = (char)('a' + (code.charAt(i) - 'a' - shift + 26) % 26); // ASCII for small numbers
                code.setCharAt(i, newchar);
            }
        }
        System.out.println("Decoded code is : " + code);
    }
    
    public static void main(String[] args){
        
        // taking code as input 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code : ");
        String c = sc.nextLine();

        // converting string to stringBuilder as Strings are immutable in Java
        StringBuilder code = new StringBuilder(c);

        // taking the shift he wants 
        System.out.print("Enter the number by which you wanna shift : ");
        int shift = sc.nextInt();
        Encode(code,shift);
        Decode(code, shift);
        ENCODE(code, shift);
        DECODE(code, shift);

        // closing the scanner to prevent data loss
        sc.close();
    }
}