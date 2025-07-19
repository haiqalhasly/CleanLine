package UI;

import javax.swing.*;
import java.awt.*;

public class upgradePaymentPage {

}

class upgradePaymentPageFrame extends JFrame {

    public upgradePaymentPageFrame() {

        // Basic Layout
        super("Payment Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // customer Name field input
        add(new JLabel("Total Payment: "));

        add(new JLabel("RM 4"));

        // Just want to make some space between the button and dropdown
        add(new JLabel("                                                                                     "));
        JButton payButton = new JButton("PAY");
        add(payButton);

        // Add action listener to go to login function
        // Using lambda expression
        payButton.addActionListener(e -> toQueueingPage());

        setVisible(true);
    }

    protected void toQueueingPage() {
        new PriorityQueue();
        setVisible(false);

    }
}
