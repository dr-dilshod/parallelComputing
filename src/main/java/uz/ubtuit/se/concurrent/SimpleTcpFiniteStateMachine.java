package uz.ubtuit.se.concurrent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This is Finite State Machine Software for TCP communication
 * @author Dilshod
 */
public class SimpleTcpFiniteStateMachine {
 	public String traverseTcpStates(Collection<String> actions) {
            Map<String, String> states = new HashMap<String, String>();
            String state = "ERROR";
            states.put("APP_PASSIVE_OPEN", "LISTEN");
            states.put("APP_ACTIVE_OPEN", "SYN_SENT");
            states.put("RCV_SYN", "SYN_RCVD");
            states.put("APP_SEND", "SYN_SENT");
            states.put("APP_CLOSE", "CLOSED");
            states.put("APP_CLOSE", "FIN_WAIT_1");
            states.put("RCV_ACK", "ESTABLISHED");
            states.put("RCV_SYN", "SYN_RCVD");
            states.put("RCV_SYN_ACK", "ESTABLISHED");
            states.put("APP_CLOSE", "CLOSED");
            states.put("APP_CLOSE", "FIN_WAIT_1");
            states.put("RCV_FIN", "CLOSE_WAIT");
            states.put("RCV_FIN", "CLOSING");
            states.put("RCV_FIN_ACK", "TIME_WAIT");
            states.put("RCV_ACK", "FIN_WAIT_2");
            states.put("RCV_ACK", "TIME_WAIT");
            states.put("RCV_FIN", "TIME_WAIT");
            states.put("APP_TIMEOUT", "CLOSED");
            states.put("APP_CLOSE", "LAST_ACK");
            states.put("RCV_ACK", "CLOSED");
            for (String action : actions) {
                if (states.containsKey(action)) {
                    state = states.get(action);
                }
            }
            return state;
        }
    }
