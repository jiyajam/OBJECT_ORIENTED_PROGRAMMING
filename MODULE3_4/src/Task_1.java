import java.io.*;
import java.net.*;
import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        URL myUrl;
        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
            return;
        }

        List<Double> temperatures = new ArrayList<>();

        try {
            InputStream istream = myUrl.openStream();
            InputStreamReader istreamReader = new InputStreamReader(istream);
            BufferedReader reader = new BufferedReader(istreamReader);

            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length < 2) continue;

                String timestamp = parts[0];
                String tempStr = parts[1];

                if (timestamp.startsWith("1.1.2023") && !tempStr.isEmpty()) {
                    try {

                        double temp = Double.parseDouble(tempStr.replace(',', '.'));
                        temperatures.add(temp);
                    } catch (NumberFormatException e) {
                    }
                }
            }

            reader.close();

            if (temperatures.isEmpty()) {
                System.out.println("No temperature data found for 1.1.2023.");
            } else {
                double sum = 0;
                for (double temp : temperatures) {
                    sum += temp;
                }
                double average = sum / temperatures.size();
                System.out.printf("Average temperature on 1.1.2023: %.2f °C%n", average);
            }

        } catch (IOException e) {
            System.err.println("Error reading from URL: " + e.getMessage());
        }
    }
}
