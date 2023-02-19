import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Events {
    public static void main(String[] args) {

        List<List<String>> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("eventsBase.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] valuesInColumns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                events.add(Arrays.asList(valuesInColumns).stream().map(s -> s.replace("\"", "")).collect(Collectors.toList()));
            }
        } catch (IOException e) {
            System.err.println("Error during import");
        }

        for (List<String> event : events) {
            for (String column : event) {
                System.out.print(column + ", ");
            }
            System.out.println("\n");

        }

    }
}