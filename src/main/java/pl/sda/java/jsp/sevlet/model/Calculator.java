package pl.sda.java.jsp.sevlet.model;

public class Calculator {

    private String operandA = "";
    private String operandB = "";
    private Operator operator = Operator.EMPTY;

    public enum Operator {
        PLUS("+"), MINUS("-"), MULTI("*"), DIV("/"), EMPTY("");

        private String displayValue;

        Operator(String s){
            displayValue = s;
        }
    }

    public String display() {
        return operandA + operator.displayValue + operandB;
    }

    public void input(String value) {
        if(operator == Operator.EMPTY){
            operandA += value;
        }else {
            operandB += value;
        }
    }

    public void reset() {
        operandA = "";
        operandB = "";
        operator = Operator.EMPTY;
    }

    public void calculate() {

    }

    public void operator(String value) {
        for(Operator operator: Operator.values()){
            if(operator.displayValue.equals(value)){
                this.operator = operator;
                return;
            }
        }
        throw new IllegalArgumentException("Illegal value " + value);
    }
}
