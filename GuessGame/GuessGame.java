public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        int guessp1;
        int guessp2;
        int guessp3;
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between 0 and 9...");

        while(true) {
            System.out.printf("Number to guess is %d\n", targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.printf("Player 1 guessed %d\n", guessp1);
            
            guessp2 = p2.number;
            System.out.printf("Player 2 guessed %d\n", guessp2);
            
            guessp3 = p3.number;
            System.out.printf("Player 3 guessed %d\n", guessp3);

            if(guessp1 == targetNumber) {
                p1isRight = true;
            }
            if(guessp2 == targetNumber) {
                p2isRight = true;
            }
            if(guessp3 == targetNumber) {
                p3isRight = true;
            }

            if(p1isRight || p2isRight || p3isRight) {
                System.out.println("WE HAVE A WINNER!!!!!");
                System.out.printf("Player 1 got it right? %b\n", p1isRight);
                System.out.printf("Player 2 got it right? %b\n", p2isRight);
                System.out.printf("Player 3 got it right? %b\n", p3isRight);
                System.out.println("The game is over.");
                break;
            } else {
                System.out.println("Players wil have to try again.");
            }
        }
    }
}