package ExpleoTestet;


import java.awt.*;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) {
calci();
    }

   static void calci() {
        String mathstring = "2-3*4";
       ArrayList expression = new ArrayList();
       for (int i = 0; i < mathstring.length(); i++) {
           expression.add(mathstring.charAt(i));
       }


    }

    int recursiveLexParse(int first,ArrayList rest){
if (Character.isDigit((char)rest.get(0)));{
    first = first*10+(int)rest.get(0);
            rest.remove(0);
        }



    }
}