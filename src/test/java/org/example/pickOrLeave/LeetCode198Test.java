package org.example.pickOrLeave;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode198Test {


    @Test
  void rob(  ) {
        int array1[]={1 ,2, 3};
        LeetCode198 soluation=new LeetCode198();

        assertEquals(soluation.rob(array1),4);
        array1=new int[]{2,7,9,3,1};
        assertEquals(soluation.rob(array1),12);


    }
}