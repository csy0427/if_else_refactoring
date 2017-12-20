package main;

public enum NumberEnum {

    ADD("+") {
        @Override
        public double apply(double x1, double x2) throws IllegalArgumentException {
            return x1+x2;
        }
    },SUB("-") {
        @Override
        public double apply(double x1, double x2) throws IllegalArgumentException {
            return x1-x2;
        }
    },MUL("*") {
        @Override
        public double apply(double x1, double x2) throws IllegalArgumentException {
            return x1*x2;
        }
    },DIV("/") {
        @Override
        public double apply(double x1, double x2) throws IllegalArgumentException {
            return x1/x2;
        }
    };

    private final String textOperator;
    private  NumberEnum(String textOperator){ this.textOperator=textOperator; }
    public abstract double apply(double x1,double x2) throws IllegalArgumentException;
    public String getTextOperator(){ return textOperator; }


}
