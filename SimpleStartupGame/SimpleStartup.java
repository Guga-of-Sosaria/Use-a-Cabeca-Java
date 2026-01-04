public class SimpleStartup {
    private int[] locationCells;
    private int[] usedNumbers = new int[2048];
    private int numOfHits;
    private int usedNumbersIndex = 0;

    //Método para verificar se o palpite do usuário está correto
    public String checkYourself(int guess) {
        //Variável armazena o resultado do palpite
        String result = "miss!";
        
        //Esse if statement verifica se o usuário está usando um número repitido
        if(usedNumbersIndex == 0) {
            usedNumbers[usedNumbersIndex] = guess;
            usedNumbersIndex ++;
        //Se o usuário já usou o número antes, informa ao usuário e pede para ele tentar de novo
        } else if(wasUsed(usedNumbers, guess)){
            result = "you already used that number!";
            System.out.println(result);
            return result;
        }
        //Adciona qualquer palpite novo a lista de números usados
        usedNumbers[usedNumbersIndex] = guess;
        usedNumbersIndex ++;
        //Verifica se o usuário conseguiu acertar alguma coisa
        for(int cell : locationCells) {
            if(guess == cell) {
                result = "hit!";
                numOfHits++;
                break;
            }
        }
        //Se o usuário tiver acertado todas as partes do barco, muda o valor de result para "kill!"
        if(numOfHits == locationCells.length) {
            result = "kill!";
        }

        //Printa o resultado e também o retorna como string
        System.out.println(result);
        return result;
    }

    public void setLocationCells(int[] loc) {
        locationCells = loc;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public boolean wasUsed(int[] numbers, int num) {
        boolean used = false;
        for(int i : numbers) {
            if(num == i) {
                used = true;
                break;
            }
        }
        return used;
    }
}