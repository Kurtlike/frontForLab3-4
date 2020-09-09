package elements.lab4;

import javafx.scene.control.ChoiceBox;

import java.util.HashMap;

public class Boxes {
    private final ChoiceBox<String> functionChoose;
    private final ChoiceBox<String> methodChoose;
    private HashMap<String,String> functions= new HashMap<>();
    private HashMap<String,String> methods= new HashMap<>();
    private String selectedFunction;
    private String selectedMethod;
    public Boxes(ChoiceBox<String> functionChoose,ChoiceBox<String> methodChoose){
        this.functionChoose=functionChoose;
        this.methodChoose=methodChoose;
        setChoiceBox();
        setSelectedFunction();
        setSelectedMethod();
    }
    private void setChoiceBox(){
        functions.put("y'=y+(1+x)*y^2","default");
        functions.put("x*y'-y/x=0","first");
        functions.put("y'*y^2+2*x=1","second");
        methods.put("Метод Милна","milnesMethod");
        methods.put("Метод Адамса","adamsMethod");
        methods.put("Метод Рунге-Кутта","rungeKuttaMethod");
        methodChoose.getItems().addAll(methods.keySet());
        functionChoose.getItems().addAll(functions.keySet());
    }
    public void setSelectedFunction(){
        functionChoose.setOnAction(actionEvent -> selectedFunction=functions.get(functionChoose.getValue()));
    }

    public void setSelectedMethod() {
        methodChoose.setOnAction(actionEvent -> selectedMethod=methods.get(methodChoose.getValue()));
    }

    public String getSelectedMethod() {
        return selectedMethod;
    }

    public String getSelectedFunction(){
        return selectedFunction;
    }
}
