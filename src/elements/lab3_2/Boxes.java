package elements.lab3_2;

import javafx.scene.control.ChoiceBox;

import java.util.HashMap;

public class Boxes {
    private final ChoiceBox<String> functionChoose;
    private final ChoiceBox<String> dataChoose;
    private HashMap<String,String> functions= new HashMap<>();
    private HashMap<String,String> datas= new HashMap<>();
    private String selectedFunction;
    private String selectedData;
    public Boxes(ChoiceBox<String> functionChoose,ChoiceBox<String> dataChoose){
        this.dataChoose=dataChoose;
        this.functionChoose=functionChoose;
        setChoiceBox();
        setSelectedFunction();
        setSelectedData();
    }
    private void setChoiceBox(){
        functions.put("f(x)=2x+3","linearFunction");
        functions.put("f(x)=-x^2","quadraticFunction");
        functions.put("f(x)=-(x-20)^2","quadraticFunctionTwo");
        functions.put("f(x)=x^3","cubicalFunction");
        datas.put("-11,-10,-8,-7,-6,-4,-3,-1,1,2,4,7,11","firstData");
        datas.put("6,8,10,15,16,17,20,21,26","secondData");
        datas.put("-20,-16,-15,-14,-12,-11,-10","thirdData");
        datas.put("стандартный набор","default");
        functionChoose.getItems().addAll(functions.keySet());
        dataChoose.getItems().addAll(datas.keySet());
    }
    public void setSelectedFunction(){
        functionChoose.setOnAction(actionEvent -> selectedFunction=functions.get(functionChoose.getValue()));
    }

    public String getSelectedFunction(){
        return selectedFunction;
    }

    public String getSelectedData() {
        return selectedData;
    }

    public void setSelectedData() {
        dataChoose.setOnAction(actionEvent -> selectedData=datas.get(dataChoose.getValue()));
    }
}
