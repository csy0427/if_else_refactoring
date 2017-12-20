package main;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toMap;

public class NumberRefactoring1 {

    private int no;

    public NumberRefactoring1(int no){this.no=no;}

    public NumberRefactoring1 calculate(String expression, NumberRefactoring1 number){
        return Calculation.findCalculation(expression).calculate(this, number);
    }

    public int getNo() { return no; }

    private enum Calculation{
        ADDITION("+", (number1, number2) -> number1 + number2),
        SUBTRACTION("-", (number1, number2) -> number1 - number2),
        MULTIPLICATION("*", (number1, number2) -> number1 * number2),
        DIVISION("/", (number1, number2) -> number1 / number2);

        private String expression;
        private BiFunction<Integer,Integer,Integer> calculator;
        ///arrays to map
        private static Map<String, Calculation> calculationMap= Arrays.stream(Calculation.values()).collect(toMap(o -> o.expression,o->o));

        Calculation( String expression, BiFunction<Integer,Integer,Integer> calculator ){
            System.out.println("constructor");
            System.out.println("expression : " + expression + ", calculator : " + calculator);
            this.expression=expression;
            this.calculator=calculator;
        }

        private NumberRefactoring1 calculate(NumberRefactoring1 number1,NumberRefactoring1 number2){
            System.out.println("calculate");
            return new NumberRefactoring1(this.calculator.apply(number1.no,number2.no));
        }

        private static Calculation findCalculation(String expression){
            System.out.println("findCalculation");
            return Optional.ofNullable(calculationMap.getOrDefault(expression,null)).orElseThrow(IllegalArgumentException::new);
        }
    }
}
