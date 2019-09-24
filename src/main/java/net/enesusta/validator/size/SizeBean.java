package net.enesusta.validator.size;

public class SizeBean {

    @Size(min = 15, max = 35)
    private int anInt;

    @Size(min = 5, max = 25)
    private double aDouble;

    @Size(min = 3, max = 123)
    private float aFloat;

    @Size(min = 3, max = 15)
    private String string;

    @Size(min = 2, max = 5)
    private String string2;


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

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }
}
