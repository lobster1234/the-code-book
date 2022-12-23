package org.lobster1234;

/**
 * The Vigenere Cipher - Page 48 of the book.
 * While the book refers the Vigenere Square with Caesar shift of 1, most references online
 * have no shift.
 * In this implementation I've not used the "row 1 col 0 = shift by 1" model as it is called out in the book,
 * but the code can be easily adjusted to shift if needed.
 */
public class VigenereCipher {
    char[][] square = new char[26][26];

    String keyPhrase;

    public VigenereCipher(String keyPhrase){
        this.keyPhrase = keyPhrase;
        for(int rows = 0;rows <26;rows++){
            for(int cols = 0;cols<26;cols++){
                char toInsert = (char) ('a'+cols+rows);
                if(toInsert > 'z') toInsert = (char) (toInsert -'z'+'a'-1);
                square[rows][cols] = toInsert;
            }
        }
    }

    public String encrypt(String plainText){
        //We use the key phrase to build a key stream the same size as plain text
        StringBuilder builder = new StringBuilder();
        StringBuilder keyStream = new StringBuilder();
        while(keyStream.length() <= plainText.length()){
            keyStream.append(keyPhrase);
        }
        keyStream.delete(plainText.length(),keyStream.length());
        //now we build the cipher text
        for(int i=0;i<plainText.length();i++){
            //key stream defines the rows, plaintext defines the columns
            int row = keyStream.charAt(i)-'a';
            int col = plainText.charAt(i)-'a';
            builder.append(square[row][col]);
        }
        return builder.toString();
    }

    public String decrypt(String cipherText){
        //we build the key stream same size as cipherText
        StringBuilder builder = new StringBuilder();
        StringBuilder keyStream = new StringBuilder();
        while(keyStream.length() <= cipherText.length()){
            keyStream.append(keyPhrase);
        }
        keyStream.delete(cipherText.length(),keyStream.length());
        for(int i=0;i<cipherText.length();i++){
            int row = keyStream.charAt(i) - 'a';
            //now we find the column where the cipherText is
            int col = 0;
            for(int j=0;j<26;j++){
                if(square[row][j] == cipherText.charAt(i)) {
                    col = j;
                }
            }
            //The character want is the alphabet with that index (a=0,b=1...)
            builder.append((char) ('a'+col));
        }
        return builder.toString();
    }

    public void printSquare(){
        for(int rows = 0;rows<26;rows++){
            for(int cols = 0; cols < 26; cols++){
                System.out.printf(" %c ", square[rows][cols]);
            }
            System.out.println();
        }
    }
}
