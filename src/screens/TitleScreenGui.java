package screens;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TitleScreenGui extends JFrame {
    private JComboBox categoriesMenu;
    private JTextField numOfQuestionsTextField;

    public TitleScreenGui(){
        super ("Title Screen");

        setSize(400,565);

        setLayout(null);

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(CommonConstants.LIGHT_BLUE);

        addGuiComponents();

    }
    private void addGuiComponents(){

        JLabel titleLabel = new JLabel("QUIZ GAME!");
        titleLabel.setFont(new Font("Arial",Font.BOLD,36));
        titleLabel.setBounds(0,20,390,43);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(titleLabel);

        JLabel chooseCategoryLabel = new JLabel("Choose a Category");
        chooseCategoryLabel.setFont(new Font("Arial",Font.BOLD,16));
        chooseCategoryLabel.setBounds(0,90,400,20);
        chooseCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chooseCategoryLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(chooseCategoryLabel);


        String[] categories = new String[] {"Math", "Programming","History"};


        JComboBox categoriesMenu = new JComboBox(categories);
        categoriesMenu.setBounds(20,120,337,45);
        categoriesMenu.setForeground(CommonConstants.DARK_BLUE);
        add(categoriesMenu);

        JLabel numOfQuestionsLabel =  new JLabel("Number of Questions");
        numOfQuestionsLabel.setFont(new Font("Arial",Font.BOLD,16));
        numOfQuestionsLabel.setBounds(20,190,172,20);
        numOfQuestionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numOfQuestionsLabel.setForeground(CommonConstants.BRIGHT_YELLOW);
        add(numOfQuestionsLabel);

        numOfQuestionsTextField = new JTextField("10");
        numOfQuestionsTextField.setFont(new Font("Arial",Font.BOLD,16));
        numOfQuestionsTextField.setBounds(200,190,148,26);
        numOfQuestionsTextField.setForeground(CommonConstants.DARK_BLUE);
        add(numOfQuestionsTextField);


        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial",Font.BOLD,16));
        startButton.setBounds(65,290,262,45);
        startButton.setBackground(CommonConstants.BRIGHT_YELLOW);
        startButton.setForeground(CommonConstants.LIGHT_BLUE);
        add(startButton);


        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial",Font.BOLD,16));
        exitButton.setBounds(65,350,262,45);
        exitButton.setBackground(CommonConstants.BRIGHT_YELLOW);
        exitButton.setForeground(CommonConstants.LIGHT_BLUE);
        add(exitButton);

        JButton createAQuestionButton = new JButton("Create a Question");
        createAQuestionButton.setFont(new Font("Arial",Font.BOLD,16));
        createAQuestionButton.setBounds(65,420,262,45);
        createAQuestionButton.setBackground(CommonConstants.BRIGHT_YELLOW);
        createAQuestionButton.setForeground(CommonConstants.LIGHT_BLUE);
        add(createAQuestionButton);
    }
}
