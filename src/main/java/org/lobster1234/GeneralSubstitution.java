package org.lobster1234;

/**
 * This is general substitution (Page 12).
 * For simplicity, I've used lower case for both the key and the plaintext.
 * Checks for isUpper/isLower can be added to make the code handle all cases (see CaesarCipher).
 */
public class GeneralSubstitution {

    String key;
    public GeneralSubstitution(String key){
        this.key = key;
    }

    public String encrypt(String plain){
        StringBuilder builder = new StringBuilder();
        for(char c : plain.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c))
                builder.append(key.charAt(c-'a'));
            else builder.append(c);
        }
        return builder.toString();
    }

    public String decrypt(String cipher){
        StringBuilder builder = new StringBuilder();
        for(char c: cipher.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c))
                builder.append((char) ('a'+key.indexOf(c)));
            else builder.append (c);
        }
        return builder.toString();
    }

}
