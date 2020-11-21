package Fields;

public class FieldStart extends Field{
    //Starting field
    private int fieldValue = 2; // Skal det være -2, fordi man modtager pengene?

    public FieldStart(){
       super("Start", "Modtag 2M når du passerer start");

    }

    //public static String getFieldName() {
    //    return fieldName;
    //}

    //public static String getFieldDescription() {
    //    return fieldDescription;
    //}

    public int getFieldValue() {
        return fieldValue;
    }
}