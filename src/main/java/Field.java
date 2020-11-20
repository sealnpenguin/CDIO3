public abstract class Field {

    protected String fieldName;
    protected String fieldDescription;
    //int fieldValue = 1;

    public Field(String fieldName, String fieldDescription){
        this.fieldName = fieldName;
        this.fieldDescription = fieldDescription;
    }

    public String getFieldName() { return this.fieldName;}

    public String getFieldDescription() {
        return fieldDescription;
    }

}
