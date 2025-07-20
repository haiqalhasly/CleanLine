package UI;
import javax.swing.*;
import java.awt.*;



public class LaundryQueueUI extends JFrame {



    int i = 0;
    public LaundryQueueUI() {
        setTitle("Laundry Queue Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
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
            card.setPreferredSize(new Dimension(250, 60));
            card.setMaximumSize(new Dimension(250, 60));
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            card.setBackground(i == 1 ? new Color(255, 204, 204) : new Color(230, 230, 230)); // priority = pink

            JLabel label = new JLabel((i == 1 ? "[PRIORITY] " : "") + "Customer " + i );
            label.setHorizontalAlignment(SwingConstants.CENTER);
            card.add(label, BorderLayout.CENTER);

            queueContainer.add(Box.createVerticalStrut(10)); // spacing
            queueContainer.add(card);

        }
        // Bottom panel (progress bar + button)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        

        // Progress bar (static for now)
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(60); // example: 60% done
        progressBar.setStringPainted(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(progressBar);
        bottomPanel.add(Box.createVerticalStrut(10));
        //iterateProgressBar(progressBar);

        
        // Button
        JButton upgradeButton = new JButton("Upgrade to Priority");
        upgradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(upgradeButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to go to login function
        // Using lambda expression
        upgradeButton.addActionListener(e -> toUpgradePaymentPage());
        
    }

        public void iterateProgressBar(JProgressBar progressBar) {

        while (i <= 2000) {
            progressBar.setValue(i);
            i += 20;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
            }
        }

    }

        protected void toUpgradePaymentPage() {
        new upgradePaymentPageFrame();
        setVisible(false);
    }
    
}
