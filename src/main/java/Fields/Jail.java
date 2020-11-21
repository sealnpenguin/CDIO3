package Fields;

import Fields.Field;

public class Jail extends Field {
    // Fields.Jail field

    String occupiedBy = "";

    public Jail(){
        //super(fieldName, fieldDescription);
        //this.occupiedBy = occupiedBy;
        fieldName = "Fields.Jail";
        fieldDescription = "In jail or visiting";
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
