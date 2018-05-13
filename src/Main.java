import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        String str = "ThereAreManyRepeatedCharactersInThisString";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(str);

        }
        stringBuilder.append("X");
        str = stringBuilder.toString();

        long start = System.currentTimeMillis();
        final int length = str.length();
        for (int i = 0; i < length; i++) {
            final char c = str.charAt(i);
            boolean foundRepeated = false;
            for (int j = 0; j < length; j++) { // int j = i+1 will almost half the execution time
                final char c1 = str.charAt(j);
                if (i != j && c1 == c) {
                    foundRepeated = true;
                    //break;// could add break here
                }
            }
            if (!foundRepeated) {
                System.out.println("First non repeatable character in " + str + " is " + c);
                break;
            }
        }
        long processTime = System.currentTimeMillis() - start;
        System.out.println("O(n2) took : " + processTime + " milliseconds");

        start = System.currentTimeMillis();
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for (int i = 0; i < length; i++) {
            char aChar = str.charAt(i);
            if (ht.containsKey(aChar)) {
                ht.put(aChar, ht.get(aChar) + 1);
            } else {
                ht.put(aChar, 1);
            }
        }

        for (int i = 0; i < length; i++) {
            char aChar = str.charAt(i);
            if (ht.get(aChar) == 1) {
                System.out.println("First non repeatable character in " + str + " is " + aChar);
                break;
            }
        }
        processTime = System.currentTimeMillis() - start;
        System.out.println("O(n) took : " + processTime + " milliseconds");
    }
}
