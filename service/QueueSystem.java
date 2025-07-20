package service;
import java.util.LinkedList;
import java.util.Queue;

public class QueueSystem {

    private LaundryRequest request;
    //code the FIFO queue and priority queue here
    public QueueSystem(LaundryRequest request) {
        this.request = request;
    }

    public void enqueue(){
        Queue<String> queue = new LinkedList<>();
        queue.add(request.getCustomerName());
        System.out.println("Queue: " + queue);

    }
}
