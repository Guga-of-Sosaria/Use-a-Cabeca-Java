import java.util.ArrayList;

public  class StartupBust {
    //Declara e inicializa as variáveis nexessárias
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //Cria três objetos Startup, lhes fornece nomes, e os insere no array list startups
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        //Printa instruções breves ao usuário
        System.out.println("LETS'S SINK SOME STARTUPS!!!");
        System.out.println("Your objective is to sink all of those three startups:");
        System.out.println("poniez, hacqi, and cabista");
        System.out.println("Try to sink them all in the fewest number of guesses!");
        
        //Repete isso com cada startup da lista
        for(Startup startup: startups) {
            //Soliciata ao auxiliar um local para a startup
            ArrayList<String> newLocation = helper.placeStartup(3);
            //Chama o método setter nesta Startup para fornecer o local que acabou de ser obtido do auxiliar
            startup.setLocationCells(newLocation);
        } //fecha o loop
    } //fecha o método SetUpGame

    private void startPlaying() {
        //Desde que a lista de Startups NÃO esteja vazia
        while(!startups.isEmpty()) {
            //Obtém a entrada do usuário
            String userGuess = helper.getUserInput("Enter a guess");
            //Chama o nosso método checkUserGuess
            checkUserGuess(userGuess);
        } //fecha o loop while
        //Chama o nosso método finishGame
        finishGame();
    } //fecha o método startPlaying

    private void checkUserGuess(String userGuess) {
        //Incrementa o número de palpites que o usuário fez
        numOfGuesses++;
        //Assume que é um 'erro', a menos que seja dito o contrário
        String result = "miss!";

        //Repete isso com todas as Startups da lista
        for(Startup startupToTest : startups) {
            //Solicita à Startup para verificar o palpite do usuário, procurando por um acerto (ou um abate) 
            result = startupToTest.checkYourself(userGuess);

            if(result.equals("hit!")) {
                //Sai antes do loop, não adianta testar os outros
                break;
            }
            if(result.equals("kill!")) {
                //Esta foi abatida, então é removida da lista e sai do loop
                startups.remove(startupToTest);
                break;
            }
        } //fecha o loop for
        //Exibe o resultado ao usuário
        System.out.println(result);
    } //fecha o método checkUserGuess

    private void finishGame() {
        //Printa uma mensagem contando ao usuário como ele se saiu no jogo
        System.out.println("All startups are dead! Your stock is now worthless!");
        if(numOfGuesses <= 18) {
            System.out.printf("It only took you %d guesses\n", numOfGuesses);
            System.out.println("You got out before your options snak!");
        } else {
            System.out.printf("Took you long enough. %d guesses\n", numOfGuesses);
            System.out.println("Fish are dancing with your options!");
        }
    } //fecha o método finishGame

    public static void main(String[] args) {
        //Cria o objeto game
        StartupBust game = new StartupBust();
        //Solicita ao objeto game para configurar o jogo
        game.setUpGame();
        /*Solicita ao objeto game para iniciar o loop principal do jogo (permanece solicitando a entrada do usuário e
        verificando o palpite)*/
        game.startPlaying();
    } //fecha o método main
}
