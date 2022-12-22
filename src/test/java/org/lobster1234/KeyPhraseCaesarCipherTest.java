package org.lobster1234;

import junit.framework.TestCase;

public class KeyPhraseCaesarCipherTest extends TestCase {

    KeyPhraseCaesarCipher c;
    public void setUp() {
        c = new KeyPhraseCaesarCipher("juliuscaesar");
    }

    public void testEncrypt() {
        String encrypted = c.encrypt("hello world!");
        assertEquals(encrypted, "eswwz nzfwi!");
    }

    public void testDecrypt() {
        String encrypted = c.decrypt("eswwz nzfwi!");
        assertEquals(encrypted,"hello world!");
    }
}