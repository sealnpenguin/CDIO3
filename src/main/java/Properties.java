public class Properties extends Field {
    private String fieldColor;
    private int ownedBy;
    private int fieldValue;
    // All ownable properties with a value and a color
    public Properties(String fieldName, String fieldDescription, String fieldColor){
        super(fieldName, fieldDescription);
        //fieldName = "";
        //fieldDescription = "";
        this.fieldValue = fieldValue;
        this.fieldColor = fieldColor;
        this.ownedBy = -1;
    }

//    public String getFieldName() {
//        return this.fieldName;
//    }

    //public String getFieldDescription() {
    //    return fieldDescription;
    //}
    public int getFieldValue() {
        return this.fieldValue;
    }

    public String getFieldColor() {
        return this.fieldColor;
    }
    public int getOwnedBy() {
        return this.ownedBy;
    }
}
