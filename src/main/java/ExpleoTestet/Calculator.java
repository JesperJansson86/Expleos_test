package ExpleoTestet;

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

    /**
     * calculatorLvl1 är väldigt simplel. Letar upp första förekomsten av en icke siffra och sparar den. Parsar sedan
     * det som är till vänster och höger om denna i stängen till doubles, kollar senare
     * @param input String
     * @return Double
     * @throws Exception
     */
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
        double operand2 = Double.parseDouble(input.substring(operatorlocation + 1));
        if (operator == '+') return operand1 + operand2;
        if (operator == '-') return operand1 - operand2;
        if (operator == '*') return operand1 * operand2;
        if (operator == '/') return operand1 / operand2;

        else throw new Exception("Hur lyckades du komma hit?");

    }

//jag insåg att jag borde bryta ut koden ovan och ha det som en egen metod så metoden har vi här under men
    // jag sparade koden ovan för att ni skulle kunna se min process.
    double evaluate(Double operand1, char operator, Double operand2) throws Exception {
        if (operator == '+') return operand1 + operand2;
        if (operator == '-') return operand1 - operand2;
        if (operator == '*') return operand1 * operand2;
        if (operator == '/') return operand1 / operand2;
        else throw new Exception("Incorrect Operator");
    }


    /**
     * calculatorLvl2 klarar av att ha flera operatorer men kan inte prioritera mellan dem utan tar de bara i tur och
     * ordning som de kommer.
     * @param input
     * @return Double
     * @throws Exception
     */
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

    /**
     * calculatorLvl3 kan ta en sträng med godtyckligt många operatorer, kommer att prioritera multiplikation och division
     * högst (och av dem så är det högre prio ju tidigare en kommer)
     * för att sedan köra addition och subtraktion.
     * @param input
     * @return
     * @throws Exception
     */
    double calculatorLvl3(String input) throws Exception {
        ArrayList operators = new ArrayList();
        ArrayList operands = new ArrayList();
        ArrayList removeoperators = new ArrayList();
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
        int index = 0;
        for (var operator : operators
        ) {
            if ((char) operator == '*') {
                double temp = (double) operands.get(index) * (double) operands.get(index + 1); //Lägger ihop talen på varsin sida om operatorn
                operands.remove(index); //tar bort det gamla talet
                operands.remove((index)); //tar bort det andra gamla talet
                operands.add(index, temp); //lägger in summan av de borttagna talen
                removeoperators.add(index); // en kan inte ta bort saker från en lista som itereras utöver så vi sparar indexet här och tar bort det senare
            } else if ((char) operator == '/') {
                double temp = (double) operands.get(index) / (double) operands.get(index + 1);
                operands.remove(index);
                operands.remove((index));
                operands.add(index, temp);
                removeoperators.add(index);
            } else index++;
        }
        for (var usedoperator : removeoperators//här tar vi bort alla redan använda operatorer
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