import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class LaundrySystem extends JFrame {
    private JTextField customerNameField;
    private JComboBox<String> washTempCombo;
    private JTextArea fifoResultArea;
    private JTextArea priorityResultArea;
    private JLabel fifoStepsLabel;
    private JLabel priorityStepsLabel;
    private JLabel fifoTimeLabel;
    private JLabel priorityTimeLabel;
    private JButton upgradeButton;
    private JComboBox<String> upgradeCustomerCombo;
    
    // Declare utk queue
    private Queue<LaundryOrder> fifoQueue;
    private Queue<LaundryOrder> priorityQueue; // Upgrade from fifoqueue
    private List<LaundryOrder> inputOrders;
    
    // Statistics
    private int fifoSteps = 0;
    private int prioritySteps = 0;
    
    public LaundrySystem() {
        initializeComponents();
        setupLayout();
        initializeDataStructures();
    }
    
    //UI utk setiap components
    private void initializeComponents() {
        setTitle("Laundry System: FIFO vs Priority Queue Comparison");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        
        // Input components
        customerNameField = new JTextField(15);
        washTempCombo = new JComboBox<>(new String[]{"COLD", "MEDIUM", "HOT"});
        
        // Upgrade components
        upgradeCustomerCombo = new JComboBox<>();
        upgradeButton = new JButton("Upgrade to Priority (RM6)");
        upgradeButton.addActionListener(e -> upgradeCustomer());
        
        // Result areas
        fifoResultArea = new JTextArea(15, 35);
        fifoResultArea.setEditable(false);
        fifoResultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        priorityResultArea = new JTextArea(15, 35);
        priorityResultArea.setEditable(false);
        priorityResultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        // Nak tgk comparison
        fifoStepsLabel = new JLabel("Steps: 0");
        priorityStepsLabel = new JLabel("Steps: 0");
        fifoTimeLabel = new JLabel("Processing Time: 0ms");
        priorityTimeLabel = new JLabel("Processing Time: 0ms");
    }
    
    //UI utk setiap section
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Input Panel
        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);
        
        // Results Panel
        JPanel resultsPanel = createResultsPanel();
        add(resultsPanel, BorderLayout.CENTER);
        
        // Control Panel
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    //UI utk panel input
    private JPanel createInputPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Order input panel
        JPanel orderPanel = new JPanel(new GridBagLayout());
        orderPanel.setBorder(new TitledBorder("Add Laundry Order"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        orderPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(customerNameField, gbc);
        
        gbc.gridx = 2; gbc.gridy = 0;
        orderPanel.add(new JLabel("Wash Temperature:"), gbc);
        gbc.gridx = 3;
        orderPanel.add(washTempCombo, gbc);
        
        JButton addButton = new JButton("Add Order (RM4)");
        addButton.addActionListener(e -> addOrder());
        gbc.gridx = 4;
        orderPanel.add(addButton, gbc);
        
        // Upgrade panel
        JPanel upgradePanel = new JPanel(new FlowLayout());
        upgradePanel.setBorder(new TitledBorder("Upgrade FIFO to Priority Queue"));
        upgradePanel.add(new JLabel("Select Customer:"));
        upgradePanel.add(upgradeCustomerCombo);
        upgradePanel.add(upgradeButton);
        upgradePanel.add(new JLabel("(Extra RM2 charge)"));
        
        mainPanel.add(orderPanel, BorderLayout.CENTER);
        mainPanel.add(upgradePanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    //UI utk side by side comparison
    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        
        // FIFO Panel
        JPanel fifoPanel = new JPanel(new BorderLayout());
        fifoPanel.setBorder(new TitledBorder("FIFO Queue Results (Regular Service - RM4)"));
        fifoPanel.add(new JScrollPane(fifoResultArea), BorderLayout.CENTER);
        
        JPanel fifoStatsPanel = new JPanel(new FlowLayout());
        fifoStatsPanel.add(fifoStepsLabel);
        fifoStatsPanel.add(Box.createHorizontalStrut(20));
        fifoStatsPanel.add(fifoTimeLabel);
        fifoPanel.add(fifoStatsPanel, BorderLayout.SOUTH);
        
        // Priority Panel
        JPanel priorityPanel = new JPanel(new BorderLayout());
        priorityPanel.setBorder(new TitledBorder("Priority Queue Results (Premium Service - RM6)"));
        priorityPanel.add(new JScrollPane(priorityResultArea), BorderLayout.CENTER);
        
        JPanel priorityStatsPanel = new JPanel(new FlowLayout());
        priorityStatsPanel.add(priorityStepsLabel);
        priorityStatsPanel.add(Box.createHorizontalStrut(20));
        priorityStatsPanel.add(priorityTimeLabel);
        priorityPanel.add(priorityStatsPanel, BorderLayout.SOUTH);
        
        panel.add(fifoPanel);
        panel.add(priorityPanel);
        
        return panel;
    }
    
    //UI utk button bwh
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        
        JButton processButton = new JButton("Process All Orders");
        processButton.addActionListener(e -> processAllOrders());
        
        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> clearAll());
        
        panel.add(processButton);
        panel.add(clearButton);
        
        return panel;
    }
    
    //Algorithm gune LinkedList
    private void initializeDataStructures() {
        fifoQueue = new LinkedList<>();
        priorityQueue = new LinkedList<>(); 
        inputOrders = new ArrayList<>();
        fifoSteps = 0;
        prioritySteps = 0;
        upgradeCustomerCombo.removeAllItems();
        
        // Preload 4 users for demonstration
        preloadUsers();
    }
    
    //Nak buat 4 users dulu dlm queue
    private void preloadUsers() {
        String[][] preloadData = {
            {"Alice", "COLD"},
            {"Bob", "HOT"},
            {"Charlie", "MEDIUM"},
            {"Diana", "COLD"}
        };
        
        for (String[] data : preloadData) {
            LaundryOrder order = new LaundryOrder(data[0], data[1], "RM4");
            inputOrders.add(order);
            fifoQueue.offer(order);
            upgradeCustomerCombo.addItem(data[0]);
        }
        
        updateDisplay();
    }
    
    //Logic code bile tekan button add order
    private void addOrder() {
        String customerName = customerNameField.getText().trim();
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name!");
            return;
        }
        
        String washTemp = (String) washTempCombo.getSelectedItem();
        
        LaundryOrder order = new LaundryOrder(customerName, washTemp, "RM4");
        inputOrders.add(order);
        
        // Add to FIFO queue (all orders start in FIFO)
        fifoQueue.offer(order);
        
        // Add to upgrade dropdown
        upgradeCustomerCombo.addItem(customerName);
        
        customerNameField.setText("");
        
        updateDisplay();
        JOptionPane.showMessageDialog(this, "Order added successfully! Payment: RM4");
    }
    
    //Logic code utk customer nak upgrade priority
    private void upgradeCustomer() {
        String selectedCustomer = (String) upgradeCustomerCombo.getSelectedItem();
        if (selectedCustomer == null) {
            JOptionPane.showMessageDialog(this, "No customer selected!");
            return;
        }
        
        // Find and upgrade the customer
        LaundryOrder orderToUpgrade = null;
        for (LaundryOrder order : inputOrders) {
            if (order.getCustomerName().equals(selectedCustomer) && !order.isUpgraded()) {
                orderToUpgrade = order;
                break;
            }
        }
        
        if (orderToUpgrade != null) {
            orderToUpgrade.upgrade();
            priorityQueue.offer(orderToUpgrade);
            
            // Remove from FIFO queue
            fifoQueue.remove(orderToUpgrade);
            
            // Remove from upgrade dropdown
            upgradeCustomerCombo.removeItem(selectedCustomer);
            
            updateDisplay();
            JOptionPane.showMessageDialog(this, 
                selectedCustomer + " upgraded to Priority Queue!\nTotal Payment: RM6 (RM4 + RM2 upgrade fee)");
        } else {
            JOptionPane.showMessageDialog(this, "Customer not found or already upgraded!");
        }
    }
    
    //Logic code utk button process all orders
    private void processAllOrders() {
        if (inputOrders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No orders to process!");
            return;
        }
        
        // Process FIFO (simulate slower processing)
        long startTime = System.currentTimeMillis();
        StringBuilder fifoResult = processFIFO();
        long fifoTime = System.currentTimeMillis() - startTime;
        
        // Process Priority Queue (simulate faster processing)
        startTime = System.currentTimeMillis();
        StringBuilder priorityResult = processPriorityQueue();
        long priorityTime = System.currentTimeMillis() - startTime;
        
        // Update displays
        fifoResultArea.setText(fifoResult.toString());
        priorityResultArea.setText(priorityResult.toString());
        
        fifoStepsLabel.setText("Steps: " + fifoSteps);
        priorityStepsLabel.setText("Steps: " + prioritySteps);
        fifoTimeLabel.setText("Processing Time: " + fifoTime + "ms");
        priorityTimeLabel.setText("Processing Time: " + priorityTime + "ms");
        
        // Show comparison
        showComparisonDialog(fifoTime, priorityTime);
    }
    
    //Logic code utk fifo queue
    private StringBuilder processFIFO() {
        StringBuilder result = new StringBuilder();
        result.append("FIFO QUEUE PROCESSING (Regular Service)\n");
        result.append("======================================\n\n");
        result.append("Processing Order: First In, First Out\n");
        result.append("Standard processing speed\n\n");
        
        fifoSteps = 0;
        int orderNumber = 1;
        
        Queue<LaundryOrder> tempQueue = new LinkedList<>();
        for (LaundryOrder order : inputOrders) {
            if (!order.isUpgraded()) {
                tempQueue.offer(order);
            }
        }
        
        while (!tempQueue.isEmpty()) {
            LaundryOrder order = tempQueue.poll();
            fifoSteps++;
            
            // Simulate slower processing
            try {
                Thread.sleep(50); // 50ms delay per step
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            result.append(String.format("Step %d:\n", fifoSteps));
            result.append(String.format("  Customer: %s\n", order.getCustomerName()));
            result.append(String.format("  Wash Temp: %s\n", order.getWashTemp()));
            result.append(String.format("  Queue Position: %d\n", orderNumber++));
            result.append(String.format("  Payment: %s\n", order.getPayment()));
            result.append(String.format("  Processing Time: %d minutes\n\n", 
                getProcessingTime(order.getWashTemp(), false)));
        }
        
        result.append("FIFO Processing Complete!\n");
        result.append(String.format("Total Orders Processed: %d\n", fifoSteps));
        
        return result;
    }
    
    //Logic code utk priority queue
    private StringBuilder processPriorityQueue() {
        StringBuilder result = new StringBuilder();
        result.append("PRIORITY QUEUE PROCESSING (Premium Service)\n");
        result.append("===========================================\n\n");
        result.append("Processing Order: Upgraded customers first\n");
        result.append("Faster processing with premium equipment\n\n");
        
        prioritySteps = 0;
        
        // Process only upgraded orders in the order they were upgraded
        List<LaundryOrder> upgradedOrders = new ArrayList<>();
        for (LaundryOrder order : inputOrders) {
            if (order.isUpgraded()) {
                upgradedOrders.add(order);
            }
        }
        
        for (LaundryOrder order : upgradedOrders) {
            prioritySteps++;
            
            // Simulate faster processing
            try {
                Thread.sleep(30); // 30ms delay per step (faster than FIFO)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            result.append(String.format("Step %d:\n", prioritySteps));
            result.append(String.format("  Customer: %s\n", order.getCustomerName()));
            result.append(String.format("  Wash Temp: %s\n", order.getWashTemp()));
            result.append(String.format("  Payment: %s (Upgraded)\n", order.getPayment()));
            result.append(String.format("  Processing Time: %d minutes\n\n", 
                getProcessingTime(order.getWashTemp(), true)));
        }
        
        result.append("Priority Queue Processing Complete!\n");
        result.append(String.format("Total Orders Processed: %d\n", prioritySteps));
        
        return result;
    }
    
    private int getProcessingTime(String washTemp, boolean isPriority) {
        int baseTime = 30; // Same processing time for all wash temperatures
        
        // Priority queue has faster processing (premium equipment)
        return isPriority ? (int)(baseTime * 0.8) : baseTime;
    }
    
    private void showComparisonDialog(long fifoTime, long priorityTime) {
        String message = String.format(
            "Processing Comparison:\n\n" +
            "FIFO Queue (Regular):\n" +
            "- Orders processed: %d\n" +
            "- Processing time: %d ms\n" +
            "- Average time per order: %.1f ms\n\n" +
            "Priority Queue (Premium):\n" +
            "- Orders processed: %d\n" +
            "- Processing time: %d ms\n" +
            "- Average time per order: %.1f ms\n\n",
            fifoSteps, fifoTime, 
            fifoSteps > 0 ? (double)fifoTime / fifoSteps : 0,
            prioritySteps, priorityTime,
            prioritySteps > 0 ? (double)priorityTime / prioritySteps : 0,
            priorityTime > 0 ? (double)fifoTime / priorityTime : 1.0
        );
        
        JOptionPane.showMessageDialog(this, message, "Performance Comparison", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void updateDisplay() {
        StringBuilder display = new StringBuilder();
        display.append("Current Orders Status:\n");
        display.append("======================\n\n");
        
        display.append("FIFO Queue (Regular - RM4):\n");
        int fifoCount = 0;
        for (LaundryOrder order : inputOrders) {
            if (!order.isUpgraded()) {
                fifoCount++;
                display.append(String.format("  %d. %s - %s\n", 
                    fifoCount, order.getCustomerName(), order.getWashTemp()));
            }
        }
        
        display.append("\nPriority Queue (Premium - RM6):\n");
        int priorityCount = 0;
        for (LaundryOrder order : inputOrders) {
            if (order.isUpgraded()) {
                priorityCount++;
                display.append(String.format("  %d. %s - %s [UPGRADED]\n", 
                    priorityCount, order.getCustomerName(), order.getWashTemp()));
            }
        }
        
        display.append(String.format("\nTotal Orders: %d (FIFO: %d, Priority: %d)", 
            inputOrders.size(), fifoCount, priorityCount));
        
        fifoResultArea.setText(display.toString());
        priorityResultArea.setText(display.toString());
    }
    
    private void clearAll() {
        fifoQueue.clear();
        priorityQueue.clear();
        inputOrders.clear();
        upgradeCustomerCombo.removeAllItems();
        fifoSteps = 0;
        prioritySteps = 0;
        
        // Clear displays first
        fifoResultArea.setText("");
        priorityResultArea.setText("");
        fifoStepsLabel.setText("Steps: 0");
        priorityStepsLabel.setText("Steps: 0");
        fifoTimeLabel.setText("Processing Time: 0ms");
        priorityTimeLabel.setText("Processing Time: 0ms");
        customerNameField.setText("");
        
        // Always reload the 4 preloaded users after clearing
        preloadUsers();
    }
    
    // LaundryOrder class
    private static class LaundryOrder {
        private String customerName;
        private String washTemp;
        // private long timestamp;
        private String payment;
        private boolean upgraded;
        
        public LaundryOrder(String customerName, String washTemp, String payment) {
            this.customerName = customerName;
            this.washTemp = washTemp;
            this.payment = payment;
            // this.timestamp = System.currentTimeMillis();
            this.upgraded = false;
        }
        
        public void upgrade() {
            this.upgraded = true;
            this.payment = "RM6";
        }
        
        public String getCustomerName() { return customerName; }
        public String getWashTemp() { return washTemp; }
        // public long getTimestamp() { return timestamp; }
        public String getPayment() { return payment; }
        public boolean isUpgraded() { return upgraded; }
        
        @Override
        public String toString() {
            return String.format("%s - %s - %s", 
                customerName, washTemp, payment);
        }
    }
    
    public static void main(String[] args) {
            new LaundrySystem().setVisible(true);
    }
}