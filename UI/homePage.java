package UI;

import javax.swing.*;
import java.awt.*;

public class homePage {
    homePageFrame homePageFrame = new homePageFrame();
}

class homePageFrame extends JFrame {
    // Create ID field variable
    private JTextField customerNameField;
    private JComboBox<String> temperatureDropdown;
    private JComboBox<String> PriorityType;

    public homePageFrame() {

        // Basic Login Layout
        super("Home Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // customer Name field input
        add(new JLabel("Enter your name:"));
        customerNameField = new JTextField(10);
        add(customerNameField);

        // Temperature dropdown
        add(new JLabel("Choose temperature"));
        String[] choices = { "COLD", "MEDIUM", "HOT" };
        temperatureDropdown = new JComboBox<>(choices);
        add(temperatureDropdown);

        // Priority Type
        add(new JLabel("Choose priority"));
        String[] priority = { "FIFO", "Queue" };
        PriorityType = new JComboBox<>(priority);
        add(PriorityType);

        //Just want to make some space between the button and dropdown 
        add(new JLabel("                                                                                     "));
        JButton proceedButton = new JButton("Proceed");
        add(proceedButton);

        // Add action listener to go to login function
        // Using lambda expression
        proceedButton.addActionListener(e -> toPaymentPage());

        setVisible(true);
    }
    


protected void toPaymentPage() {
    new paymentPageFrame();
    setVisible(false);

}

}