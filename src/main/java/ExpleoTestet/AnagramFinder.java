package ExpleoTestet;

import java.util.Arrays;

/**
 * findAnagram tar två strängar och kontrollerar ifall de innehåller samma uppsättning tecken (om det är
 * stora eller små bokstäver ignoreras.
 * ger en Boolean som svar.
 */
public class AnagramFinder {
    boolean findAnagram(String input1, String input2){
    return sortString(input1.toLowerCase()).equals(sortString(input2.toLowerCase()));
    }

    /**
     * sortString gör om en sträng till en char-Array som sorteras och görs till sträng igen som returneras.
     *
     */
    String sortString (String input){
        char[] parse = input.toCharArray();
        Arrays.sort(parse);
        return new String(parse);

    }
}
