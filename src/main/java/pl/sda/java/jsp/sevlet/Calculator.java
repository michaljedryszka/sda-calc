package pl.sda.java.jsp.sevlet;

public class Calculator {

    private String input = "";
    private String input2;
    private String operator;

    public String display(){
        return input;
    }

    public void input(String digit){
        input += digit;
    }

    public void add(){
        input2 = input;
        input = "";
        operator = "+";
    }

    public void substract(){
        input2 = input;
        input = "";
        operator = "-";
    }

    public void clear(){
        input = "";
    }

    public void evaluate(){
        if ("+".equals(operator)) {
            input = String.valueOf(Integer.valueOf(input) + Integer.valueOf(input2));
        }
        if ("-".equals(operator)) {
            input = String.valueOf(Integer.valueOf(input2) - Integer.valueOf(input));
        }
    }
}

// SOLID
// Single responsibility
// Open close
// Liskov
// Interfeace segregation
// Dependency inversion

/*
class prostokat {
    int x;
    int y;

    int pole(){
        return x*y;
    }
}

class kwadrat extends prostokat{
    int x;
    int pole(){
        return x*x;
    }
}

    public static void main(String[] args) {
        prostokat p = new prostokat();
        p.x = 3;
        p.y = 4;
        System.out.println(p.pole());

        kwadrat k = new kwadrat();
        k.x = 3;
        k.y = 4;
        System.out.println(k.pole());
    }
*/
