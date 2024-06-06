import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteOn{
    private final String fileName;

    public WriteOn(String fileName)
    {
        this.fileName = fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String HEADER = "Nr kolizji    Wektor prędkości po kolizji 1. obiektu    Masa 1. obiektu    Wektor prędkości po kolizji 2. obiektu    Masa 2. obiektu";
            writer.write(HEADER + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void writeNew(int collisionNumber, double v1, int m1, double v2, int m2) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String collisionData = String.format("%6d%29.2f%29d%32.2f%30d%n", collisionNumber, v1/100, m1, v2/100, m2);
            writer.write(collisionData);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }


    public static String generateFileName()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String timeStamp = now.format(format);
        return "Collisions_" + timeStamp +".txt";
    }

}
