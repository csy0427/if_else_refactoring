package main;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class NumberRefactoring {

    private static final Map<String ,BiFunction<NumberRefactoring,NumberRefactoring,NumberRefactoring>> operators=new HashMap<>();

    static{
        operators.put("+",(a,b)->new NumberRefactoring(a.no+b.no));
        operators.put("-",(a,b)->new NumberRefactoring(a.no-b.no));
        operators.put("*",(a,b)->new NumberRefactoring(a.no*b.no));
        operators.put("/",(a,b)->new NumberRefactoring(a.no/b.no));
    }

    private int no;

    public int getNo() {
        return no;
    }

    public NumberRefactoring(int no){ this.no =no; }

    public NumberRefactoring calculate(String expression, NumberRefactoring number){
        BiFunction<NumberRefactoring,NumberRefactoring,NumberRefactoring> operator=operators.get(expression);
        if(operator==null){
            throw new IllegalArgumentException();
        }
        return operator.apply(this,number);
    }

}
