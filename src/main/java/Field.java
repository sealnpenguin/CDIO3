public abstract class Field {

    protected static String fieldName;
    protected static String fieldDescription;
    //int fieldValue = 1;

    public Field(String fieldName, String fieldDescription){
        this.fieldName = fieldName;
        this.fieldDescription = fieldDescription;
    }
    public static String getFieldName() {
        return fieldName;
    }

    public static String getFieldDescription() {
        return fieldDescription;
    }

}
