import java.util.Arrays;

public class FieldsOnBoard {
    public static void fieldsOnBoard(){
        //Test
        //Jail j = new Jail();
        //j.fieldDescription = "This is jail";
        //System.out.println(j.fieldDescription);

        //Samtlige felter, inkl. beskrivelser, på brættet
        String[] allFields = new String[24];
        allFields[0] = Arrays.toString(new String[]{"Start", "Modtag 2M når du passerer start"});
        allFields[1] = Arrays.toString(new String[]{"Burgerbaren", "M1"});
        allFields[2] = Arrays.toString(new String[]{"Pizzahuset", "M1"});
        allFields[3] = Arrays.toString(new String[]{"Chance", "Tag et kort"});
        allFields[4] = Arrays.toString(new String[]{"Godtebutikken", "M1"});
        allFields[5] = Arrays.toString(new String[]{"Iskiosken", "M1"});
        allFields[6] = Arrays.toString(new String[]{"I fængsel", "På besøg"});
        allFields[7] = Arrays.toString(new String[]{"Museet", "M2"});
        allFields[8] = Arrays.toString(new String[]{"Biblioteket", "M2"});
        allFields[9] = Arrays.toString(new String[]{"Chance", "Tag et kort"});
        allFields[10] = Arrays.toString(new String[]{"Rullebrætparken", "M2"});
        allFields[11] = Arrays.toString(new String[]{"Svømmebassinet", "M2"});
        allFields[12] = Arrays.toString(new String[]{"Gratis", "Parkering"});
        allFields[13] = Arrays.toString(new String[]{"Spillehallen", "M3"});
        allFields[14] = Arrays.toString(new String[]{"Biografen", "M3"});
        allFields[15] = Arrays.toString(new String[]{"Chance", "Tag et kort"});
        allFields[16] = Arrays.toString(new String[]{"Legetøjsbutikken", "M3"});
        allFields[17] = Arrays.toString(new String[]{"Dyrehandlen", "M3"});
        allFields[18] = Arrays.toString(new String[]{"Gå i", "fængsel"});
        allFields[19] = Arrays.toString(new String[]{"Bowlinghallen", "M4"});
        allFields[20] = Arrays.toString(new String[]{"Zoologisk have", "M4"});
        allFields[21] = Arrays.toString(new String[]{"Chance", "Tag et kort"});
        allFields[22] = Arrays.toString(new String[]{"Vandlandet", "M5"});
        allFields[23] = Arrays.toString(new String[]{"Strandpromenaden", "M5"});

        //Forsøg på at hente attributter fra de forskellige klasser
        //allFields[3] = Arrays.toString(new String[]{FieldChance.getFieldName(), FieldChance.getFieldDescription()});

        System.out.println(Arrays.toString(allFields));
    }
}
