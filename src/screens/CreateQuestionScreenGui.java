package screens;

import constants.CommonConstants;
import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CreateQuestionScreenGui extends JFrame {
    private JTextArea questionTextArea;
    private JTextField categoryTextField;
    private JTextField[] answerTextFields;
    private ButtonGroup buttonGroup;
    private JRadioButton[] answerRadioButtons;

    public CreateQuestionScreenGui(){
        super("Create a Question");
        setSize(851,565);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(CommonConstants.LIGHT_BLUE);

        answerRadioButtons = new JRadioButton[4];
        answerTextFields = new JTextField[4];
        buttonGroup = new ButtonGroup();

        addGuiComponents();

    }

    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("Create your own question");
        titleLabel.setFont(new Font("Arial",Font.BOLD,24));
        titleLabel.setBounds(50,15,310,29);
        titleLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(titleLabel);

        JLabel questionLabel = new JLabel("Question: ");
        questionLabel.setFont(new Font("Arial",Font.BOLD,16));
        questionLabel.setBounds(50,60,93,32);
        questionLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(questionLabel);


        questionTextArea = new JTextArea();
        questionTextArea.setFont(new Font("Arial",Font.BOLD,16));
        questionTextArea.setBounds(50,90,310,110);
        questionTextArea.setForeground(CommonConstants.DARK_BLUE);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        add(questionTextArea);

        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Arial",Font.BOLD,16));
        categoryLabel.setBounds(50,250,93,20);
        categoryLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(categoryLabel);

        categoryTextField = new JTextField();
        categoryTextField.setFont(new Font("Arial",Font.BOLD,16));
        categoryTextField.setBounds(50,280,310,36);
        categoryTextField.setForeground(CommonConstants.DARK_BLUE);
        add(categoryTextField);

        addAnswerComponents();


        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial",Font.BOLD,16));
        submitButton.setBounds(300,450,262,45);
        submitButton.setForeground(CommonConstants.DARK_BLUE);
        submitButton.setBackground(CommonConstants.BRIGHT_YELLOW);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    String question = questionTextArea.getText();
                    String category = categoryTextField.getText();
                    String[] answers = new String[answerTextFields.length];
                    int correctIndex = 0;
                    for (int i = 0; i < answerTextFields.length; i++) {
                        answers[i] = answerTextFields[i].getText();
                        if (answerRadioButtons[i].isSelected()) {
                            correctIndex = i;
                        }
                    }

                    //update database
                    if (JDBC.saveQuestionCategoryAndAnswersToDatabase(question, category,
                            answers, correctIndex)) {

                        //update successful
                        JOptionPane.showMessageDialog(CreateQuestionScreenGui.this,
                                "Successfully Added Question");
                        //reset fields
                        resetFields();
                    } else {
                        JOptionPane.showMessageDialog(CreateQuestionScreenGui.this,
                                "Failed to Add Question...");
                    }
                }else{
                        JOptionPane.showMessageDialog(CreateQuestionScreenGui.this,
                                "Error:Invalid Input");
                    }


            }
        });
        add(submitButton);

        JLabel goBackLabel = new JLabel("Go Back");
        goBackLabel.setFont(new Font("Arial",Font.BOLD,16));
        goBackLabel.setBounds(300,500,262,20);
        goBackLabel.setForeground(CommonConstants.DARK_BLUE);
        goBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        goBackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TitleScreenGui titleScreenGui = new TitleScreenGui();
                titleScreenGui.setLocationRelativeTo(CreateQuestionScreenGui.this);

                CreateQuestionScreenGui.this.dispose();

                titleScreenGui.setVisible(true);
            }
        });
        add(goBackLabel);

    }
    private void addAnswerComponents(){
        int verticalSpacing = 100;
        for (int i=0; i<4; i++){
            JLabel answerLabel = new JLabel("Answer #" + (i+1));
            answerLabel.setFont(new Font("Arial",Font.BOLD,16));
            answerLabel.setBounds(470,60 +(i * verticalSpacing), 93,20);
            answerLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
            add(answerLabel);

            answerRadioButtons[i] = new JRadioButton();
            answerRadioButtons[i].setBounds(440,100 +(i * verticalSpacing), 21,21);
            answerRadioButtons[i].setBackground(null);
            buttonGroup.add(answerRadioButtons[i]);
            add(answerRadioButtons[i]);

            answerTextFields[i] = new JTextField();
            answerTextFields[i].setBounds(470,100 +(i * verticalSpacing), 310,36);
            answerTextFields[i].setFont(new Font("Arial",Font.PLAIN,16));
            answerTextFields[i].setForeground(CommonConstants.DARK_BLUE);
            add(answerTextFields[i]);
        }
        answerRadioButtons[0].setSelected(true);
    }
    private boolean validateInput() {
        // Check if questionTextArea is null or has no text
        if (questionTextArea == null || questionTextArea.getText().trim().isEmpty()) {
            return false;
        }

        // Check if categoryTextField is null or has no text
        if (categoryTextField == null || categoryTextField.getText().trim().isEmpty()) {
            return false;
        }

        // Check if answerTextFields array is null or contains any empty answers
        if (answerTextFields == null) {
            return false;  // Or handle the case where the array is not initialized
        }

        for (int i = 0; i < answerTextFields.length; i++) {
            // Ensure that each text field is not null before calling getText()
            if (answerTextFields[i] == null || answerTextFields[i].getText().trim().isEmpty()) {
                return false;
            }
        }

        // Ensure at least one radio button is selected
        boolean isRadioSelected = false;
        for (int i = 0; i < answerRadioButtons.length; i++) {
            if (answerRadioButtons[i].isSelected()) {
                isRadioSelected = true;
                break;
            }
        }

        if (!isRadioSelected) {
            return false; // No radio button selected
        }

        return true;
    }



    private void resetFields(){
        questionTextArea.setText("");
        categoryTextField.setText("");
        for (int i=0; i<answerTextFields.length; i++){
            answerTextFields[i].setText("");
        }

    }

}
