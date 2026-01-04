import java.util.Scanner;

public class SimpleStartupGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfGuesses = 0;
        //Inicializa o "tabuleiro" do jogo
        SimpleStartup theStartup = new SimpleStartup();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        boolean isAlive = true;
        theStartup.setLocationCells(locations);
        
        //Loop principal do jogo
        while(isAlive) {
            //Pega o palpite do jogador
            System.out.println("Type an number: ");
            int guess = sc.nextInt();
            sc.nextLine();
            //Verifica se o jogador acertou algo
            String result = theStartup.checkYourself(guess);
            //Aumenta o número de tentativas usadas
            numOfGuesses ++;
            //Verifica se o jogador acertou todas a partes do barco e finaliza o jogo se esse for o caso
            if(result.equals("kill!")) {
                isAlive = false;
                System.out.printf("You took %d guesses!\n", numOfGuesses);
            }
        }
        sc.close();
    }
}
