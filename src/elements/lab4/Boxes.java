package elements.lab4;

import javafx.scene.control.ChoiceBox;

import java.util.HashMap;

public class Boxes {
    private final ChoiceBox<String> functionChoose;
    private HashMap<String,String> functions= new HashMap<>();
    private String selectedFunction;
    public Boxes(ChoiceBox<String> functionChoose){
        this.functionChoose=functionChoose;
        setChoiceBox();
        setSelectedFunction();
    }
    private void setChoiceBox(){
        functions.put("y'=y+(1+x)*y^2","default");

        functionChoose.getItems().addAll(functions.keySet());
    }
    public void setSelectedFunction(){
        functionChoose.setOnAction(actionEvent -> selectedFunction=functions.get(functionChoose.getValue()));
    }
    public String getSelectedFunction(){
        return selectedFunction;
    }
}
