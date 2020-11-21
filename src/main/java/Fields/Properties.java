package Fields;

import Fields.Field;

public class Properties extends Field {
    String fieldColor;
    String ownedBy;
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
    public String getOwnedBy() {
        return ownedBy;
    }
}
