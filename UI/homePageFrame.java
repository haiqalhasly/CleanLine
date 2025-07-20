package UI;
import javax.swing.*;
import java.awt.*;
import service.*;

// This class is used to display the home page
// This will be the first page that the user will see
// Just enter their name and temperature
public class homePageFrame extends JFrame {

    // Create ID field variable
    private JTextField customerNameField;
    private JComboBox<String> temperatureDropdown;

    public homePageFrame(LaundryRequest request) {

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

        //Just want to make some space between the button and dropdown 
        add(new JLabel("                                                                                     "));
        JButton proceedButton = new JButton("Proceed");
        add(proceedButton);

        // Add action listener to go to login function
        // Using lambda expression
        proceedButton.addActionListener(e -> {
            String customerName = customerNameField.getText();
            request.setCustomerName(customerName);
            String temp = temperatureDropdown.getSelectedItem().toString();
            request.setTemperature(temp);
            toPaymentPage(request);
        });

        setVisible(true);
    }
    
    //After clicking proceed button, go to payment page
    //still used LaundryRequest parameter to pass around customer info


protected void toPaymentPage(LaundryRequest request) {
    new paymentPageFrame(request);
    
    setVisible(false);

}

}