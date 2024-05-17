import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true){
            logMemoryUsage("memory_10_000.csv");
            list.add(generateRandomString(10_000));
        }
    }

    public static void logMemoryUsage(String filePath) {
        MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        try (FileWriter writer = new FileWriter(filePath, true)) {
            if (!fileExists(filePath)) {
                writer.append("Init,Committed,Used,Max");
                writer.append("\n");
            }
            writer.append(String.format("%d, %d, %d, %d\n",
                    memoryUsage.getInit(),
                    memoryUsage.getCommitted(),
                    memoryUsage.getUsed(),
                    memoryUsage.getMax()));

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
