package main.dTO;

import main.models.Language;

public class LanguageUserDTO {
    private Language language;
    private int userId;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
