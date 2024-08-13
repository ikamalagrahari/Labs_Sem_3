import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E15_Swing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    // Create a JPanel to hold components
    JPanel panel = new JPanel();
    frame.add(panel);

    // Buttons
    JButton button = new JButton("Click Me");
    panel.add(button);

    // Labels
    JLabel label = new JLabel("This is a Label");
    panel.add(label);

    // Checkboxes
    JCheckBox checkBox = new JCheckBox("Checkbox");
    panel.add(checkBox);

    // Radio Buttons
    JRadioButton radioButton1 = new JRadioButton("Option 1");
    JRadioButton radioButton2 = new JRadioButton("Option 2");
    ButtonGroup radioGroup = new ButtonGroup();
    radioGroup.add(radioButton1);
    radioGroup.add(radioButton2);
    panel.add(radioButton1);
    panel.add(radioButton2);

    // Scroll Pane
    JTextArea textArea = new JTextArea(10, 30);
    JScrollPane scrollPane = new JScrollPane(textArea);
    panel.add(scrollPane);

    // List
    String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };
    JList<String> list = new JList<>(items);
    panel.add(list);

    // Combo Box
    String[] options = { "Option A", "Option B", "Option C" };
    JComboBox<String> comboBox = new JComboBox<>(options);
    panel.add(comboBox);

    // Menu
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu fileMenu = new JMenu("File");
    JMenuItem openMenuItem = new JMenuItem("Open");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    fileMenu.add(openMenuItem);
    fileMenu.add(exitMenuItem);
    menuBar.add(fileMenu);

    // Toolbar
    JToolBar toolbar = new JToolBar();
    JButton toolbarButton = new JButton("Toolbar Button");
    toolbar.add(toolbarButton);
    frame.add(toolbar, BorderLayout.NORTH);

    // Button click event
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Button Clicked");
      }
    });

    frame.setVisible(true);
  }
}
