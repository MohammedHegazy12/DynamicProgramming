package org.example.pickOrLeave.easyProplems;

import java.util.Arrays;
import java.util.Comparator;

 import static java.lang.Math.max;

public class LeetCode1691 {
    private final int MAX=101;
    private int array[][];
    private int memory[][]=new int[MAX][MAX];
    public int maxHeight(int[][] cuboids) {
                this.array=cuboids;
                for(int row[]:array)
                    Arrays.sort(row);
                Arrays.sort(array,Comparator.comparingInt(row->Arrays.stream((int[]) row).sum()).reversed()) ;
                initialzieMemory();
                for(int row[]:array)
                    System.out.println(Arrays.toString(row));
        int start=0;
        int prev=array.length;
        return Lis(prev,start);
    }
    private boolean lessEqual(int prev,int index){
        return  array[prev][0]>=array[index][0]&& array[prev][2]>=array[index][2]&&array[prev][1]>=array[index][1];
    }
    public int Lis(int prev,int index){
            if(index==array.length )
                    return 0;

            int result=getFromMemory(prev,index);
            if(result!=-1)
                return result;
            int leaveIt=Lis(prev,index+1);

            int pickIt=0;

            if( prev==array.length|| lessEqual(prev,index))
                pickIt = array[index][2] + Lis(index, index + 1);

            result=max(leaveIt,pickIt);
            setInMemory(prev,index,result);
            return result;
    }
    private void initialzieMemory(){
        for(int row[]:memory)
              Arrays.fill(row,-1);
    }

    private int getFromMemory(int prev,int index){
        return memory[prev][index];
    }
    private void setInMemory(int prev,int index,int value){
        memory[prev][index]=value;
    }
    public static void main(String[] args) {
        //[50,45,20],[95,37,53],[45,23,12
        int array[][]={{50,45,20},{95,37,53},{45,23,12} };
           // int array[][]={{1,7,20},{2, 6, 20}};
            LeetCode1691 soluation=new LeetCode1691();
        System.out.println(soluation.maxHeight(array));

}}
