import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter 
{
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the text area
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create the "Count Words" button
        JButton countButton = new JButton("Count Words");
        buttonPanel.add(countButton);

        // Create the "Clear" button
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);

        // Add button panel to the SOUTH position
        frame.add(buttonPanel, BorderLayout.SOUTH);
          
        // Create the label to display word count
        JLabel wordCountLabel = new JLabel("Word Count: 0");
        frame.add(wordCountLabel, BorderLayout.NORTH);

        
        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });
        
        // adding actionListener for button "clear"
       clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area
                wordCountLabel.setText("Word Count: 0"); // Reset word count label
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    // Method to count words
    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}