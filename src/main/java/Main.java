import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.displayChanceCard("test");







        /////////////////////// Tilhører Properties ////////////////
        GUI_Field field;

        // Tilgår start feltet - hentet fra github UI guide
        GUI_Field[] fields = gui.getFields();
        field = fields[0];

        //Field.play();

        // Cast felt til GUI_Ownable
        //GUI_Ownable ownable = (GUI_Ownable) field;
        //ownable.setSubText("Pris: 1000");
        //field.setBackgroundColor(Color.WHITE);

        field = gui.getFields()[1];
        field.setTitle("Burgerbaren");
        field.setSubText("M1");

        field = gui.getFields()[2];
        field.setTitle("Pizzahuset");
        field.setSubText("M1");

        field = gui.getFields()[3];
        field.setTitle("Chance");
        field.setSubText("");

        field = gui.getFields()[4];
        field.setTitle("Godtebutikken");
        field.setSubText("M1");

        field = gui.getFields()[5];
        field.setTitle("Iskiosken");
        field.setSubText("M1");

        field = gui.getFields()[6];
        field.setTitle("I fængsel");
        field.setSubText("På besøg");

        field = gui.getFields()[5];
        field.setTitle("Museet");
        field.setSubText("M2");

        field = gui.getFields()[6];
        field.setTitle("Biblioteket");
        field.setSubText("M2");

        field = gui.getFields()[7];
        field.setTitle("Chance");

        field = gui.getFields()[8];
        field.setTitle("Rullebrætparken");
        field.setSubText("M2");

        field = gui.getFields()[9];
        field.setTitle("Svømmebassinet");
        field.setSubText("M2");

        field = gui.getFields()[10];
        field.setTitle("Gratis");
        field.setSubText("Parkering");

    }

}
