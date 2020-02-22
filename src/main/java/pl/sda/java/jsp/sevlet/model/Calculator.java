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
        resetOperandA();
        resetOperantB();
        operator = Operator.EMPTY;
    }

    private void resetOperandA() {
        operandA = "";
    }

    private void resetOperantB() {
        operandB = "";
    }

    public void calculate() {
        switch (operator) {
            case EMPTY:
                break;
            case DIV:
                break;
            case PLUS:
                operandA = "" + (Integer.valueOf(operandA)
                        + Integer.valueOf(operandB));
                operator = Operator.EMPTY;
                resetOperantB();
                break;
            case MINUS:
                break;
            case MULTI:
                break;
                default: throw new IllegalStateException("Invalid operator " + operator);
        }
    }

    public void operator(String value) {
        if(operator != Operator.EMPTY){
            calculate();
        }
        for(Operator operator: Operator.values()){
            if(operator.displayValue.equals(value)){
                this.operator = operator;
                return;
            }
        }
        throw new IllegalArgumentException("Illegal value " + value);
    }
}
