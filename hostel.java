import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Singleton class for the GUI
class Hostel extends JFrame {
    private static Hostel instance = null;

    // Private constructor to prevent instantiation from outside
    private Hostel() {
        setTitle("Hostel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 3, 5, 5)); // 3 rows, 2 columns, with gaps of 5 pixels

        JLabel question1Label = new JLabel("Hostel?");
        JRadioButton yesRadio = new JRadioButton("Yes");
        JRadioButton noRadio = new JRadioButton("No");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(yesRadio);
        group1.add(noRadio);

        JLabel question2Label = new JLabel("Type of room?");
        JRadioButton room2BedRadio = new JRadioButton("2 bed room");
        JRadioButton room3BedRadio = new JRadioButton("3 bed room");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(room2BedRadio);
        group2.add(room3BedRadio);

        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder message = new StringBuilder();
                if (yesRadio.isSelected()) {
                    message.append("Hostel: Yes\n");
                    if (room2BedRadio.isSelected()) {
                        message.append("Type of room: 2 bed room");
                    } else if (room3BedRadio.isSelected()) {
                        message.append("Type of room: 3 bed room");
                    }
                } else if (noRadio.isSelected()) {
                    message.append("Hostel: No");
                }
                JOptionPane.showMessageDialog(Hostel.getInstance(), message.toString());
            }
        });

        panel.add(question1Label);
        panel.add(yesRadio);
        panel.add(noRadio);
        panel.add(question2Label);
        panel.add(room2BedRadio);
        panel.add(room3BedRadio);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(okButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Adjusts the frame size to fit all components
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Static method to get the instance of the class
    public static Hostel getInstance() {
        if (instance == null) {
            instance = new Hostel();
        }
        return instance;
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        // Get the instance of GUI
        Hostel.getInstance();
    }
}
