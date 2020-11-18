import java.util.Arrays;

public class FieldsOnBoard {
    public static void fieldsOnBoard(){
        //Test
        //Jail j = new Jail();
        //j.fieldDescription = "This is jail";
        //System.out.println(j.fieldDescription);

        String[] allFields = new String[24];
        allFields[0] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[1] = Arrays.toString(new String[]{"", "Modtag 2M når du passerer start"});
        allFields[2] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[3] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[4] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[5] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[6] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[7] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[8] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[9] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[10] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[11] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[12] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});

        //allFields[3] = Arrays.toString(new String[]{FieldChance.getFieldName(), FieldChance.getFieldDescription()});
        System.out.println(Arrays.toString(allFields));
    }
}
