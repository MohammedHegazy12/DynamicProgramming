package org.example.editDistance;

import java.util.Arrays;

import static java.lang.Math.min;

public class EditDistence {
   private StringBuilder str1;
   private StringBuilder str2;
    private static final  int MAX=101;
   int memmory[][]=new int[MAX][MAX];

    public EditDistence(StringBuilder str1,StringBuilder str2){
        this.str2=str2;
        this.str1=str1;
    }

    int editDistence(int index1,int index2){
            if(index1>=str1.length())
                    return str2.length()-index1;
            if(index2>=str2.length())
                    return str1.length()-index2;
            int result=getFromMemory(index1,index2);
            if(result!=-1)
                return result;

            if(str1.charAt(index1)==str2.charAt(index2)){
                 result=editDistence(index1+1,index2+1);
                setInMemory(index1,index2,result);
                return result;
            }
            int insert=1+editDistence(index1+1,index2);
            int delete=1+editDistence(index1+1,index2+1)  ;
            int change=1+editDistence(index1,index2+1);
           result= min(min(insert,delete),change);
           setInMemory(index1,index2,result);
           return result;
    }

    int editDistence(StringBuilder str1,StringBuilder str2 ){
         this.str2=str2;
         this.str1=str1;
        for(int row[]:memmory)
            Arrays.fill(row,-1);
        return editDistence(0,0);
    }

    private void setInMemory(int index1,int index2,int value){
        this.memmory[index1][index2]=value;
    }

    private int getFromMemory(int index1,int index2){
        return memmory[index1][index2];
    }
}
