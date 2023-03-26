import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {

    public static void main(String[] args) {

        int start = 1;
        int end = 100;

        int Attempt = 10;
        int score = 0;

        Random r = new Random();
        int random = r.nextInt(end - start + 1) + start;

        String name = JOptionPane.showInputDialog("Enter your Name below: ");

        JOptionPane.showMessageDialog(null, "Hello!!! Welcome to the Game "+name+".");

        for (int i = start; i <= Attempt; i++){

            String number = JOptionPane.showInputDialog("Guess a number between "+start+" and "+end+".");
            int guess = Integer.parseInt(number);

            if (guess == random){
                JOptionPane.showMessageDialog(null, "Congratulations!!!! You've guessed the right number : "+guess+" in "+i+" attempts.");
                score = Attempt-i + 1;
                break;
            }
            else if (guess < random) {
                JOptionPane.showMessageDialog(null, "Try again!!! Guess a Higher Number. "+(Attempt-i)+" Attempts Left.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Try again!!! Guess a Lower Number. "+(Attempt-i)+" Attempts Left.");
            }

        }

        if(score > 0){
            JOptionPane.showMessageDialog(null, name+" your final score is: "+score+".");
        }
        else{
            JOptionPane.showMessageDialog(null, name+" your final score is: "+score+".");
        }
    }
}
