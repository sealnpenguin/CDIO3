import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UIController {
    private GUI gui;
    private GUI_Player[] guiPlayers;


    // constructer der automatisk opretter gui ud fra fields og players
    public UIController(Player[] players, Field[] fields){
        this.gui = new GUI(UIFieldGen(fields));
        this.guiPlayers = new GUI_Player[players.length];
        this.guiPlayers = UIPlayerGen(players);
        for (int i = 0; i < players.length; i++) {
            this.gui.addPlayer(guiPlayers[i]);
        }
    }
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

        public void updateGUIPlayerPos(Player player, int oldPosition,int newPosition){
            for (GUI_Player p: guiPlayers) {
                if(p.getName().equals(player.getName())){
                    gui.getFields()[newPosition].setCar(p, true);
                    gui.getFields()[oldPosition].setCar(p, false);
                }
            }

        }

}
