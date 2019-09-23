package net.enesusta.validator.core.log;

public interface Logger extends AutoCloseable {
    void log(String message) throws Exception;
}
