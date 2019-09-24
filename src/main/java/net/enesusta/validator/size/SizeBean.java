package net.enesusta.validator.size;

public class SizeBean {

    @Size(min = 15, max = 35)
    private int anInt;

    @Size(min = 3, max = 15)
    private String string;


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
}
