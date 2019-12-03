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
public class basicThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("This is " + threadName);
        };
        task.run();
        
        Thread thread = new Thread(task);
        thread.start();
        
        System.out.println("Done!");
    }
}
