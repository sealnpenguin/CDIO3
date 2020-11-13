public class Jail extends Field{
    // Jail field

    String occupiedBy = "";

    public Jail(){
        //super(fieldName, fieldDescription);
        //this.occupiedBy = occupiedBy;
        fieldName = "Jail";
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
