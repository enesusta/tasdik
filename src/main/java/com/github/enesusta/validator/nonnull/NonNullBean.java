package com.github.enesusta.validator.nonnull;

import java.io.Serializable;

public class NonNullBean implements Serializable {
    private static final long serialversionUID = 1L;

    @NonNull(ignore = true)
    private String sampleString;

    @NonNull(ignore = true)
    private static String sampleStaticString;

    @NonNull
    private int sampleInt;

}