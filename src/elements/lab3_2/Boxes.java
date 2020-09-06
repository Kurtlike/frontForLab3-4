package elements.lab3_2;

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
        functions.put("f(x)=2x+3","linearFunction");
        functions.put("f(x)=-x^2","quadraticFunction");
        functions.put("f(x)=-(x-20)^2","quadraticFunctionTwo");
        functions.put("f(x)=x^3","cubicalFunction");
        functionChoose.getItems().addAll(functions.keySet());
    }
    public void setSelectedFunction(){
        functionChoose.setOnAction(actionEvent -> selectedFunction=functions.get(functionChoose.getValue()));
    }
    public String getSelectedFunction(){
        return selectedFunction;
    }
}
