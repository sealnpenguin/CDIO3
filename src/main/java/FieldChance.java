public class FieldChance extends Field {
    public FieldChance(String fieldName, String fieldDescription){
        super(fieldName, fieldDescription);
        //Field.getFieldName() = fieldName;// "Chance";
        fieldName = "Chance";
        fieldDescription = "Tag et chancekort";

    }

    /*public String setFieldName() {
        fieldName = "Chance";
        return fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }*/

    public void takeChanceCard(){

    }
}
