package org.example.pickOrLeave.easyProplems;

import java.util.Arrays;
import java.util.Objects;

public class SubsetSubProplem {
   private int array[];
   private int memeory[][];
   public int counter=0;
   public SubsetSubProplem(int array[] ){
       this.array=array;
       memeory=new int[2001][501 ];
       for(int row[]:memeory)
           Arrays.fill(row,-1);
   }
   private void setInMemory(int row,int column,int value){
           memeory[row][column]=value;
   }

   private int getFromMemory(int row,int column){
       return memeory[row][column];
   }
   boolean subsetSumRecursively(int remain, int index){

            if(index>=array.length)
                    return remain==0;
            counter++;
            if(remain==0)
                    return true;
            int result=getFromMemory(remain,index);
            if(result!=-1)

                return result==0?false:true;

            boolean greater= subsetSumRecursively(remain,index+1);
             boolean smaller=false;
           if(remain-array[index]>=0 )
                smaller= subsetSumRecursively(remain-array[index],index+1);
           result=(smaller||greater)==true?1:0;
           setInMemory(remain,index,result);
           return smaller||greater;
   }


   static void process_case(int[] array, int value, boolean expected){
            SubsetSubProplem subsetSubProplem = new SubsetSubProplem(array);
            int start=0;
       Objects.equals(expected,subsetSubProplem.subsetSumRecursively(value,start));
       System.out.println(subsetSubProplem.counter);
   }

   static void test1(){
       process_case( new int[]{ 3, 12, 4, 12, 5, 2 }, 9, true);
       process_case( new int[] { 3, 40, 4, 12, 5, 2 }, 30, false);
       process_case(  new int[]{ 10, 20, 30, 40, 50 }, 60, true);
       process_case(  new int[]{ 10, 20, 30, 40, 50 }, 100, true);
       process_case(  new int[]{ 10, 20, 30, 40, 50 }, 90, true);
       process_case(  new int[]{ 10, 20, 30, 40, 50 }, 70, true);
       process_case( new int[] { 10, 20, 30, 40, 50 }, 200, false);
       process_case(  new int[]{ 200 }, 300, false);
       process_case( new int[] { 200 }, 200, true);
   }
    public static void main(String[] args) {
        test1();
    }
}
