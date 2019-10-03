package net.enesusta.validator.core;

import net.enesusta.validator.email.Email;
import net.enesusta.validator.max.Max;
import net.enesusta.validator.min.Min;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.size.Size;

public class Student {

    @Positive
    @Max(max = 10)
    private int stduID;

    @Size(min = 3, max = 10)
    private String stduName;

    @Size(min = 3, max = 10)
    private String stduSurname;

    @Min(min = 15)
    private String stduAddress;

    @Email
    @Size(min = 3, max = 6)
    private String stduEmail;

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

    public String getStduEmail() {
        return stduEmail;
    }

    public void setStduEmail(String stduEmail) {
        this.stduEmail = stduEmail;
    }
}
