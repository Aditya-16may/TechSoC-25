// code is in java : PS 01 Level 1

import java.util.*;

//----------------------------------------------------------------- ` LEVEL 1 ----------------------------------------------------------------------------------

// without using ASCII or inbuilt library : All from scratch

public class ProblemStatement_1{

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

            else if(is_Small(code.charAt(i)) == true){
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

            else if(is_Small(code.charAt(i)) == true){
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
    
    public static String ENCODE(StringBuilder code, int shift){

        // traversing over code to change each element 
        for(int i=0; i<code.length(); i+=1){

            // using library to check if UpperCase or not
            if(Character.isUpperCase(code.charAt(i))){
                char newchar = (char)('A' + (code.charAt(i) - 'A' + shift) % 26); // Using ASCII code for characters to shift them
                code.setCharAt(i, newchar); // replacing the new character with the odd one 
            }

            // Using library to check if lowercase or not 
            else if(Character.isLowerCase(code.charAt(i))){
                char newchar = (char)('a' + (code.charAt(i) - 'a' + shift) % 26); // ASCII for small numbers
                code.setCharAt(i, newchar);
            }
        }

        return code.toString();
    }

    public static String DECODE(StringBuilder code, int shift){
        for (int i=0; i<code.length(); i+=1){

            // using library to check if UpperCase or not
            if(Character.isUpperCase(code.charAt(i))){
                char newchar = (char)('A' + (code.charAt(i) - 'A' - shift + 26) % 26); // Using ASCII code for characters to shift them
                code.setCharAt(i, newchar); // replacing the new character with the odd one 
            }

            // Using library to check if lowercase or not 
            else if(Character.isLowerCase(code.charAt(i))){
                char newchar = (char)('a' + (code.charAt(i) - 'a' - shift + 26) % 26); // ASCII for small numbers
                code.setCharAt(i, newchar);
            }
        }
        return code.toString();
    }

    



    // ------------------------------------------------------------------ LEVEL 2 --------------------------------------------------------

    // DICTIONARY METHOD
    public static boolean is_frequent(String text){
        String[] dictionary = {"the", "are", "is", "am", "has", "have", "was", "were","shall","will","would","should","could"};

        text = text.toLowerCase().replaceAll("[^a-z]", " ");
        String words[] = text.split("\\s+");
        for(String word : words){
            for(String dictword : dictionary){
                if(word.equals(dictword)){
                    return true;
                }
            }
        }
        return false;
    }

    // FREQUENCY METHOD
    public static int findshift(String cipher){
        int[] fre = new int[26];

        cipher = cipher.toLowerCase();
        for (char c : cipher.toCharArray()){
            if(Character.isLetter(c)){
                fre[c - 'a']++;
            }
        }
        
        int max_index = 0;
        for (int i=0; i<26; i+=1){
            if(fre[max_index]<fre[i]){
                max_index = i;
            }
        }

        int shift = (max_index - ('e'-'a') + 26)% 26;
        return shift;
    }


    //--------------------------------------------------------------------- LEVEL 3 -------------------------------------------------------------------------------------

    // Convert keyword into shift values
    public static int[] getShifts(String keyword) {
        keyword = keyword.toUpperCase();
        int[] shifts = new int[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            shifts[i] = keyword.charAt(i) - 'A'; // A=0 ... Z=25
        }
        return shifts;
    }

    // Encode with Keyword Caesar
    public static String encodeCaesar(String text, String keyword) {
        int[] shifts = getShifts(keyword);
        StringBuilder encoded = new StringBuilder();

        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpper = Character.isUpperCase(c);
                char base = isUpper ? 'A' : 'a';
                int shift = shifts[k % shifts.length];
                char newChar = (char) ((c - base + shift) % 26 + base);
                encoded.append(newChar);
                k++;
            } else {
                encoded.append(c); // keep spaces/punctuations
            }
        }
        return encoded.toString();
    }

    // Decode with Keyword Caesar
    public static String decodeCaesar(String text, String keyword) {
        int[] shifts = getShifts(keyword);
        StringBuilder decoded = new StringBuilder();

        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpper = Character.isUpperCase(c);
                char base = isUpper ? 'A' : 'a';
                int shift = shifts[k % shifts.length];
                char newChar = (char) ((c - base - shift + 26) % 26 + base);
                decoded.append(newChar);
                k++;
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    // Base64 Encode
    public static String base64Encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    // Base64 Decode
    public static String base64Decode(String base64) {
        return new String(Base64.getDecoder().decode(base64));
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
        sc.nextLine();
        Encode(code,shift);
        Decode(code, shift);
        ENCODE(code, shift);
        DECODE(code, shift);


        // ----------------------------------------------------- LEVEL 2 (MAIN CALL) -----------------------------------------------------------------
        
        System.out.print("Enter the coded word to decode : ");
        String encoded = sc.nextLine();

        int guessed_shift = findshift(encoded);

        String bestResult = null;
        int bestShift = -1;
        for(int s = guessed_shift-2; s <=guessed_shift +2; s+=1){
            if(s<0){
                continue;
            }
            if(s>25){
                continue;
            }

            String decoded = DECODE(new StringBuilder(encoded), s);
            if(is_frequent(decoded)){
                bestResult = decoded;
                bestShift = s;
                break;
            }
        }

        if(bestResult != null){
            System.out.println("Auto-detected plaintext: " + bestResult);
            System.out.println("Shift used: "+ bestShift);
        }else {
            System.out.println("No plaintext text found near guessed value !");
            System.out.println("Trying all shifts now ....\n");

            boolean foundAny = false;
            
            for(int i=1; i<26; i+=1){
                String decoded = DECODE(new StringBuilder(encoded), i);
                if(is_frequent(decoded)) {
                    System.out.println("Detected plaintext: " + decoded);
                    System.out.println("Shift used: " + i);
                    foundAny = true;
                    break;
                }
            }
            if(!foundAny){
                System.out.println("Still no valid dictionary match found.");
                System.out.println("Possible decodes are .... \n");
                for(int i=1; i<26; i+=1){
                    String decoded = DECODE(new StringBuilder(encoded), i);
                    System.out.println("text " + i + " " + decoded);
                }
            }
        }
        
        // ------------------------------------------------------------- LEVEL 3 (MAIN CALL) ---------------------------------------------------------------

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        // Step 1: Caesar Encode
        String caesarEncoded = encodeCaesar(msg, keyword);

        // Step 2: Base64 Encode
        String base64Encoded = base64Encode(caesarEncoded);
        System.out.println("Encoded Message (Keyword + Base64): " + base64Encoded);

        // Step 3: Base64 Decode + Caesar Decode
        String base64Decoded = base64Decode(base64Encoded);
        String finalDecoded = decodeCaesar(base64Decoded, keyword);
        System.out.println("Decoded Message: " + finalDecoded);


        // closing the scanner to prevent data loss
        sc.close();

        



    }
}