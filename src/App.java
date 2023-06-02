import java.io.*;
import java.util.*;

public class App {

    public static class JSONObject {

        private Map<String, Object> map = new HashMap<>();

        public JSONObject() {}

        public JSONObject(Map<String, Object> map) {
            this.map = map;
        }

        public void put(String key, Object value) {
            map.put(key, value);
        }

        public Object get(String key) {
            return map.get(key);
        }

        @Override
        public String toString() {
            return map.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        // Prompt the user to enter the location of the CSV file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the location of the CSV file: ");
        String csvFilePath = scanner.nextLine();

        // Read the CSV file into a List
        List<String[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            data.add(line.split(","));
        }

        // Convert the List to JSON
        JSONObject json = new JSONObject();
        for (String[] row : data) {
            JSONObject object = new JSONObject();
            for (int i = 0; i < row.length; i++) {
                object.put(row[i], row[i]);
            }
            json.put(row[0], object);
        }

        // Write the JSON to a file
        FileWriter writer = new FileWriter("dataExport.json");
        writer.write(json.toString());
        writer.close();
    }
}
