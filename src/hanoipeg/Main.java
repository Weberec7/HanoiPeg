/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoipeg;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ethan.weber
 */
public class Main {

    
    public static void main(String[] args) {
        int user = 10;
        Scanner input = new Scanner(System.in);
        while(user > 0){
        System.out.println("Welcome to the Towers of Hanoi - Please type an integer value for the initial tower height\n - Type -1 to quit the program\n - Note: Integers > 15 may take awhile to execute.\n");
        user = input.nextInt();
        if(user <0){System.exit(0);}
        initPegs(user);
        }
    }

    
    private static void initPegs(int x){
        HanoiPeg H1 = new HanoiPeg("H1",1);
        HanoiPeg H2 = new HanoiPeg("H2",2);
        HanoiPeg H3 = new HanoiPeg("H3",3);
        for(int i = x; i>0; i--){
            H1.push(i);
        }
        PrinthanoiPegs(H1,H2,H3);
        move_n(x,H1,H2,H3);
        
    }
    
    private static void PrinthanoiPegs(HanoiPeg a, HanoiPeg b, HanoiPeg c) {
        Stack aux = new Stack();
        int x;
        HanoiPeg H1,H2,H3;
        H1=a;
        H2=b;
        H3=c;
        if(a.name.equals("H1")) {
            H1 = a;
        }
        else if(a.name.equals("H2")) {
            H2 = a;
        }
        else {
            H3 = a;
        }
        if(b.name.equals("H1")) {
            H1 = b;
        }
        else if(b.name.equals("H2")) {
            H2 = b;
        }
        else {
            H3 = b;
        }
        if(c.name.equals("H1")) {
            H1 = c;
        }
        else if(c.name.equals("H2")) {
            H2 = c;
        }
        else {
            H3 = c;
        }

        System.out.print(H1.name+ ":");
        while(!H1.isEmpty()){
            aux.push(H1.pop());
        }
        while(!aux.isEmpty()){
            x = (Integer)aux.pop();
            System.out.print(" " + x);
            H1.push(x);
        }
        System.out.print("\n"+H2.name+ ":");
        while(!H2.isEmpty()){
            aux.push(H2.pop());
        }
        while(!aux.isEmpty()){
            x = (Integer)aux.pop();
            System.out.print(" " + x);
            H2.push(x);
        }
        System.out.print("\n"+H3.name+ ":");
        while(!H3.isEmpty()){
           aux.push(H3.pop());
        }
        while(!aux.isEmpty()){
            x = (Integer)aux.pop();
            System.out.print(" " + x);
            H3.push(x);
        }
        H1.iteration++;
        System.out.println("\n***************************** Iteration: "+H1.iteration);
    }



    private static class HanoiPeg extends Stack{
        private String name;
        //private int order;
        private int iteration=0;
        public HanoiPeg(String n, int o) {
            <Integer>super();
            name = n;
            //order = o;
        }

        @Override
        public Object push(Object item){
            
            if(!super.isEmpty()){
            int x = (Integer)super.peek();
            int y = (Integer)item;
            if(x>y) {
                    return super.push(item);
                }
            else {
                    return item;
                }
            }
 else {
                return super.push(item);
            }
        }



    }

private static void move_n(int n, HanoiPeg src, HanoiPeg dest, HanoiPeg aux)
    {
    if(n>0){
    move_n(n-1, src, aux, dest);
    move_one(src, dest);
    PrinthanoiPegs(src,dest,aux);
    move_n(n-1, aux, dest, src);
        }
}

 private static void move_one(HanoiPeg src, HanoiPeg dest) {
     dest.push(src.pop());

    }

}
