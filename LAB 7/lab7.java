import java.io.*;
import java.util.Scanner;

public class lab7 {
     public static void main(String[] args) throws Exception {
        //parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("C:\\Users\\Aqsa\\Downloads\\Iris.csv"));
        List<Double> sepalLengths = new ArrayList<>();
        List<Double> sepalWidths = new ArrayList<>();
        List<Double> petalLengths = new ArrayList<>();
        List<Double> petalWidths = new ArrayList<>();

        for (CSVRecord record : parser) {
            sepalLengths.add(Double.parseDouble(record.get("SepalLengthCm")));
            sepalWidths.add(Double.parseDouble(record.get("SepalWidthCm")));
            petalLengths.add(Double.parseDouble(record.get("PetalLengthCm")));
            petalWidths.add(Double.parseDouble(record.get("PetalWidthCm")));
        }

        double[] sepalLengthArray = sepalLengths.stream().mapToDouble(Double::doubleValue).toArray();
        double[] sepalWidthArray = sepalWidths.stream().mapToDouble(Double::doubleValue).toArray();
        double[] petalLengthArray = petalLengths.stream().mapToDouble(Double::doubleValue).toArray();
        double[] petalWidthArray = petalWidths.stream().mapToDouble(Double::doubleValue).toArray();

        // Step 2: Calculate the overall summary statistics
        System.out.println("Overall Summary Statistics:");
        System.out.printf("SepalLengthCm: Mean=%.2f, Median=%.2f, Mode=%.2f, Min=%.2f, Max=%.2f%n",
                mean(sepalLengthArray), median(sepalLengthArray), mode(sepalLengthArray), 
                min(sepalLengthArray), max(sepalLengthArray));
        System.out.printf("SepalWidthCm: Mean=%.2f, Median=%.2f, Mode=%.2f, Min=%.2f, Max=%.2f%n",
                mean(sepalWidthArray), median(sepalWidthArray), mode(sepalWidthArray), 
                min(sepalWidthArray), max(sepalWidthArray));
        System.out.printf("PetalLengthCm: Mean=%.2f, Median=%.2f, Mode=%.2f, Min=%.2f, Max=%.2f%n",
                mean(petalLengthArray), median(petalLengthArray), mode(petalLengthArray), 
                min(petalLengthArray), max(petalLengthArray));
        System.out.printf("PetalWidthCm: Mean=%.2f, Median=%.2f, Mode=%.2f, Min=%.2f, Max=%.2f%n",
                mean(petalWidthArray), median(petalWidthArray), mode(petalWidthArray), 
                min(petalWidthArray), max(petalWidthArray));
        System.out.println();

        // Step 3: Calculate the summary statistics for each species of Iris flower
        parser = CSVParser.parse(irisFile, java.nio.charset.StandardCharsets.UTF_8, CSVFormat.DEFAULT.withHeader());
        Map<String, List<CSVRecord>> recordsBySpecies = parser.getRecords().stream().collect(Collectors.groupingBy(r -> r.get("Species")));

       
    }  
}      