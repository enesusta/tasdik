package net.enesusta.validator.nonnull;

import java.io.Serializable;

public class SampleBean implements Serializable {
    private static final long serialversionUID = 1L;

    @NonNull(ignore = true)
    private String sampleString;

    @NonNull
    private static String sampleStaticString;

}
