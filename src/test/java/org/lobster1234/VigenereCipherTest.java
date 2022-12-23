package org.lobster1234;

import junit.framework.TestCase;

public class VigenereCipherTest extends TestCase {

    VigenereCipher c;
    public void setUp() {
        c = new VigenereCipher("white");
    }

    public void testPrintSquare(){
        c.printSquare();
    }
    public void testEncrypt() {
        String cipherText = c.encrypt("diverttroopstoeastridge");
        assertEquals(cipherText, "zpdxvpazhslzbhiwzbkmznm");
    }

    public void testDecrypt() {
        String cipherText = "zpdxvpazhslzbhiwzbkmznm";
        String plainText = c.decrypt(cipherText);
        assertEquals(plainText,"diverttroopstoeastridge");
    }
}