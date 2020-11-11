import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Start;

import java.awt.*;

public class UIController {

    public GUI_Field[] UIFieldGen(int test){
        GUI_Field[] guiFields = new GUI_Field[test];
        for (int i = 0; i < guiFields.length; i++) {
            //Stub code to see if it works as expected
            if(i == 18){
                guiFields[i] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
            }
            else {
                guiFields[i] = new GUI_Start("Start", "Modtag: 200", "Modtag kr. 200,-\nnår de passerer start", Color.RED, Color.BLACK);

            }
        }
        return guiFields;
    }
}
