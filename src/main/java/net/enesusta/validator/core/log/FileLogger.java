package net.enesusta.validator.core.log;

import com.google.auto.service.AutoService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@AutoService(Logger.class)
public class FileLogger implements Logger {

    private BufferedWriter writer;

    public FileLogger() throws IOException {
        writer = new BufferedWriter(new FileWriter("log.txt"));
    }

    @Override
    public void log(String message) throws Exception {
        writer.append(message);
        writer.flush();
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
