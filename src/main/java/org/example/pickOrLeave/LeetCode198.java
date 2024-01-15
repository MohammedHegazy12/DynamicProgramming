package org.example.pickOrLeave;

import org.example.pickOrLeave.easyProplems.LeetCode1691;

import java.util.Arrays;

public class LeetCode198 {

    private int array[];
    private int[] memory=new int[401];


    public int rob(int[] nums) {
        this.array=nums;
        Arrays.fill(memory,-1);
        int start=0;
    return    lis(start);
    }
    private int  lis(int index){
            if(index>=array.length)
                return 0;
            int result=memory[index];
                if(result!=-1)
                    return result;

            int choice1=lis(index+1);

           int  choice2=array[index]+lis(index+2);
           result= Math.max(choice1,choice2);
           memory[index]=result;
           return result;
    }

    public static void main(String[] args) {
        int array[]={2,7,9,3,1};
        LeetCode198 sol=new LeetCode198();
        System.out.println(sol.rob(array));
    }


}
