package ExpleoTestet;

import net.bytebuddy.implementation.bytecode.Throw;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;

public class Calculator {


    public static void main(String[] args) throws Exception {
        Calculator c1 = new Calculator();
        System.out.println(c1.calculatorLvl1("2/3"));
        System.out.println(c1.calculatorLvl3("2+3*40"));
        System.out.println(c1.calculatorLvl3("2*3+4"));
        System.out.println(c1.calculatorLvl3("2/3+4-1"));
        System.out.println(c1.calculatorLvl3("100+5*5/5*5"));

    }

    double calculatorLvl1(String input) throws Exception {
        char operator = 'f';
        int operatorlocation = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                operator = input.charAt(i);
                operatorlocation = i;
                break;
            }

        }
        if (operator == 'f') throw new NumberFormatException("Felakting input");
        double operand1 = Double.parseDouble(input.substring(0, operatorlocation));
        double operand2 = Double.parseDouble(input.substring(operatorlocation + 1, input.length()));
        if (operator == '+') return operand1 + operand2;
        if (operator == '-') return operand1 - operand2;
        if (operator == '*') return operand1 * operand2;
        if (operator == '/') return operand1 / operand2;

        else throw new Exception("Hur lyckades du komma hit?");

    }

    double evaluate(Double operand1, char operator, Double operand2) throws Exception {
        if (operator == '+') return operand1 + operand2;
        if (operator == '-') return operand1 - operand2;
        if (operator == '*') return operand1 * operand2;
        if (operator == '/') return operand1 / operand2;
        else throw new Exception("Incorrect Operator");
    }

    double calculatorLvl2(String input) throws Exception {
        ArrayList operators = new ArrayList();
        ArrayList operands = new ArrayList();
        //"2+30+4"
        int whereDoesOperandStart = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {

                operands.add(Double.parseDouble(input.substring(whereDoesOperandStart, i)));
                operators.add(input.charAt(i));
                whereDoesOperandStart = i + 1;
            }
        }
        operands.add(Double.parseDouble(input.substring(whereDoesOperandStart)));
        double total = (double) operands.get(0);
        for (var operator : operators
        ) {
            total = evaluate(total, (char) operator, (double) operands.get(1));
            operands.remove(0);
        }
        return total;
    }

    double calculatorLvl3(String input) throws Exception {
        ArrayList operators = new ArrayList();
        ArrayList operatorlocations = new ArrayList();
        ArrayList operands = new ArrayList();
        ArrayList removeoperators = new ArrayList();
        //"2+30+4"
        int whereDoesOperandStart = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {

                operands.add(Double.parseDouble(input.substring(whereDoesOperandStart, i)));
                operators.add(input.charAt(i));
                operatorlocations.add(i);
                whereDoesOperandStart = i + 1;
            }
        }
        operands.add(Double.parseDouble(input.substring(whereDoesOperandStart)));
        int index = 0;
        for (var operator : operators
        ) {
            if ((char) operator == '*') {
                double temp = (double) operands.get(index) * (double) operands.get(index + 1);
                operands.remove(index);
                operands.remove((index));
                operands.add(index, temp);
                removeoperators.add(index);
            } else if ((char) operator == '/') {
                double temp = (double) operands.get(index) / (double) operands.get(index + 1);
                operands.remove(index);
                operands.remove((index));
                operands.add(index, temp);
                removeoperators.add(index);
            } else index++;
        }
        for (var usedoperator : removeoperators
        ) {
            operators.remove((int) usedoperator);

        }
        removeoperators.clear();
        index = 0;
        for (var operator : operators
        ) {
            if ((char) operator == '+') {
                double temp = (double) operands.get(index) + (double) operands.get(index + 1);
                operands.remove(index);
                operands.remove((index));
                operands.add(index, temp);
                removeoperators.add(index);
            } else if ((char) operator == '-') {
                double temp = (double) operands.get(index) - (double) operands.get(index + 1);
                operands.remove(index);
                operands.remove((index));
                operands.add(index, temp);
                removeoperators.add(index);
            } else index++;
        }

        return (double) operands.get(0);
    }
}