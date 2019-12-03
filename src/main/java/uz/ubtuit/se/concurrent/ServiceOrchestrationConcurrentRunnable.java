/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.ubtuit.se.concurrent;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import uz.ubtuit.se.parallelcomputing.AplusB;

/**
 * Runnable for concurrent execution of concurrent regions. Instantiates new
 * SDMOrchestrationVisitors which work on the same data structures (by reference)
 * as the original parent visitor.
 * @author Dilshod
 */
public class ServiceOrchestrationConcurrentRunnable implements Runnable {

    public ServiceOrchestrationConcurrentRunnable(ServiceOrchestrationConcurrentRunnable aThis, AplusB region1) {
    }

    
    private final static Logger LOG = Logger.getLogger(ServiceOrchestrationConcurrentRunnable.class.getName());
    
    public void run() {
        AplusB region1 = new AplusB();
        AplusB region2 = new AplusB();
        Runnable runnable1 = new ServiceOrchestrationConcurrentRunnable(this,
                region1);
        Runnable runnable2 = new ServiceOrchestrationConcurrentRunnable(this,
                region2);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        LOG.info("Creating region thread");
        Future f1 = pool.submit(runnable1);
        LOG.info("Creating region thread");
        Future f2 = pool.submit(runnable2);
        synchronized (this)
        {
            while (!f1.isDone() || !f2.isDone())
            {
                try
                {
                    this.wait(1000);
                }
                catch (InterruptedException ex)
                {
                }
            }
        }
    }

}
