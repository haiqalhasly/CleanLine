package UI;
import javax.swing.*;
import java.awt.*;

public class thanksPage extends JFrame {

    public thanksPage() {
        // Basic Login Layout
        super("Home Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // customer Name field input
        add(new JLabel("THANK YOU!!"));

        setVisible(true);

        JButton exitButton = new JButton("EXIT");
        add(exitButton);

        exitButton.addActionListener(e -> System.exit(0));


    }
   
    
}
