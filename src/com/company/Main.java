package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //Pg 898 Self Check Problems
        /*
        1. C is true
        2. A real world example of a stack is the word undo and redo feature. Real world example of a queue is any line for anything
        3. When you push to a stack, that element is on top and when you pop the item it is the first one off
        4. When you add a queue, you are adding the element to the back. When you remove, you remove the front most element
        5. 3 is returned
        6. 1 is returned
        7. You need to initiate a queue as a linkedlist like this : Queue<Integer> q = new LinkedList<Integer>();
        8. Stack<String> stack = new Stack<String>();
           stack.push("hello");
           stack.push("hi");
           stack.push("goodbye");
           stack.push("howdy");

        9. Stack<Integer> stack = new Stack<Integer>();
            for (int i = 100; i >= 0; i -= 2) {
            stack.push(i);
            }

        10. Queue<String> q = new LinkedList<String>();
            q.add("alpha");
            q.add("beta");
            q.add("gamma");
            q.add("delta");
        11. To access the middle elements, you have to remove or pop until you reach them. You should save the other elements you removed so you can use them again
        12. Stacks and queues are very functional because they are simple and because their operations are efficient
        13. Output: [you, are, how]
        14. Output:
            10
            7
            5
            false
            3
            8
            3
        15. Output:
            2
            10
            10
            4
            6
            6
            3
        16. Output:
            a. [1, 1, 6, 6, 2, 2]
            b. [9, 9, 15, 15, 4, 4, -3, -3, 42, 42]
            c. [40, 40, 50, 50, 60, 60, 10, 10, 20, 20, 30, 30]
         */
        //Pg 902
        //Problem 1
        Stack<Integer> stack1 = new Stack <Integer>();
        stack1.add(3);
        stack1.add(-5);
        stack1.add(2);
        stack1.add(1);
        stack1.add(-4);
        System.out.println(splitStack(stack1));
        //Problem 2
        System.out.println(stutter(stack1));
        //Problem 3
        stack1.add(1);
        stack1.add(2);
        stack1.add(3);
        stack1.add(4);
        stack1.add(5);
        System.out.println(copyStack(stack1));
        //Problem 4
        stack1.add(1);
        stack1.add(2);
        stack1.add(3);
        stack1.add(4);
        stack1.add(5);
        System.out.println(collapse(stack1));

        //Pg 903
        //Problem 8
        Queue<Integer> queue1 = new LinkedList<Integer>();
        queue1.add(8);
        queue1.add(13);
        queue1.add(12);
        queue1.add(12);
        queue1.add(13);
        queue1.add(8);
        System.out.println(isPali(queue1));
        //Problem 10
        Stack<Integer> stack2 = new Stack <Integer>();
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.add(4);
        stack2.add(5);
        System.out.println(isCon(stack2));
        //Problem 15
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.add(4);
        stack2.add(5);
        System.out.println(isSorted(stack2));

        //Project #1 Primes Program
        //Received some help from connor in class. Also the book way of doing this project was strange and didn't exactly make sense or really work
        Queue<Integer> qProject = new LinkedList<Integer>();
        int n = 100;
        for(int i = 2; i < n; i++){
            qProject.add(i);
        }
        primes(qProject);
    }

    //Project #1
    public static void primes(Queue <Integer> q){
        Queue<Integer> temp = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();
        while(!q.isEmpty()){
            int p = q.remove();
            while(!q.isEmpty()){
                int next = q.remove();
                if(next % p != 0){
                    temp.add(next);
                }

            }
            result.add(p);
            while(!temp.isEmpty()){
                q.add(temp.remove());
            }

        }
        System.out.println(result.toString());

    }

        //Problem 15
    public static boolean isSorted(Stack <Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean test = true;
        while(!s.isEmpty()){
            int x = s.pop();
            q.add(x);
        }
        int x = q.remove();
        while(!q.isEmpty()){
            int y = q.remove();
                if(y > x){
                    test = false;
            }
            s.push(x);
            s.push(y);
            x = y;
        }
        s = reverse(s);
        return test;
    }

        //Problem 10
        public static boolean isCon(Stack <Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean test = true;
            while(!s.isEmpty()){
                int x = s.pop();
                q.add(x);
            }
            while(!q.isEmpty()){
                int x = q.remove();
                if(q.size() != 0){
                    int y = q.remove();
                    if(y + 1 != x){
                        test = false;
                    }
                    s.push(x);
                    s.push(y);
                }else{
                    s.push(x);
                }
            }
        s = reverse(s);
            return test;
    }

        //Problem 8
        public static boolean isPali(Queue <Integer> q){
        Stack<Integer> s = new Stack <Integer>();
        boolean test = true;
        int size = q.size();
        for(int i = 0; i < size; i++){
            int x = q.remove();
            q.add(x);
            s.push(x);
        }
        while(!s.isEmpty()){
            int x = s.pop();
            int y = q.remove();
            if(x != y){
                test = false;
            }
            q.add(y);
        }
        return test;
    }

    //Problem 4
    public static Stack <Integer> collapse(Stack <Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        while(!s.isEmpty()){
            int x = s.pop();
            q.add(x);
        }
        while(!q.isEmpty()){
            int x = q.remove();
            int y = 0;
            if(q.size() != 0){
                y = q.remove();
            }
            int sum = x + y;
            s.add(sum);
        }
        s = reverse(s);
        return s;
    }

        //Problem 3
        public static Stack <Integer> copyStack(Stack <Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        Stack <Integer> s2 = new Stack <Integer>();
        while (!s.isEmpty()){
            int x = s.pop();
            q.add(x);
        }
        while(!q.isEmpty()){
            int x = q.remove();
            s.add(x);
            s2.add(x);
        }
        s = reverse(s);
        s2 = reverse(s2);
        return s2;
    }
            //Method to reverse order easier
        private static Stack<Integer> reverse (Stack <Integer> st){
            Stack <Integer> temp = new Stack <Integer>();
            while(!st.isEmpty()){
                int x = st.pop();
                temp.add(x);
            }
            return temp;
    }

        //Problem 2
        public static Stack <Integer> stutter(Stack <Integer> s){
            Queue<Integer> temp = new LinkedList<Integer>();
            while(!s.isEmpty()){
            int x = s.pop();
            temp.add(x);
            }
            while(!temp.isEmpty()){
            int x = temp.remove();
            s.add(x);
            s.add(x);
            }
            s = reverse(s);
            return s;
    }

        //Problem 1
        public static Stack <Integer> splitStack(Stack <Integer> s){
        Queue<Integer> neg = new LinkedList<Integer>();
        Queue<Integer> nonNeg = new LinkedList<Integer>();
        while(!s.isEmpty()){
            int x = s.peek();
                if(x < 0){
                    x = s.pop();
                    neg.add(x);
                }else{
                    int y = s.pop();
                    nonNeg.add(y);
                }
        }
        while (!neg.isEmpty()){
            int x = neg.remove();
            s.push(x);
        }
        while (!nonNeg.isEmpty()){
            int y = nonNeg.remove();
            s.push(y);
        }
        return s;

    }

}
