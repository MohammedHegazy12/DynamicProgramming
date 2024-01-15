package org.example.editDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegerBreak {
    @Test
    void testIntegerBreak(){
        IntegerBreak sol=new IntegerBreak();
        assertAll(()-> {
            assertEquals(sol.integerBreak(7), 12);
            assertEquals(sol.integerBreak(2), 1);
            assertEquals(sol.integerBreak(3),2);
            assertEquals(sol.integerBreak(5),6);
        });
    }
}
