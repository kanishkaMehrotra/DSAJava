package Hard;

import java.io.*;
import java.util.*;

public class MaxStackMain {
  public static class MaxStack {
      
      Stack<Integer> s;
      Stack <Integer> ms;

    public MaxStack() {
    s =new Stack <Integer> ();
    ms =new Stack <Integer> ();
    }

    public void push(int x) {
        s.push(x);
        if(!ms.isEmpty())
        {
            ms.push(Math.max(x,ms.peek()));
        }
        ms.push(x);
    }

    public int pop() {
        ms.pop();
        return s.pop();
           }

    public int top() {
      return s.peek();
    }

    public int peekMax() {
      return ms.peek();
    }

    public int popMax() {
        int n =ms.peek();
        Stack <Integer> tmp =new Stack<Integer>();
        while(s.peek()!=n)
        {
            tmp.push(pop());
        }
        pop();
        
        while(tmp.isEmpty())
        {
            push(tmp.pop());
        }
        
      return n;
    }

  }

  public static void main(String[] args) throws Exception {
	  System.out.println("add input");
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();
System.out.println(read.ready());
    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}

