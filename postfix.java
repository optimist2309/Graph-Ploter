//package pars;


import java.util.*;
public class postfix {
    public static int top=-1;
    public static char s2[]=new char[100];
    public static char s3[]=new char[100];
    static int count=0;
    public char[] post(char s1[]){
        int i;
        
        //char s1[]=s.toCharArray();

        for(i=0;i<s1.length;i++)
        {
            if(s1[i]=='+') {
                p(s1[i]);
            }
            else if(s1[i]=='-')
            { p(s1[i]);}
            else if(s1[i]=='*')
            {p(s1[i]);}
            else if(s1[i]=='/')
            {p(s1[i]);}
            else if(s1[i]=='(')
                p(s1[i]);
            else if(s1[i]==')')
                    p(s1[i]);
            else if(s1[i]=='_')
                p(s1[i]);
            else if(s1[i]=='^')
                p(s1[i]);
            else
            {
                System.out.print(s1[i]);
                s3[count]=s1[i];
                count++;
            }
        }

        while(top!=-1)
        {
            if(s2[top]!='(')
            System.out.print(s2[top]);
            s3[count]=s2[top];
            top--;
            count++;
        }
        s3[count]='?';
        return s3;

//A * (B + C * D) + E


    }
    public static int precedence(char a)
    {
        if(a=='+')
            return 1;
        if(a=='-')
            return 1;
        if(a=='*')
            return 2;
        if(a=='/')
            return 2;
        if(a=='_')
            return 3;
        if(a=='(')
            return 5;
        if(a=='^')
            return 4;

        return 0;


    }
    public static void p(char a)
    {
        if(top==-1)
            push(a);
        else if(a==')')
        {
            while(s2[top]!='(')
            {

                System.out.print(s2[top]);
                s3[count]=s2[top];
                top--;
                count++;
            }
            top--;
        }
     else if(precedence(a)>precedence(s2[top]))
         push(a);
        else if(s2[top]=='(')
            push(a);
        else
     {
         System.out.print(s2[top]);
         s3[count]=s2[top];
         top--;
         count++;
         push(a);
     }

    }
    public static void push(char a)
    {
        top=top+1;
        s2[top]=a;

    }
}
