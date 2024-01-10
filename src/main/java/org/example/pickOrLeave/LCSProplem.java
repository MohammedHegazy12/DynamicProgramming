package org.example.pickOrLeave;

import java.util.Arrays;

public class LCSProplem {
    StringBuilder str1;
    StringBuilder str2;
    int memory[][];

    public LCSProplem(StringBuilder str1,StringBuilder str2){
            this.str1=str1;
            this.str2=str2;
            int size=Math.max(str1.length(),str2.length())+1;
            memory=new int[size][size];
            for(int array[]:memory)
                Arrays.fill(array,-1);
    }
    public void setInMemory(int index1,int index2,int result){
        this.memory[index1][index2]=result;
    }

    public int getFromMemory(int index1,int index2){
        return this.memory[index1][index2];
    }
    public  int lcs(int index1,int index2){
            if(index1>=str1.length()||index2>=str2.length())
                        return 0;
                int result=getFromMemory(index1,index2);
                if(result!=-1)
                    return result;

                if(str1.charAt(index1)==str2.charAt(index2)) {
                    result = 1 + lcs(index1 + 1, index2 + 1);
                    setInMemory(index1,index2,result);
                    return result;
                }
                int choice2=lcs(index1,index2+1);
                int choice3=lcs(index1+1,index2);
                result= Math.max(choice2,choice3);
                setInMemory(index1,index2,result  );

                return result;
    }

    public static void main(String[] args) {
        StringBuilder str1=new StringBuilder("abazdc");
        StringBuilder str2=new StringBuilder("bacbadz");
        LCSProplem lcs=new LCSProplem(str1,str2 );
        System.out.println(lcs.lcs(0,0));
    }
}
