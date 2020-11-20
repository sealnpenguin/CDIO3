//Class that takes care of language support by returning the array that holds the wanted language
public class Language {

    String lang;
    //array that stores string in danish
    String[] dk = {"Indtast antallet af spillere fra 2-4", "Prøv igen i intervallet 2-4", "Indtast navn til spiller ", " vælg en farve til din bil",
            "RØD", "SORT", "BLÅ", "MAGENTA", "ROSE", "CYAN", "GUL", "HVID", " har 0M og taber spillet", "Og vinderen er ... "," tryk på knappen for at kaste terningen!","Kast"};

    //array that store strings in english
    String[] eng = {"Enter the number of players ranging from 2-4", "Please try again in the range of 2-4", "Enter name for player ", " choose a color for your car",
            "RED", "BLACK", "BLUE","MAGENTA","PINK","CYAN","YELLOW","WHITE", " has reached 0 and lost the game", "And the winner is...  ", " press button to roll the die!", "Roll"};


    public Language(String lang) {
        this.lang = lang;
    }
    //Method that takes in a language choice as a string and returns the correct string array to display console text
    public String[] returnLang() {
        return switch (this.lang) {
            case "English" -> this.eng;
            case "Dansk" -> this.dk;
            default -> this.eng;
        };

    }

}