package UI;
import javax.swing.*;
import java.awt.*;

public class LaundryQueueUI extends JFrame {
    public LaundryQueueUI() {
        setTitle("Laundry Queue Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        // Main layout
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Laundry Queue", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Queue container (vertical list)
        JPanel queueContainer = new JPanel();
        queueContainer.setLayout(new BoxLayout(queueContainer, BoxLayout.Y_AXIS));
        queueContainer.setBackground(Color.WHITE);

        // Scrollable panel
        JScrollPane scrollPane = new JScrollPane(queueContainer);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // Dummy cards (just for UI display)
        for (int i = 1; i <= 5; i++) {
            JPanel card = new JPanel(new BorderLayout());
            card.setPreferredSize(new Dimension(350, 60));
            card.setMaximumSize(new Dimension(350, 60));
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            card.setBackground(i == 1 ? new Color(255, 204, 204) : new Color(230, 230, 230)); // priority = pink

            JLabel label = new JLabel((i == 1 ? "[PRIORITY] " : "") + "Customer " + i );
            label.setHorizontalAlignment(SwingConstants.CENTER);
            card.add(label, BorderLayout.CENTER);

            queueContainer.add(Box.createVerticalStrut(10)); // spacing
            queueContainer.add(card);
        }

    }
}
