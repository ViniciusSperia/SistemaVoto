import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    public static <T extends CsvSerializable> void export(
            List<T> data,
            String filePath,
            String separator,
            String header
    ) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(header + "\n");
            for (T item : data) {
                writer.write(item.toCsvRow(separator) + "\n");
            }
        }
    }
}
