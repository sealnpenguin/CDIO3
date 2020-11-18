import gui_fields.*;

import java.awt.*;

public class UIController {

   //Generates GUI_Player array from logic player array
   public GUI_Player[] UIPlayerGen(Player[] players){
       GUI_Player[] guiPlayers = new GUI_Player[players.length];
       for (int i = 0; i < players.length; i++) {
           guiPlayers[i] = new GUI_Player(players[i].getName(), players[i].getMoney());
       }
        return guiPlayers;

    }

    //Generates a GUI_Field array from a logic Field array
    public GUI_Field[] UIFieldGen(Field[] fieldArray){
        GUI_Field[] guiFields = new GUI_Field[fieldArray.length];
        for (int i = 0; i < fieldArray.length; i++) {

            if(fieldArray[i] instanceof FieldStart){
                guiFields[i] = new GUI_Start(((FieldStart) fieldArray[i]).getFieldName(), ((FieldStart) fieldArray[i]).getFieldDescription(), ((FieldStart) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldChance){
                guiFields[i] = new GUI_Chance(((FieldChance) fieldArray[i]).getFieldName(), ((FieldChance) fieldArray[i]).getFieldDescription(), ((FieldChance) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof Jail) {
                guiFields[i] = new GUI_Jail( "default",((Jail) fieldArray[i]).getFieldName(), ((Jail) fieldArray[i]).getFieldDescription(), ((Jail) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof Properties) {
                guiFields[i] = new GUI_Street(((Properties) fieldArray[i]).getFieldName(), ((Properties) fieldArray[i]).getFieldDescription(), ((Properties) fieldArray[i]).getFieldDescription(), "pris metode", Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("visit")) {
                guiFields[i] = new GUI_Refuge("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("parking")) {
                guiFields[i] = new GUI_Refuge("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }

        }
        return guiFields;
    }
}
