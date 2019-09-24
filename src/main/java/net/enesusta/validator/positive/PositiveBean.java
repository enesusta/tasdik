package net.enesusta.validator.positive;

import net.enesusta.validator.core.Bean;

public class PositiveBean implements Bean {

    @Positive
    private byte numb1;

    @Positive
    private short numb2;

    @Positive
    private int numb3;

    @Positive
    private long numb4;

    @Positive
    private float numb5;

    @Positive
    private double numb6;

    @Override
    public Object get() {
        return this;
    }
}
