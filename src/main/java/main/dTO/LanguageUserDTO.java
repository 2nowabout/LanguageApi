package main.dTO;

public class LanguageUserDTO {
    private LanguageDTO languageDTO;
    private int userId;

    public LanguageDTO getLanguageDTO() {
        return languageDTO;
    }

    public void setLanguageDTO(LanguageDTO languageDTO) {
        this.languageDTO = languageDTO;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
