package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        //Project #1 Primes Program

        Queue<Integer> q = new LinkedList<Integer>();
        int n = 100;
        for(int i = 2; i < n; i++){
            q.add(i);
        }
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
}
