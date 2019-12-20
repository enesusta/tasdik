package com.github.enesusta.validator.core.log;

import com.google.auto.service.AutoService;

@AutoService(Logger.class)
public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) throws Exception {
        System.err.printf("%s \n", message);
    }

    @Override
    public void close() throws Exception {

    }
}
