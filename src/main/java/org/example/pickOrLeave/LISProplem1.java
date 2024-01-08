package org.example.pickOrLeave;

import java.util.Arrays;

public class LISProplem1 {
    int array[];
    int memeory[][]=new int[1001][1001];
    int counter=0;
    public LISProplem1(int array[] ){
          this.array=array;
          for(int row[]:memeory)
              Arrays.fill(row,-1);
    }

    private void setInMemory(int previous,int current,int result){
          memeory[previous][current]=result;
    }
    private int getFromMemory(int previous,int current  ){
          return memeory[previous][current];
    }

    public int lisUsingRecursion(int previous, int current){
           if(current>=array.length)
                return 0;
           counter++;
           int leaveIt= lisUsingRecursion(previous,current+1);
           int pickIt=0;
           if(previous<array.length&&array[previous]<=array[current])
                pickIt=1+ lisUsingRecursion(current,current+1);
           return Math.max(pickIt,leaveIt);
    }

    public int lisUsingDP(int previous,int current){
           if(current>=array.length)
                return 0;
           counter++;
           int result=getFromMemory(previous,current);
           if(result!=-1)
               return result;

           int leaveIt=lisUsingDP(previous,current+1);
           int pickIt=0;
           if(array[previous]<=array[current])
                pickIt=1+lisUsingDP(current,current+1);

           result=Math.max(pickIt,leaveIt);
           setInMemory(previous,current,result);
           return result;

    }

    public static void main(String[] args) {
        int array[]={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LISProplem1  lis=new LISProplem1(array);
        int previous=0;
        int current=0;
       int value= lis.lisUsingDP( previous,current);
        System.out.println(value);
//        System.out.println(lis.lisUsingRecursion(0,0));
         System.out.println(lis.counter);
    }
}
