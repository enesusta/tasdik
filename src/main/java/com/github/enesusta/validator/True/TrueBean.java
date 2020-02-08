package com.github.enesusta.validator.True;

public class TrueBean {

    @True
    private boolean someLogic;

    public boolean isSomeLogic() {
        return someLogic;
    }

    public void setSomeLogic(boolean someLogic) {
        this.someLogic = someLogic;
    }
}
