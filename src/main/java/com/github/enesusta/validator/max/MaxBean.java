package com.github.enesusta.validator.max;

public class MaxBean {

    @Max(max = 15)
    private int anInt;

    @Max(max = 5)
    private String string;

    @Max(max = 4)
    private float aFloat;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }
}
