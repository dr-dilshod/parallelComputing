package uz.ubtuit.se.parallelcomputing;
/**
 * @author dilshod
 */
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static int res1;
    public static int res2;
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());
        System.out.println("Creating Executor Service with a thread pool of Size 3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Problem problem = new Problem();
        int[] list = problem.getList();
        Sequential seq = new Sequential();
        int midpoint = list.length / 2;
        int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
        int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
            res1 = seq.sum(l1);
            System.out.println("res1 = " + res1);
        };
        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            res2 = seq.sum(l2);
            System.out.println("res2 = " + res2);
        };
        Runnable task3 = () -> {
            System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
        };
        System.out.println("Submitting the tasks for execution...");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.shutdown();
        
    }
}

