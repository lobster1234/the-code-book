package org.lobster1234;

/**
 * Page 10 of the book. While the convention is to have plaintext in lowercase and
 * cipher text in uppercase, this implementation handles cases and retains the original case
 * from the plaintext.
 */
public class CaesarCipher {

    static char[] chars = new char[26];

    static{
        for(int i=0;i<26;i++){
            chars[i] = (char) (i+'A');
        }
    }

    public static String encrypt(String text, int shift){
        StringBuilder builder = new StringBuilder();
        text.chars().forEach( c -> {
            if(!Character.isAlphabetic(c)) {
                builder.append((char)c);
            } else {
                int newIndex = Character.isUpperCase(c) ?  c -'A' + shift : c - 'a' + shift;
                if(newIndex >= 26){
                    newIndex = newIndex%26;
                }
                if(Character.isLowerCase(c))
                    builder.append(Character.toLowerCase(chars[newIndex]));
                else builder.append(chars[newIndex]);
            }
        });
        return builder.toString();
    }

    public static String decrypt(String text, int shift){
        StringBuilder builder = new StringBuilder();
        text.chars().forEach( c -> {
            if(!Character.isAlphabetic(c)) {
                builder.append((char)c);
            } else {
                int newIndex = Character.isUpperCase(c) ?  c -'A' - shift : c - 'a' - shift;
                if(newIndex <=-1 ){
                    newIndex = newIndex+26;
                }
                if(Character.isLowerCase(c))
                    builder.append(Character.toLowerCase(chars[newIndex]));
                else builder.append(chars[newIndex]);
            }
        });
        return builder.toString();
    }
}
