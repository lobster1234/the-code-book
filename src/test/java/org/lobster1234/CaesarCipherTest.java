package org.lobster1234;

import junit.framework.TestCase;

public class CaesarCipherTest extends TestCase {

    public void testEncrypt() {
        assertEquals(CaesarCipher.encrypt("veni, vidi, vici",3),"yhql, ylgl, ylfl");
    }

    public void testDecrypt() {
        assertEquals(CaesarCipher.decrypt("yhql, ylgl, ylfl",3),"veni, vidi, vici");
    }
}