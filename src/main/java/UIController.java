import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UIController {
    private GUI gui;
    private Arraylist<GUI_Player> GuiPlayers = new Arraylist<>();


    // Constructer that automatically generates GUI with all the players
    public UIController(Arraylist<Player> players, Arraylist<Field> fields){

        this.gui = new GUI(UIFieldGen(fields));
        this.GuiPlayers = UIPlayerGen(players);
        for (int i = 0; i < players.listLength(); i++) {
            this.gui.addPlayer(UIPlayerGen(players).atIndex(i));
        }
    }
   //Generates GUI_Player array from logic player array
   public Arraylist<GUI_Player> UIPlayerGen(Arraylist<Player> list){
       for (int i = 0; i < list.listLength(); i++) {
           this.GuiPlayers.add(new GUI_Player(list.atIndex(i).getName(), list.atIndex(i).getMoney()));
       }
        return GuiPlayers;

    }

    //Generates a GUI_Field array from a logic Field array
    public GUI_Field[] UIFieldGen(Arraylist<Field> fieldList){
        Arraylist<GUI_Field> guiFields = new Arraylist<>();
        for (int i = 0; i < fieldList.listLength(); i++) {

            if(fieldList.atIndex(i) instanceof FieldStart){
                guiFields.add(new GUI_Start(((FieldStart) fieldList.atIndex(i)).getFieldName(), ((FieldStart) fieldList.atIndex(i)).getFieldDescription(), ((FieldStart) fieldList.atIndex(i)).getFieldDescription(), Color.RED, Color.BLACK));
            }
            else if(fieldList.atIndex(i) instanceof FieldChance){
                guiFields.add(new GUI_Chance(((FieldChance) fieldList.atIndex(i)).getFieldName(), ((FieldChance) fieldList.atIndex(i)).getFieldDescription(), ((FieldChance) fieldList.atIndex(i)).getFieldDescription(), Color.RED, Color.BLACK));
            }
            else if(fieldList.atIndex(i) instanceof Jail) {
                guiFields.add(new GUI_Jail( "default",((Jail) fieldList.atIndex(i)).getFieldName(), ((Jail) fieldList.atIndex(i)).getFieldDescription(), ((Jail) fieldList.atIndex(i)).getFieldDescription(), Color.RED, Color.BLACK));
            }
            else if(fieldList.atIndex(i) instanceof Properties) {
                guiFields.add(new GUI_Street(((Properties) fieldList.atIndex(i)).getFieldName(), ((Properties) fieldList.atIndex(i)).getFieldDescription(), ((Properties) fieldList.atIndex(i)).getFieldDescription(), "pris metode", Color.RED, Color.BLACK));
            }
            else if(fieldList.atIndex(i) instanceof FieldInfo && ((FieldInfo)fieldList.atIndex(i)).getFieldName().equals("visit")) {
                guiFields.add(new GUI_Refuge("default",((FieldInfo) fieldList.atIndex(i)).getFieldName(), ((FieldInfo) fieldList.atIndex(i)).getFieldDescription(), ((FieldInfo) fieldList.atIndex(i)).getFieldDescription(), Color.RED, Color.BLACK));
            }
            else if(fieldList.atIndex(i) instanceof FieldInfo && ((FieldInfo)fieldList.atIndex(i)).getFieldName().equals("parking")) {
                guiFields.add(new GUI_Refuge("default",((FieldInfo) fieldList.atIndex(i)).getFieldName(), ((FieldInfo) fieldList.atIndex(i)).getFieldDescription(), ((FieldInfo) fieldList.atIndex(i)).getFieldDescription(), Color.RED, Color.BLACK));
            }

        }
        return  guiFields.returnArray();
    }
        //Updates GUI_Player according to corresponding Player
        public void updateGUIPlayerPos(Player player, int oldPosition,int newPosition){

            for (int i = 0; i < GuiPlayers.listLength(); i++) {
                if(GuiPlayers.atIndex(i).getName().equals(player.getName())){
                    gui.getFields()[oldPosition].setCar(GuiPlayers.atIndex(i), false);
                    gui.getFields()[newPosition].setCar(GuiPlayers.atIndex(i), true);

                }
            }

        }

        public GUI_Player getGuiPlayer(int playerNumber){
        return GuiPlayers.atIndex(playerNumber);
        }

        public GUI getGUI(){return this.gui;}

}
