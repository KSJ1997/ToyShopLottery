package src.main.java;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PrizeLogWriter {
    private String filePath;

    public PrizeLogWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writePrizeLog(List<Toy> prizeToys) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            for (Toy toy : prizeToys) {
                writer.write(toy.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
