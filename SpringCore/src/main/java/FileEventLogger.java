import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) throws IOException {
        writeDataToFile(event.toString());
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        file.canWrite();
    }

    protected void writeDataToFile(String data) throws IOException {
        FileUtils.writeStringToFile(file, data, true);

    }
}
