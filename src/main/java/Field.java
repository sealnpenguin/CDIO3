public class Field {
    //Die for development purposes (from CDIO 2)
    private static int MAX = 6; // max value of a die
    private static int faceValue; // value of the die
    public static int rollDice() {
        faceValue = (int)(Math.random() * MAX) +1;
        return faceValue;
    }
    String[] allFields;
    public Field(String[]field){
        this.allFields = field;
    }

    public static void play() { //working title
        rollDice();
        System.out.println(faceValue);


    }
}
