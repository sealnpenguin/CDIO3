package Fields;

public abstract class Field {

    String fieldName;
    String fieldDescription = "";
    //int fieldValue = 1;

    //public Fields.Field(String fieldName){
    //    this.fieldName = fieldName;
    //}
    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription(){
        return fieldDescription;
    }
}
