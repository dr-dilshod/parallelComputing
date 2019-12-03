/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.ubtuit.se.parallelcomputing;

/**
 *
 * @author dilshod
 */
public class Sequential {

    public int sum(int[] test) {
        int sum = 0;
        for (int i: test) {
            sum += test[i];
        }
        return sum;
    }
}