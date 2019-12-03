package uz.ubtuit.se.concurrent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import uz.ubtuit.se.concurrent.SimpleTcpFiniteStateMachine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
/**
 *
 * @author dilshod
 */
public class testTest {
    
    public testTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCases() {
        // Is stateless, so fine to reuse for tests
        SimpleTcpFiniteStateMachine cut = new SimpleTcpFiniteStateMachine();
        assertEquals(cut.traverseTcpStates(Arrays.asList("APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK")), "ESTABLISHED");
        assertEquals(cut.traverseTcpStates(Arrays.asList("APP_ACTIVE_OPEN")), "SYN_SENT");
        assertEquals(cut.traverseTcpStates(Arrays.asList("APP_ACTIVE_OPEN", "RCV_SYN_ACK", "APP_CLOSE", "RCV_FIN_ACK", "RCV_ACK")), "ERROR");
    }
}
