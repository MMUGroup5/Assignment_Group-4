import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Singleton class for the GUI
class Activity extends JFrame {
    private static Activity instance = null;

    // Private constructor to prevent instantiation from outside
    private Activity() {
        setTitle("Student Activity (Mandatory Fees)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5)); // 3 rows, 1 column, with gaps of 5 pixels

        JLabel itNetworkFeeLabel = new JLabel("IT/Network fee");
        JLabel libraryFeeLabel = new JLabel("Library fee");
        JLabel clubSocietyFeeLabel = new JLabel("Club and Society fee");

        panel.add(itNetworkFeeLabel);
        panel.add(libraryFeeLabel);
        panel.add(clubSocietyFeeLabel);

        JLabel totalLabel = new JLabel("Total for all: RM160 until graduation");
        panel.add(totalLabel);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Activity.getInstance(), "OK Button Clicked!");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(okButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Adjusts the frame size to fit all components
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Static method to get the instance of the class
    public static Activity getInstance() {
        if (instance == null) {
            instance = new Activity();
        }
        return instance;
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        // Get the instance of GUI
        Activity.getInstance();
    }
}
