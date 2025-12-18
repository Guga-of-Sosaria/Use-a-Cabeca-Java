import java.util.Random;

public class PhraseOMatic {
    public static void main(String[] args) {
        //Arrays com as palavras
        String[] wordListOne = {"agnostic", "opinionated", "voice activated", "haptically driven", "extensible", "reactive", 
                                "agent based", "functional", "strongly typed"};
        String[] wordListTwo = {"loosely coupled", "six sigma", "assynchronous", "event driven", "pub-sub", "IoT", "cloudnative", 
                                "service oriented", "containerized", "serverless", "microservices", "distributed ledger"};
        String[] wordListThree = {"framework", "library", "DSL", "REST API", "repository", "pipeline", "servicemesh", "architecture", 
                                "perspective", "design", "orientation"};
        //Quantidade de palavras de cada lista
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        
        //Gera três números aleatórios correspondentes a uma palavra de cada array
        Random randomGenerator = new Random();
        int rand1 = randomGenerator.nextInt(oneLength);
        int rand2 = randomGenerator.nextInt(twoLength);
        int rand3 = randomGenerator.nextInt(threeLength);
        //Monta a frase com as palavras escolhidas
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        //Exibe a frase
        System.out.printf("We need a %s\n", phrase);
    }
}
