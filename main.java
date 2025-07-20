import javax.swing.SwingUtilities;

import UI.*;
import service.*;

public class main {
    //run the program here
    public static void main(String[] args) {

        //Creates a new request everytime the program is run
        //Creates a new queue system also
        //Passes the request to the queue system
        //Calls the enqueue function
        
        LaundryRequest Request = new LaundryRequest("","");
        QueueSystem queueSystem = new QueueSystem(Request);
        queueSystem.enqueue();

        //Ensures GUI swings created and updated
        // Implements lambda expression () is the parameter. -> lambda operator -> and
        // new Login() is a method
        // Makes the codes cleaner

        SwingUtilities.invokeLater(() -> new homePageFrame(Request));

        
    }
}
