import gui_fields.GUI_Field;

public class UIController {

    public GUI_Field[] UIFieldGen(Field[] ourFields){
        GUI_Field[] guiFields = new GUI_Field[ourFields.length];
        for (int i = 0; i < guiFields.length; i++) {
            guiFields[i] = new GUI_Field() {
            }
        }
    }
}
