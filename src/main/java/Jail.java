public class Jail extends Field{
    // Jail field

    private String occupiedBy;

    public Jail(String fieldName, String fieldDescription, String occupiedBy){
        super(fieldName, fieldDescription);
        this.occupiedBy = occupiedBy;
        this.fieldName = "Jail";
        this.fieldDescription = "In jail or visiting";
    }

    /*public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }*/

    public String getOccupiedBy() {
        return occupiedBy;
    }
}