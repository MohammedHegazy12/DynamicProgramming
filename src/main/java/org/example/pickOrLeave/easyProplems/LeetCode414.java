package org.example.pickOrLeave.easyProplems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class LeetCode414 {
    private int array[];
    private int memeory[][]=new int[200*100+1][201];
    public int counter=0;

    public LeetCode414(int array[]){
        this.array=array;
        for(int row[]:memeory)
            Arrays.fill(row,-1);
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

    private void setInMemory(int row,int column,int value){
        memeory[row][column]=value;
    }

    private int getFromMemory(int row,int column){
        return memeory[row][column];
    }
    public static boolean canPartition(int[] nums) {
            int sum=0;
            for(int value:nums)
                sum+=value;
            if(sum%2!=0)
                return false;
            LeetCode414 code=new LeetCode414(nums);
            int start=0;
            return code.subsetSumRecursively(sum/2,start);
    }

   static void test1(){
       Objects.equals(false,canPartition(new int[]{1,2,3,5}));
       Objects.equals(true,new int[]{1,5,11,5});
    }
    public static void main(String[] args) {
        test1();
    }

}
