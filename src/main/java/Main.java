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

    }

}
