import java.util.*;

public class GameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1;
    static final int VERTICAL_INCREMENT = GRID_LENGTH;

    private final int[] grid = new int[GRID_SIZE];
    private final Random random = new Random();
    private int startupCount = 0;

    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    } //fim do getUserInput

    public ArrayList<String> placeStartup(int startupSize) {
        //Armazena o índice para a grade (0 - 48)
        int[] startupCoords = new int[startupSize]; //Atuais coordenadas do candidato
        int attempts = 0;                           //Contador de tentativas atuais
        boolean success = false;                    //Flag = achou um bom local?

        startupCount++;                             //Inserindo a enésima Startup
        int increment = getIncrement();             //Alinhamento vert/horiz alternativo

        while(!success & attempts < MAX_ATEMPTS) {  //Loop de pesquisa principal
            int location = random.nextInt(GRID_SIZE); //Obtém ponto de partida aleatório

            for(int i = 0; i < startupCoords.length; i++) { //Cria array de coordenadas propostas
                startupCoords[i] = location;                //Insere local atual da array
                location += increment;                       //Calcula o próximo local
            }

            if(startupFits(startupCoords, increment)) { //A Startup cabe na grade?
                success = coordsAvailable(startupCoords); //... E os locais não foram ocupados?
            }
        }
        savePositionToGrid(startupCoords);
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);

        return alphaCells;
    } //Fim do método placeStartup

    private boolean startupFits(int[] startupCoords, int increment) {
        int finalLocation = startupCoords[startupCoords.length - 1];
        if(increment == HORIZONTAL_INCREMENT) {
            //Verifica se o final está na mesma linha do início
            return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < GRID_SIZE; //Verifica se a extremidade não excede a parte inferior
        }
    } //Fim do startupFits

    private boolean coordsAvailable(int[] startupCoords) {
        for(int coord : startupCoords) { //Verificatodas as posições potenciais
            if(grid[coord] != 0) { //Essa posição já foi ocupada
                return false; //SEM sucesso...
            }
        }
        return true; //Não houve conflitos! Woohoo!
    } //Fim do coods available

    private void savePositionToGrid(int[] startupCoords) {
        for(int index : startupCoords) {
            grid[index] = 1; //Marca a posição da grade como usada 
        }
    } //Fim do savePositionToGrid

    private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for(int index : startupCoords) {                          //Para cada coordenada da grade
            String alphaCoords = getAlphaCoordsFromIndex(index); //Tansforma em um estilo "a0"
            alphaCells.add(alphaCoords);                         //Adciona à lista
        }

        return alphaCells;
    } //Fim do convertCoordsToAlphaFormat

    private String getAlphaCoordsFromIndex(int index) {
        int row = calcRowFromIndex(index);  //Obtém o valor da linha
        int column = index % GRID_LENGTH;   //Obtém o valor da coluna numérica
        String letter = ALPHABET.substring(column, column + 1); //Converte em letra
        return letter + row; 
    } //Fim do getAlphaCoordsFromIndex

    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    } //Fim do calcRowFromIndex

    private int getIncrement() {
        if(startupCount % 2 == 0) {       //Se houve Startup
            return HORIZONTAL_INCREMENT; //Insere horizontalmente
        } else {                        //Else ODD
            return VERTICAL_INCREMENT;  //Insere verticalmente
        }
    } //Fim do getIncrement
} //Fim da classe