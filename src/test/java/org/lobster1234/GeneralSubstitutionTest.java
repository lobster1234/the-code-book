package org.lobster1234;

import junit.framework.TestCase;

public class GeneralSubstitutionTest extends TestCase {

    private GeneralSubstitution sub;
    @Override
    protected void setUp(){
        sub = new GeneralSubstitution("jlpawiqbctrzydskegfxhuonvm");
    }

    public void testEncrypt() {
        String cipher = sub.encrypt("et tu, brute?");
        assertEquals(cipher,"wx xh, lghxw?");
    }

    public void testDecrypt() {
        assertEquals(sub.decrypt("wx xh, lghxw?"),"et tu, brute?");
    }
}