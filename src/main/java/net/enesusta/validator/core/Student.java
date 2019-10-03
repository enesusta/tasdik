package net.enesusta.validator.core;

import net.enesusta.validator.max.Max;
import net.enesusta.validator.min.Min;
import net.enesusta.validator.negative.Negative;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.size.Size;

public class Student {

    @Negative
    private int stduID;

    @Size(min = 3,max = 10)
    private String stduName;

    @Size(min = 3,max = 10)
    private String stduSurname;

    @Min(min = 15)
    private String stduAddress;

    @Max(max = 100)
    private byte stduNote;

    public void setStduID(int stduID) {
        this.stduID = stduID;
    }

    public void setStduName(String stduName) {
        this.stduName = stduName;
    }

    public void setStduSurname(String stduSurname) {
        this.stduSurname = stduSurname;
    }

    public void setStduAddress(String stduAddress) {
        this.stduAddress = stduAddress;
    }

    public void setStduNote(byte stduNote) {
        this.stduNote = stduNote;
    }
}
