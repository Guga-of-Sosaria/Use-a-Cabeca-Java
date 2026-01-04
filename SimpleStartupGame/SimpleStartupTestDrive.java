class SimpleStartup {
    private int[] locationCells;
    private int numOfHits;

    public String checkYourself(int guess) {
        String result = "miss!";
        
        for(int cell : locationCells) {
            if(guess == cell) {
                result = "hit!";
                numOfHits++;
                break;
            }
        }

        if(numOfHits == locationCells.length) {
            result = "kill!";
        }

        System.out.println(result);
        return result;
    }

    public void setLocationCells(int[] loc) {
        locationCells = loc;
    }

    public void setNumOfHits(int num) {
        numOfHits = num;
    }
}

public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup dot = new SimpleStartup();
        
        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        int userGuess = 2;
        String result = dot.checkYourself(userGuess);

        if(result.equals("hit!")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
