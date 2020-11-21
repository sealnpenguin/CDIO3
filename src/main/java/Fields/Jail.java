package Fields;

import Fields.Field;

public class Jail extends Field {
    // Fields.Jail field

    private String occupiedBy;

    public Jail(String fieldName, String fieldDescription, String occupiedBy){
        super(fieldName, fieldDescription);
        this.occupiedBy = occupiedBy;
        this.fieldName = "Fængsel";
        this.fieldDescription = "Gå i fængsel";
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public String getOccupiedBy() {
        return occupiedBy;
    }
}