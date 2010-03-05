import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizPanel extends JPanel {

    public QuizPanel() {
        setLayout(new GridLayout(2, 1));

        //Top half
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));

        //Choose a type
        JPanel typePanel = new JPanel();
        typePanel.setBorder(
            BorderFactory.createTitledBorder(
                "Choose a type"
            )
        );

        ButtonGroup group = new ButtonGroup();
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        for (QuizType type : QuizType.values()) {
            JRadioButton button = new JRadioButton(type.name());
            group.add(button);
            radioPanel.add(button);
            button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        typeChanged(
                            QuizType.valueOf(e.getActionCommand())
                        );
                    }
                }
            );
        }
        typePanel.add(radioPanel);

        //Choose a level
        JPanel levelPanel = new JPanel();
        levelPanel.setBorder(
            BorderFactory.createTitledBorder(
                "Choose a level"
            )
        );

        group = new ButtonGroup();
        radioPanel = new JPanel(new GridLayout(0, 1));
        for (QuizLevel level : QuizLevel.values()) {
            JRadioButton button = new JRadioButton(level.description());
            button.setActionCommand(level.name());
            group.add(button);
            radioPanel.add(button);
            button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        levelChanged(
                            QuizLevel.valueOf(e.getActionCommand())
                        );
                    }
                }
            );
        }
        levelPanel.add(radioPanel);

        topPanel.add(typePanel);
        topPanel.add(levelPanel);

        //Bottom half
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        
        //Question + Answer
        JPanel qaPanel = new JPanel();
        qaPanel.setLayout(new GridLayout(1, 2));

        //Question panel
        JPanel qPanel = new JPanel();
        JLabel questionLabel = new JLabel("Question will be shown");
        qPanel.add(questionLabel);
        qPanel.setBorder(
            BorderFactory.createTitledBorder(
                "Question"
            )
        );

        //Answer panel
        JPanel aPanel = new JPanel();
        aPanel.setLayout(
            new GridLayout(2, 0)
        );
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JTextField inputField = new JTextField();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        aPanel.add(inputField);
        aPanel.add(buttonPanel);

        aPanel.setBorder(
            BorderFactory.createTitledBorder(
                "Answer"
            )
        );

        qaPanel.add(qPanel);
        qaPanel.add(aPanel);

        //Correct Count + Time Spent
        JPanel countSpentPanel = new JPanel();
        countSpentPanel.setLayout(new GridLayout(1, 2));
        JLabel countLabel = new JLabel("Correct count will be shown");
        countLabel.setBorder(
            BorderFactory.createTitledBorder(
                "Correct Count"
            )
        );
        countSpentPanel.add(countLabel);
        JLabel spentLabel = new JLabel("Time spent will be shown");
        spentLabel.setBorder(
            BorderFactory.createTitledBorder(
                "Time Spent"
            )
        );
        countSpentPanel.add(spentLabel);

        bottomPanel.add(
            qaPanel,
            BorderLayout.CENTER
        );
        bottomPanel.add(
            countSpentPanel,
            BorderLayout.SOUTH
        );

        //Add to main panel
        add(topPanel);
        add(bottomPanel);
    }

    private void typeChanged(QuizType type) {
        System.out.println(type);
    }
    private void levelChanged(QuizLevel level) {
        System.out.println(level);
    }
}
