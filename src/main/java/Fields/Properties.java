package Fields;

import Fields.Field;

public class Properties extends Field {
    private String fieldColor;
    private int ownedBy;
    // All ownable properties with a value and a color
    public Properties(){

        fieldName = "";
        fieldDescription = "";
        int fieldValue = 1;
        this.fieldColor = fieldColor;
        this.ownedBy = ownedBy;
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
}
