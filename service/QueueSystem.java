package service;
import java.util.LinkedList;
import java.util.Queue;

//This is the queue system
//This will be used to pass the request to the queue
//This will be the core of the queue system
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
        int size = queue.size();
        System.out.println("Size: " + size);

    }
}
