package model;

public class Model {
    public void loadDataFromBinaryFile() {
        
        try {
            Persona.createPersonaFromString("Jesus,Parejo,Pineda,137",",");
        } catch (MyCustomException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
