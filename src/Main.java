import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> directions = new HashMap<>();

    static {
        directions.put("NORTH", -1);
        directions.put("SOUTH", 1);
        directions.put("EAST", -2);
        directions.put("WEST", 2);
    }

    public static void main(String[] args) {
        String[] testString = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};

        testString = dirReduc(testString); // ["WEST"]
        for (String s : testString) {
            System.out.println(s);
        }

    }

    public static String[] dirReduc(String[] income) {
        ArrayList<String> outcome = new ArrayList<>();
        boolean isDone = true;

        for (int i = 0; i < income.length; i++) {
            if (i < income.length - 1) {
                int negation = directions.get(income[i]) + directions.get(income[i + 1]);
                if (negation != 0) {
                    outcome.add(income[i]);
                } else {
                    i++;
                    isDone = false;
                }
            } else {
                outcome.add(income[i]);
            }
        }

        String[] outcomeStrings = outcome.toArray(new String[outcome.size()]);
        if (!isDone) {
            outcomeStrings = dirReduc(outcomeStrings);
        }

        return outcomeStrings;
    }
}