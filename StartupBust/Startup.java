import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;
    private String name;

    public String checkYourself(String userInput) {
        String result = "miss!";
        int index = locationCells.indexOf(userInput);

        if(index >= 0) {
            locationCells.remove(index);

            if(locationCells.isEmpty()) {
                System.out.printf("Ouch! you sunk %s! :(\n", name);
                result = "kill!";
            } else {
                result = "hit!";
            }
        }
        return result;
    }
    
    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public void setName(String n) {
        name = n;
    }

}
