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


        //Basic Login Layout
        super("Home Page");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        //customer Name field input

        add(new JLabel("Enter your name:"));
        customerNameField = new JTextField(10);
        add(customerNameField);

        // Temperature dropdown 

        String[] choices = { "COLD", "MEDIUM", "HOT"};
        temperatureDropdown = new JComboBox<>(choices);
        add(temperatureDropdown);

        //Priority Type

        String[] priority = { "FIFO", "Queue" };
        PriorityType = new JComboBox<>(priority);
        add(PriorityType);


        JButton loginButton = new JButton("Proceed");
        add(loginButton);

        setVisible(true);
    }
}
