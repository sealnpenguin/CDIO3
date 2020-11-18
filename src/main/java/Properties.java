public class Properties extends Field {
    private String fieldColor;
    private String ownedBy;
    private int fieldValue;
    // All ownable properties with a value and a color
    public Properties(String fieldName, String fieldDescription, String fieldColor, String ownedBy){
        super(fieldName, fieldDescription);
        //fieldName = "";
        //fieldDescription = "";
        this.fieldValue = fieldValue;
        this.fieldColor = fieldColor;
        this.ownedBy = ownedBy;
    }

    //public String getFieldName() {
    //    return fieldName;
    //}

    //public String getFieldDescription() {
    //    return fieldDescription;
    //}
    public int getFieldValue() {
        return fieldValue;
    }

    public String getFieldColor() {
        return fieldColor;
    }
    public String getOwnedBy() {
        return ownedBy;
    }
}
