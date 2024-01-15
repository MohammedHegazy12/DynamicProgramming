package org.example.editDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEditDistence {
    @Test
    void testEditDistanceMethod(){
        StringBuilder str1=new StringBuilder("horse");
        StringBuilder str2=new StringBuilder("");
        EditDistence soluation=new  EditDistence(str1,str2);

        assertAll(()-> {
            assertEquals(soluation.editDistence(str1, str2), 5);
            assertEquals(soluation.editDistence(new StringBuilder("rose"), new StringBuilder("rose")), 0);
            assertEquals(soluation.editDistence(new StringBuilder("rose"), new StringBuilder("ros")), 1);
            assertEquals(soluation.editDistence(new StringBuilder(""),new StringBuilder(" ")),1);
            assertEquals(soluation.editDistence(new StringBuilder(""),new StringBuilder("")),0);

        });

    }
}
