package UI;

import javax.swing.*;

import service.LaundryRequest;

import java.awt.*;

//This class is used to display the payment page
//This will be the second page that the user will see
//Just for the flow

public class paymentPageFrame extends JFrame {

    public paymentPageFrame(LaundryRequest request) {

        // Basic Layout
        super("Payment Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Name: " + request.getCustomerName()));
        System.out.println(request.getCustomerName());
        add(new JLabel("Temperature: " + request.getTemperature()));

        // customer Name field input
        add(new JLabel("Total Payment: "));

        add(new JLabel("RM 4"));

        // Just want to make some space between the button and dropdown
        add(new JLabel("                                                                                     "));
        JButton payButton = new JButton("PAY");
        add(payButton);

        // Add action listener to go to login function
        // Using lambda expression
        payButton.addActionListener(e -> toQueueingPage(request));

        setVisible(true);
    }

    //This method is used to go to the queueing page
    //Still passing LaundryRequest parameter

    protected void toQueueingPage(LaundryRequest request) {
        new LaundryQueueUI(request);
        setVisible(false);

    }
}
