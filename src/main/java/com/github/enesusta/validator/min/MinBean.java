package com.github.enesusta.validator.min;

public class MinBean {

    @Min(min = 5)
    private byte aByte;

    @Min(min = 5)
    private short aShort;

    @Min(min = 6)
    private int anInt;

    @Min(min = 5)
    private long aLong;

    @Min(min = 5)
    private double aDouble;

    @Min(min = 5)
    private float aFloat;

    @Min(min = 5)
    private String string;

    public void setaByte(byte aByte) {
        this.aByte = aByte;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public void setString(String string) {
        this.string = string;
    }
}
