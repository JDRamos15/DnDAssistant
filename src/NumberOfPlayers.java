import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberOfPlayers implements ActionListener {
    private static JTextField questionInput;
    JLabel welcome;
    JLabel question;

    public static JTextField getQuestionInput() {
        return questionInput;
    }

    public void setQuestionInput(JTextField questionInput) {
        this.questionInput = questionInput;
    }

    public NumberOfPlayers() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        welcome = new JLabel("WELCOME TO THE XP BAR!");
        welcome.setBounds(30, 50, 500, 100);
        welcome.setFont(new Font("Verdana", Font.PLAIN, 30));
        panel.add(welcome);

        question = new JLabel("How many players are going to play? (Up to 6) ");
        question.setBounds(100, 125, 500, 25);
        panel.add(question);

        questionInput = new JTextField();
        questionInput.setBounds(380, 125, 25, 25);
        panel.add(questionInput);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Experience bars");
        frame.pack();
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new NumberOfPlayers();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int numberOfPlayers = Integer.parseInt(questionInput.getText());

    }
}
