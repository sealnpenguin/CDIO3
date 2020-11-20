public class Jail extends Field{
    // Jail field

    private String occupiedBy;

    public Jail(String fieldName, String fieldDescription, String occupiedBy){
        super(fieldName, fieldDescription);
        this.occupiedBy = occupiedBy;
        this.fieldName = "Jail";
        this.fieldDescription = "Gå i fængsel";
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