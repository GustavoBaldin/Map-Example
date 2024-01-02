import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Insert the path: ");
        String path = in.nextLine();

        File file = new File(path);
        Map<String,Integer> candidates = new HashMap<>();

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] tempCandidates = sc.nextLine().split(",");
                if (candidates.containsKey(tempCandidates[0])) {
                    candidates.replace(tempCandidates[0], candidates.get(tempCandidates[0]) + Integer.parseInt(tempCandidates[1]));
                }
                else {
                    candidates.put(tempCandidates[0], Integer.parseInt(tempCandidates[1]));
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Map.Entry<String,Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}