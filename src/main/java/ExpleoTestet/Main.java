package ExpleoTestet;

public class Main {

    public static void main(String[] args) {
	AnagramFinder af = new AnagramFinder();
        System.out.println(af.findAnagram("Tjenna","tjabba"));
        System.out.println(af.findAnagram("Tjenna","Tjanne"));
    }
}
