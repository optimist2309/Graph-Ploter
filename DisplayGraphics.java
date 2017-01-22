//package pars;



import java.awt.*;
import javax.swing.JFrame;
import java.math.*;
import java.util.*;
import java.util.regex.Pattern;

public class DisplayGraphics extends Canvas{
    public static int array1[]=new int[200000];
    public static String stack[]=new String[10];
    public static double array[]=new double[200000];
    public static int top=-1;
    public static  int scale=20;
    public static String fun;

    public void paint(Graphics g) {
        int a=0;
        setBackground(Color.black);
       g.setColor(Color.red);
        g.drawLine(0,350,900,350); // x-axis
        g.drawLine(450,0,450,900); // y-axis
        for(int i=-450/scale;i<=450/scale+1;i++) // visual scaling
        {
            for(int j=-3;j<=3;j++)
            {
                g.drawLine(450+scale*i,350+j,450+scale*i,350+j);
                g.drawLine(450+j,350+scale*i,450+j,350+scale*i);
            }
        }
        setBackground(Color.black);

       // setForeground(Color.green);


        g.setColor(Color.green);
        for(double x=-450;x<=450;x=x+0.05)
        {

            int Y = array1[a];
            int X = (int)x;
            a++;
            g.drawLine(450+X,350-Y,450+X,350-Y);
        }
        g.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        g.setColor(Color.white);
        g.drawString("f(x)= "+fun, 12,25);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the scale factor");
        scale=sc.nextInt();
    	parser p =new parser();
		postfix pf=new postfix();
		//pf.post(p.parse());
        graph(pf.post(p.parse()));
        fun=p.fun;
        DisplayGraphics m=new DisplayGraphics();
        JFrame f=new JFrame();
        f.add(m);
        f.setSize(900,700);
        //f.setLayout(null);
        f.setVisible(true);
    }
    public static void p(char a,double j)
    {
        double b=0,c=0,d=0;
        String hyphen=null;
        System.out.println();
        if(Pattern.matches("[+-]?([0-9]*[.])?[0-9]+", stack[top])==true)
            b= Double.parseDouble(stack[top]);
        else
        {
            System.out.println();
            if(stack[top].equals("a")==true)
                b=Math.sin(j);
            if(stack[top].equals("b")==true)
                b=Math.cos(j);
            if(stack[top].equals("c")==true)
                b=Math.tan(j);
            if(stack[top].equals("l")==true)
                b=Math.log(j);
            if(stack[top].equals("x")==true)
                b=j;
        }
        top--;
        if(Pattern.matches("[+-]?([0-9]*[.])?[0-9]+", stack[top])==true)
            c=Double.parseDouble(stack[top]);
        else
        {
            hyphen=stack[top];
            if(stack[top].equals("a")==true)
                c=Math.sin(j);
            if(stack[top].equals("b")==true)
                c=Math.cos(j);
            if(stack[top].equals("c")==true)
                c=Math.tan(j);
            if(stack[top].equals("l")==true)
                c=Math.log(j);
            if(stack[top].equals("x")==true)
                c=j;

        }
        top--;
        //System.out.println(b);
        //System.out.println(c);

        if(a=='+')
        {
            d=b+c;
            top++;
            //stack[top]=Integer.toString(d);
            stack[top]=Double.toString(d);
            // System.out.println("d"+d);

        }
        else if(a=='-')
        {
            d=c-b;
            top++;
            stack[top]=Double.toString(d);
        }

        else if(a=='*')
        {
            d=b*c;
            top++;
            // stack[top]=Character.forDigit(d,10);
            //stack[top]=Integer.toString(d);
            stack[top]=Double.toString(d);
        }

        else if(a=='/')
        {
            d=c/b;
            top++;
            // stack[top]=Character.forDigit(d,10);
            //stack[top]=Integer.toString(d);
            stack[top]=Double.toString(d);
        }
        else if(a=='^')
        {
            d=Math.pow(c,b);
            top++;
            // stack[top]=Character.forDigit(d,10);
            //stack[top]=Integer.toString(d);
            stack[top]=Double.toString(d);
        }
        else if(a=='_')
        {

            System.out.println("in hyphen"+b);
            if(hyphen.equals("a")==true) {
                d =Math.sin(b);
                System.out.println("d"+d);
            }
            if(hyphen.equals("b")==true)
                d=Math.cos(b);
            if(hyphen.equals("c")==true)
                d=Math.tan(b);

            top++;
            // stack[top]=Character.forDigit(d,10);
            //stack[top]=Integer.toString(d);
            stack[top]=Double.toString(d);

        }


    }


    public static void graph(char s1[])
    {
        int a=0;
        //Scanner sc =new Scanner(System.in);
        //String s=sc.nextLine();
        //char[] s1=s.toCharArray();
        
        for(double j=-450;j<450;j=j+0.05) {
            for (int i = 0; s1[i]!='?'; i++) {
                if (s1[i] == '+' || s1[i] == '-' || s1[i] == '*' || s1[i] == '/'|| s1[i] == '_'|| s1[i] == '^')
                    p(s1[i],j/scale);
                else {
                    top++;
                    //stack[top]=Character.getNumericValue(s1[i]);
                    stack[top] = Character.toString(s1[i]);
                }

            }
            System.out.println(stack[0]);
            array[a] =scale*Double.parseDouble(stack[0]);
            array1[a]=(int)array[a];
            //g.drawLine(450+xx,350-yy,450+xx,350-yy);
            a++;
            top=-1;
        }



    }

}