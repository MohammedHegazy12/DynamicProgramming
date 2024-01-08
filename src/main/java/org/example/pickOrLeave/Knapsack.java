package org.example.pickOrLeave;

import java.util.Arrays;

public class Knapsack {
    private int weights[]={10, 4 , 20, 5, 7  };
    private int values[]={10, 15, 3 , 1, 4 } ;
    private int memory[][]=new int[13][20 ];

    public Knapsack(){
        fillMemoryWithNegativeOnes();
    }
    void fillMemoryWithNegativeOnes(){
        for (int[]array:memory){
             Arrays.fill(array,-1);
        }
    }

    int counter=0;
    public int knapsackWithOutRecursion(int remain,int current){
                if(current>= weights.length)
                        return 0;
                counter++;

                int leaveIt=knapsackWithOutRecursion(remain,current+1);

                int pickIt=0;
                if(remain>=weights[current])
                    pickIt=values[current]+knapsackWithOutRecursion(remain- weights[current],current+1);
              return Math.max(pickIt,leaveIt);
    }
    private void setFromMemory(int remain, int current, int value){
           memory[remain][current]=value;
    }
    private int getFromMemory(int remain,int current){
        return memory[remain][current];
    }
    public int knapsackUsingDP(int remain,int index){
                    if(index >=weights.length)
                        return 0;
                    counter++;
                    int result=getFromMemory(remain,index);

                    if(result!=-1)
                            return result;

                    int leaveIt=knapsackUsingDP(remain, index +1);

                    int pictIt=0;

                    if(remain>=weights[index])
                        pictIt=values[index]+knapsackUsingDP(remain-weights[index], index+=1);

                    result=Math.max(pictIt,leaveIt);
                    setFromMemory(remain,index,result);
                    return result;

    }

    public static void main(String[] args) {
        Knapsack knapsack=new Knapsack();

        System.out.println(knapsack.knapsackWithOutRecursion(12,0));
     //   System.out.println(knapsack.knapsackUsingDP(12,0));
        System.out.println(knapsack.counter);

    }
}
