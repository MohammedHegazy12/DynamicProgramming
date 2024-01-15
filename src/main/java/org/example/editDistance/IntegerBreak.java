package org.example.editDistance;


import java.util.Arrays;

import static java.lang.Math.max;

public class IntegerBreak {
    int memory[]=new int[10000];

   private   int sum(int number){
            if(number==1)
                return 1;

            int result=memory[number];
            if(result!=-1)
                return result;
            result=number;
        for (int i =1    ; i <number ; i++) {

            result=max(result,i*sum(number-i));
            memory[number]=result;

        }
        return result;
    }
    public int integerBreak(int number){
         if(number==2||number==3 )
                return number-1;

        Arrays.fill(memory,-1);
         return sum(number);
    }
}
