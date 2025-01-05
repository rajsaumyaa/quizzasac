import database.Category;
import screens.CreateQuestionScreenGui;
import screens.TitleScreenGui;
import screens.QuizScreenGui;

import javax.swing.*;

public class App {
    public static void main(String [] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TitleScreenGui().setVisible(true);





            }
        });
    }
}
