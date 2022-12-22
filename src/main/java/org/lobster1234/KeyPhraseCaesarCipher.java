package org.lobster1234;

import java.util.ArrayList;
import java.util.List;

/**
 * KeyPhrase Caesar Cipher (Page 13) of the book
 */
public class KeyPhraseCaesarCipher {
    String keyPhrase;

    List<Character> alphabetMap = new ArrayList<>();

    public KeyPhraseCaesarCipher(String keyPhrase){
        this.keyPhrase = keyPhrase;
        //we populate the alphabet map
        for(char c: keyPhrase.toCharArray()){
            if(!alphabetMap.contains(c)) alphabetMap.add(c);
        }
        //next we fill the map in order
        char toInsert = (char) (alphabetMap.get(alphabetMap.size()-1)+1);
        while(alphabetMap.size()<26){
            if(toInsert == 'z'+1){
                toInsert = 'a';
            }
            if(!alphabetMap.contains(toInsert))
                alphabetMap.add(toInsert);
            else toInsert+=1;
        }
    }

    public String encrypt(String plainText){
        StringBuilder builder = new StringBuilder();
        for(char c : plainText.toLowerCase().toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c))
                builder.append(alphabetMap.get(c-'a'));
            else builder.append(c);
        }
        return builder.toString();
    }

    public String decrypt(String cipherText){
        StringBuilder builder = new StringBuilder();
        for(char c : cipherText.toLowerCase().toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c))
                builder.append((char) ('a'+alphabetMap.indexOf(c)));
            else builder.append(c);
        }
        return builder.toString();
    }
}
