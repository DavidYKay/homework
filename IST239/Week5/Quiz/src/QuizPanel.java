import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizPanel extends JPanel implements QuizListener {
    private QuizModel model;

    /** Questions answered correctly */
    private JLabel scoreLabel;
    /** Shows the current question */
    private JLabel questionLabel;
    /** Time spent since start */
    private JLabel timeLabel;

    public QuizPanel(QuizModel model) {
        //Model stuff
        this.model = model;
        model.addListener(this);
        
        //View stuff
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
            JRadioButton button = new JRadioButton(level.getDescription());
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
        questionLabel = new JLabel("Question will be shown");
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
        startButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    QuizPanel.this.model.startQuiz();
                }
            }
        );
        JButton stopButton  = new JButton("Stop");
        stopButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    QuizPanel.this.model.stopQuiz();
                }
            }
        );

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
        JPanel scoreTimePanel = new JPanel();
        scoreTimePanel.setLayout(new GridLayout(1, 2));
        scoreLabel = new JLabel("Correct count will be shown");
        scoreLabel.setBorder(
            BorderFactory.createTitledBorder(
                "Correct Count"
            )
        );
        scoreTimePanel.add(scoreLabel);
        timeLabel = new JLabel("Time spent will be shown");
        timeLabel.setBorder(
            BorderFactory.createTitledBorder(
                "Time Spent"
            )
        );
        scoreTimePanel.add(timeLabel);

        bottomPanel.add(
            qaPanel,
            BorderLayout.CENTER
        );
        bottomPanel.add(
            scoreTimePanel,
            BorderLayout.SOUTH
        );

        //Add to main panel
        add(topPanel);
        add(bottomPanel);
    }

    private void typeChanged(QuizType type) {
        System.out.println(type);
        model.setType(type);
    }
    private void levelChanged(QuizLevel level) {
        System.out.println(level);
        model.setLevel(level);
    }

    private void updateView() {
        //Update score
        scoreLabel.setText(
            String.valueOf(model.getScore())
            //"1"
        );
        //Update time
        timeLabel.setText(
            String.valueOf(model.getTimeElapsed())
            //"1"
        );
        //Update question
        questionLabel.setText(
            model.getProblem().getQuestionString()
            //"1"
        );
    }

    /**
     * On model change
     */
    public void stateChanged(QuizEvent e) {
        updateView();
    }
}
