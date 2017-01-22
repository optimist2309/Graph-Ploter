//package pars;

 import java.util.*;
 import java.util.regex.Pattern;

public class parser {
    public String fun;
    public char[] parse() {
        Scanner sc=new Scanner(System.in);
        int length,count=0,j=0;
        String[] keyword={"sinx","cosx","tanx","sin","logx","log","cos","tan"};
        String[] key={"a","b","c","a_","l","l_","b_","c_"};
        System.out.println("enter the funcion");
         fun=sc.nextLine();
       String[] array=fun.split("[+-/*()^]");
        //String[] array=fun.split("[^a-z]");
        //String[] array1=fun.split("[a-z]");
        String[] array1=fun.split("[^+-/*()^]");
        // Pattern p=Pattern.compile();
        for(int i=0;i<array.length;i++) {
            if(!(array[i].equals("")))
            count++;
        }
        //System.out.println(array.length);
        for(int i=0;i<array1.length;i++) {
            if(!(array1[i].equals("")))
                count++;

        }
       // System.out.println("check");
        //System.out.println(array1.length);
        String[] done=new String[count];
        for(int i=0;i<array.length;i++)
        {
            if(!(array[i].equals(""))) {
                done[j] = array[i];
                j=j+2;
            }
        }

        j=1;
        for(int i=0;i<array1.length;i++)
        {
            if(!(array1[i].equals(""))) {
                done[j] = array1[i];
                j=j+2;
            }
        }
        for(int i=0;i<done.length;i++)
        {
            for( j=0;j<keyword.length;j++)
            {

                if(done[i].equals(keyword[j]))
                {
                   // System.out.println("check");
                    done[i]=key[j];
                }
            }
        }

        for(int i=0;i<done.length;i++)
        {
           // System.out.print(done[i]);
        }
        String join=String.join("",done);
        //System.out.println();
        System.out.println(join);
        char[] join1=join.toCharArray();
        return join1;
    }

}
