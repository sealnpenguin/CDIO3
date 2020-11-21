package Fields;


import Player.Player;

public class Properties extends Field {
    private String fieldColor;
    private int ownedBy;
    private int price;
    // All ownable properties with a value and a color
    public Properties(String name, String description, String color,int value){
        super(name, description);
        this.fieldColor = color;
        this.price = value;
        this.ownedBy = -1;
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
    public int getFieldValue() {
        return getFieldValue();
    }

    public String getFieldColor() {
        return fieldColor;
    }
    public int getOwnedBy() {
        return ownedBy;
    }
    public void setOwnedBy(int ownerIndex){this.ownedBy = ownerIndex;}

    public int getPrice() {
        return price;
    }
}
