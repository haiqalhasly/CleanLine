import javax.swing.SwingUtilities;

import UI.*;
import service.*;

public class main {
    //run the program here
    public static void main(String[] args) {

        LaundryRequest Request = new LaundryRequest("","");

        //Ensures GUI swings created and updated
        SwingUtilities.invokeLater(() -> new homePageFrame(Request));
        //Implements lambda expression () is the parameter. -> lambda operator ->  and new Login() is a method
        //Makes the codes cleaner

        
    }
}
