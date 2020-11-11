import gui_fields.GUI_Field;
import gui_fields.GUI_Start;

import java.awt.*;

public class UIController {

    public GUI_Field[] UIFieldGen(int test){
        GUI_Field[] guiFields = new GUI_Field[test];
        for (int i = 0; i < guiFields.length; i++) {
            guiFields[i] = new GUI_Start("Start", "Modtag: 200", "Modtag kr. 200,-\nnår de passerer start", Color.RED, Color.BLACK); {
            }
        }
        return guiFields;
    }
}
