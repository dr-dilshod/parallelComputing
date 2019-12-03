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
import jsr166y.forkjoin.ForkJoinExecutor;
import jsr166y.forkjoin.ForkJoinPool;
import uz.ubtuit.se.parallelcomputing.Problem;
import uz.ubtuit.se.parallelcomputing.Solver;

public class ForkJoin {

    public static void main(String[] args) {
        Problem test = new Problem();
        // check the number of available processors
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        Solver mfj1 = new Solver(test.getList());
        Solver mfj2 = new Solver(test.getList());
        ForkJoinExecutor pool = new ForkJoinPool(nThreads);
        pool.invoke(mfj1);
        pool.invoke(mfj2);
        long result1 = mfj1.result;
        long result2 = mfj2.result;
        System.out.println("Done. Result: " + result1 + result2);
    }
}