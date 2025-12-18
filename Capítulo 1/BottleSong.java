public class BottleSong {
    public static void main(String [] args) {
        int bottlesNum = 10;
        String word = "bottles";
        
        while (bottlesNum > 0) {
            if (bottlesNum == 1) {
                word = "bottle"; //Coloca "bottles" no singular caso haja só uma garrafa
            }

            System.out.printf("%d green %s, hanging on the wall...\n", bottlesNum, word);
            System.out.println("And if one green bottle should accidentally fall...");
            bottlesNum -= 1;
            if (bottlesNum > 0) {
                System.out.printf("There will be %d green %s hanging on the wall!\n", bottlesNum, word);
            } else {
                System.out.println("There will be no green bottles hanging on the wall!");
            }
            System.out.println(); //println para deixar o output mais legível
        }
    }
}
