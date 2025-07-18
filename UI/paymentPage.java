package UI;

import javax.swing.*;
import java.awt.*;

public class paymentPage {

    
}

class paymentPageFrame extends JFrame {


    public paymentPageFrame() {

        // Basic Login Layout
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
        JButton loginButton = new JButton("PAY");
        add(loginButton);

        setVisible(true);
    }
}
