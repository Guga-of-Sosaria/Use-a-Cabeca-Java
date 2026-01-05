import java.util.ArrayList;
import java.util.Scanner;

public class SimpleStartupGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfGuesses = 0;
        Startup startup = new Startup();
        //Inicializa o tabuleiro do jogo
        int randomNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<String>();
        //Loop que converte os ints gerados em strings e os adciona a lista "locations"
        for(int i = 0; i < 3; i++) {
            locations.add((String) (String.valueOf(randomNum + i)));
        }
        boolean isAlive = true;
        startup.setLocationCells(locations);

        //Loop principal do jogo
        while(isAlive) {
            System.out.println("Type a number: ");
            String guess = sc.nextLine();
            String result = startup.checkYourself(guess);
            numOfGuesses++;
            if(result.equals("kill!")) {
                System.out.printf("You took %d guesses!\n", numOfGuesses);
                isAlive = false;
            }
        }

        sc.close();
    }
}
