import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    JScrollBar redScroller;
    JScrollBar greenScroller;
    JScrollBar blueScroller;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    JPanel selectedColorSquare;
    JLabel selectedColorValue;

    public Main() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Color Picker");

        redLabel = new JLabel("Rot");
        greenLabel = new JLabel("Grün");
        blueLabel = new JLabel("Blau");
        redScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        greenScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        blueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 127, 1, 0, 256);
        selectedColorSquare = new JPanel();
        selectedColorValue = new JLabel("Farbe: 127, 127, 127", JLabel.CENTER);

        redScroller.setBackground(Color.red);
        greenScroller.setBackground(Color.green);
        blueScroller.setBackground(Color.blue);
        selectedColorSquare.setBackground(new Color(127, 127, 127));

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.add(redLabel);
        mainPanel.add(greenLabel);
        mainPanel.add(blueLabel);
        mainPanel.add(redScroller);
        mainPanel.add(greenScroller);
        mainPanel.add(blueScroller);
        mainPanel.add(selectedColorSquare);
        mainPanel.add(selectedColorValue);

        AdjustmentListener al = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Color c = new Color(redScroller.getValue(), greenScroller.getValue(), blueScroller.getValue());
                selectedColorSquare.setBackground(c);
                selectedColorValue.setText("Farbe: " + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue());
            }
        };

        redScroller.addAdjustmentListener(al);
        greenScroller.addAdjustmentListener(al);
        blueScroller.addAdjustmentListener(al);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
