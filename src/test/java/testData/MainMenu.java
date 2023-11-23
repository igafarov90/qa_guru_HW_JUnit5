package testData;

public enum MainMenu {

    START_HERE("Start Here"),
    COURSES("Courses"),
    GUIDES("Guides"),
    ABOUT("About");

    private final String mainMenu;

    MainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getMainMenu() {
        return mainMenu;
    }

}
