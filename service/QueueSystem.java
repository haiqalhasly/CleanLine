package service;
import java.util.LinkedList;
import java.util.Queue;

public class QueueSystem {
    //code the FIFO queue and priority queue here
    public QueueSystem(LaundryRequest request) {

        Queue<String> queue = new LinkedList<>();
        queue.add(request.getCustomerName());
        System.out.println("Queue: " + queue);
        
    }
    

    }
