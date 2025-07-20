package UI;

import java.awt.*;
import javax.swing.*;
import service.LaundryRequest;

//This class is used to generate the cards
//It will be used to display the queue
public class generateCard extends JPanel {

    public static void generateCard(LaundryRequest request, JPanel queueContainer) {
            for (int i = 1; i <= 5; i++) {
            JPanel card = new JPanel();
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            card.setBackground(i == 1 ? new Color(255, 204, 204) : new Color(230, 230, 230)); // priority = pink

            JLabel label = new JLabel("Customer " + i + "." + request.getCustomerName());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            card.add(label, BorderLayout.CENTER);

            queueContainer.add(Box.createVerticalStrut(10)); // spacing
            queueContainer.add(card);

        }
    }
    
}
