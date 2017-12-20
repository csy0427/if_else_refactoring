package main;

import java.util.regex.Pattern;

public class CodeRefactoringMain {
    public static void main(String args[]){

        String plus="+",minus="-",mul="*",div="/";

        NumberEnum plusEnum=NumberEnum.valueOf(String.valueOf(NumberEnum.ADD));
        NumberEnum minusEnum=NumberEnum.valueOf(String.valueOf(NumberEnum.SUB));
        NumberEnum mulEnum=NumberEnum.valueOf(String.valueOf(NumberEnum.MUL));
        NumberEnum divEnum=NumberEnum.valueOf(String.valueOf(NumberEnum.DIV));
        System.out.println(String.valueOf(NumberEnum.ADD));
        System.out.println(plusEnum.apply(1,2));
        System.out.println(minusEnum.apply(1,2));
        System.out.println(mulEnum.apply(1,2));
        System.out.println(divEnum.apply(1,2));

        ////////////////////////////////////////////////////////////////////////

        NumberRefactoring plusNumberRefactoring=new NumberRefactoring(1);


        NumberRefactoring tmpNumber=new NumberRefactoring(2);
        System.out.println(plusNumberRefactoring.calculate("+",tmpNumber).getNo());
        System.out.println(plusNumberRefactoring.calculate("-",tmpNumber).getNo());
        ////System.out.println(minusNumberRefactoring.calculate("-",minusNumberRefactoring));
       //// System.out.println(mulNumberRefactoring.calculate("*",mulNumberRefactoring));
        ///System.out.println(divNumberRefactoring.calculate("/",divNumberRefactoring));

        ////////////////////////////////////////////////////////////////////////////

        NumberRefactoring1 numberRefactoring1= new NumberRefactoring1(1);
        NumberRefactoring1 numberRefactoring2= new NumberRefactoring1(2);
        numberRefactoring1.calculate("+",numberRefactoring2);
        System.out.println(numberRefactoring1.calculate("+",numberRefactoring2).getNo());

    }
}
