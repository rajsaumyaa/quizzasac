import screens.CreateQuestionScreenGui;
import screens.TitleScreenGui;

import javax.swing.*;

public class App {
    public static void main(String [] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new TitleScreenGui().setVisible(true);

                new CreateQuestionScreenGui().setVisible(true);
            }
        });
    }
}
