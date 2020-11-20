import java.util.Arrays;

public class FieldsOnBoard {
    private Field[] fieldArr = new Field[24];

    public FieldsOnBoard(){

    }
    public void fieldsOnBoard() {
        //Test
        //Jail j = new Jail();
        //j.fieldDescription = "This is jail";
        //System.out.println(j.fieldDescription);

        //Samtlige felter, inkl. beskrivelser, på brættet
        String[][] allFields = new String[24][];
        allFields[0] = new String[]{"Start", "Modtag 2M når du passerer start"};
        allFields[1] = new String[]{"Burgerbaren", "M1"};
        allFields[2] = new String[]{"Pizzahuset", "M1"};
        allFields[3] = new String[]{"Chance", "Tag et kort"};
        allFields[4] = new String[]{"Godtebutikken", "M1"};
        allFields[5] = new String[]{"Iskiosken", "M1"};
        allFields[6] = new String[]{"I fængsel", "På besøg"};
        allFields[7] = new String[]{"Museet", "M2"};
        allFields[8] = new String[]{"Biblioteket", "M2"};
        allFields[9] = new String[]{"Chance", "Tag et kort"};
        allFields[10] = new String[]{"Rullebrætparken", "M2"};
        allFields[11] = new String[]{"Svømmebassinet", "M2"};
        allFields[12] = new String[]{"Gratis", "Parkering"};
        allFields[13] = new String[]{"Spillehallen", "M3"};
        allFields[14] = new String[]{"Biografen", "M3"};
        allFields[15] = new String[]{"Chance", "Tag et kort"};
        allFields[16] = new String[]{"Legetøjsbutikken", "M3"};
        allFields[17] = new String[]{"Dyrehandlen", "M3"};
        allFields[18] = new String[]{"Gå i fængsel", "fængsel"};
        allFields[19] = new String[]{"Bowlinghallen", "M4"};
        allFields[20] = new String[]{"Zoologisk have", "M4"};
        allFields[21] = new String[]{"Chance", "Tag et kort"};
        allFields[22] = new String[]{"Vandlandet", "M5"};
        allFields[23] = new String[]{"Strandpromenaden", "M5"};


        for (int i = 0; i < allFields.length; i++) {
            if(allFields[i][0].equals("Start")){
                this.fieldArr[i] = new FieldStart();
                String test = this.fieldArr[i].getFieldName();
                System.out.println(test + "FieldsOnBoard test");
            }
            else if(allFields[i][0].equals("Chance")){
                this.fieldArr[i] = new FieldChance();
                String test = this.fieldArr[i].getFieldName();
                System.out.println(test + "FieldsOnBoard test");
            }
            else if(allFields[i][0].equals("I fængsel") && allFields[i][0].equals("Gratis")){
                this.fieldArr[i] = new FieldInfo(allFields[i][0], allFields[i][1]);
                String test = this.fieldArr[i].getFieldName();
                System.out.println(test + "FieldsOnBoard test");
            }
            else if(allFields[i][0].equals("Gå i fængsel")){
                this.fieldArr[i] = new Jail("Fængsel", allFields[i][0], "test");
                String test = this.fieldArr[i].getFieldName();
                System.out.println(test + "FieldsOnBoard test");
            }
            else {
                this.fieldArr[i] = new Properties(allFields[i][0], allFields[i][1], "test color", "test");
                String test = this.fieldArr[i].getFieldName();
                System.out.println(test + "FieldsOnBoard test");

            }
        }

        //Forsøg på at hente attributter fra de forskellige klasser
        //allFields[3] = new String[]{FieldChance.getFieldName(), FieldChance.getFieldDescription()});


    }

    public Field[] getFieldArr(){
        return this.fieldArr;
    }
    public Field getFieldArrIndex(int index){
        return this.fieldArr[index];
    }
}

