import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.displayChanceCard("test");


        //Test
        Jail j = new Jail();
        j.fieldDescription = "This is jail";
        System.out.println(j.fieldDescription);
    }

}
