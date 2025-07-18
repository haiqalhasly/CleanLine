import javax.swing.SwingUtilities;

import UI.homePage;

public class main {
    //run the program here
    public static void main(String[] args) {

                //Ensures GUI swings created and updated
        SwingUtilities.invokeLater(() -> new homePage());
        //Implements lambda expression () is the parameter. -> lambda operator ->  and new Login() is a method
        //Makes the codes cleaner

        
    }
}
