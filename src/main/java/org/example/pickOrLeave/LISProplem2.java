package org.example.pickOrLeave;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LISProplem2 {
    int array[];
    int memory[]=new int [16];
    public LISProplem2(int array[] ) {
        this.array = array;
        Arrays.fill(memory, -1);
    }
    public void setInMemory(int index ,int result  ) {
        memory[index] = result;

    }
    public int getFromMemory(int index){
        return memory[index];
    }
    public int Lis(int index){
         if(index>=array.length)
                return 0;
         int result=getFromMemory(index);
         if(result!=-1)
             return result;

         result=0;
         for(int i=index+1;i<array.length;++i)
               if(array[index]<array[i])
                   result=Math.max(result,Lis(i));
         result+=1;
         setInMemory(index,result);
        return result;



    }

    public  int lengthOfLIS(){
        int result=0;
        for (int i = 0; i < array.length; i++) {
            int start=Lis(i);
            result=Math.max(result,start);

                System.out.println(Arrays.toString(memory));
        }
        return result;
    }
    public static void main(String[] args) {
        int array[]={15, 2, 7, 4, 6,6};
        LISProplem2 lis=new LISProplem2(array);
        int start=0;
        System.out.println(lis.lengthOfLIS());
    }
}
