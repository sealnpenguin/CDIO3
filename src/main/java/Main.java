import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.displayChanceCard("test");




        ///////////////////////Tilhører Properties, når "gui" oprettes et andet sted, så man kan nedarve?
        //GUI_Field field;

        // Tilgår start feltet - hentet fra github UI guide
        //GUI_Field[] fields = gui.getFields();
        //field = fields[0];






        // Opretter spiller
        GUI_Player player = new GUI_Player("Stephen", 2000);
        gui.addPlayer(player);

// Henter feltet
        GUI_Field field = gui.getFields()[4];

// Sæt bilen til at blive vist
        field.setCar(player, true);
        //Field.play();

        // Cast felt til GUI_Ownable
        //field = gui.getFields()[1];
        GUI_Ownable ownable = (GUI_Ownable) field;


        for (int i = 0; i < 24; i++ ) {
            field = gui.getFields()[i];
            ownable = (GUI_Ownable) field;
            if (i == 0){
                ownable.setSubText("Pris: 1000");
                //field.setBackgroundColor(Color.WHITE);
            }
            switch (i) {
                case 1 -> {
                    field.setTitle("Burgerbaren");
                    ownable.setSubText("M1");
                }
                case 2 -> {
                    field.setTitle("Pizzahuset");
                    ownable.setSubText("M1");
                }
                case 3 -> field.setTitle("Chance");
                case 4 -> {
                    field.setTitle("Godtebutikken");
                    ownable.setSubText("M1");
                }
                case 5 -> {
                    field.setTitle("Iskiosken");
                    ownable.setSubText("M1");
                }
                case 6 -> ownable.setSubText("Pris: 1000");
                case 7 -> ownable.setSubText("Pris: 1000");
                case 8 -> ownable.setSubText("Pris: 1000");
                case 9 -> field.setTitle("Chance");
            }

        }
    }

}
