import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UIController {
    private GUI gui;
    private GUI_Player[] guiPlayers;


    // Constructer that automatically generates GUI with all the players
    public UIController(Field[] fields){
        this.gui = new GUI(UIFieldGen(fields));
    }

    public UIController(Player[] players, Field[] fields){
        this.gui = new GUI(UIFieldGen(fields));
        guiPlayers = new GUI_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            guiPlayers[i] = new GUI_Player(players[i].getName(), players[i].getMoney());
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

    public void addPlayers(Player[] players){
        guiPlayers = new GUI_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            guiPlayers[i] = new GUI_Player(players[i].getName(), players[i].getMoney());
            this.gui.addPlayer(guiPlayers[i]);
        }
    }

    //Generates a GUI_Field array from a logic Field array
    public GUI_Field[] UIFieldGen(Field[] fieldArray){
        GUI_Field[] guiFields = new GUI_Field[fieldArray.length];
        for (int i = 0; i < fieldArray.length; i++) {

            if(fieldArray[i] instanceof FieldStart){
                guiFields[i] = new GUI_Start(((FieldStart) fieldArray[i]).getFieldName(), ((FieldStart) fieldArray[i]).getFieldDescription(), ((FieldStart) fieldArray[i]).getFieldDescription(), Color.white, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldChance){
                guiFields[i] = new GUI_Chance(((FieldChance) fieldArray[i]).getFieldName(), ((FieldChance) fieldArray[i]).getFieldDescription(), ((FieldChance) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof Jail) {
                guiFields[i] = new GUI_Jail( "default",((Jail) fieldArray[i]).getFieldName(), ((Jail) fieldArray[i]).getFieldDescription(), ((Jail) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof Properties) {
                Color color, txtcolor;
                txtcolor = Color.black;
                color = Color.red;
                if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("blå")){
                    color = Color.blue;
                    txtcolor = Color.white;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("lilla")){
                    color = Color.magenta;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("brun")){
                    color = Color.gray;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("rød")){
                    color = Color.red;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("gul")){
                    color = Color.yellow;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("lysegul")){
                    color = Color.orange;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("lyseblå")){
                    color = Color.cyan;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("grøn")){
                    color = Color.green;
                }

                guiFields[i] = new GUI_Street(((Properties) fieldArray[i]).getFieldName(), ((Properties) fieldArray[i]).getFieldDescription(), ((Properties) fieldArray[i]).getFieldDescription(), "pris metode", color, txtcolor);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("I fængsel")) {
                guiFields[i] = new GUI_Jail("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("Gratis")) {
                guiFields[i] = new GUI_Refuge("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }

        }
        return guiFields;
    }
        //Updates GUI_Player according to corresponding Player
        public void updateGUIPlayerPos(Player player, int oldPosition,int newPosition){

            for (int i = 0; i < guiPlayers.length; i++) {
                if(guiPlayers[i].getName().equals(player.getName())){
                    gui.getFields()[oldPosition].setCar(guiPlayers[i], false);
                    gui.getFields()[newPosition].setCar(guiPlayers[i], true);

                }
            }

        }

        public GUI_Player getGuiPlayer(int playerNumber){
        return guiPlayers[playerNumber];
        }

        public GUI getGUI(){return this.gui;}

}
