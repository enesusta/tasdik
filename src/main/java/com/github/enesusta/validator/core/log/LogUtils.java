package com.github.enesusta.validator.core.log;

import java.util.Iterator;
import java.util.ServiceLoader;

public class LogUtils {
    public static void flush(final String message) {
        final ServiceLoader<Logger> serviceLoader = ServiceLoader.load(Logger.class);
        final Iterator<Logger> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            try (final Logger logger = iterator.next()) {
                logger.log(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
