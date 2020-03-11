package cards;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileReader1 {
    public  static Map<String, String> zipToMap(Set<String> keys, Set<String> values) {
        Iterator<String> keyIter = keys.iterator();
        Iterator<String> valIter = values.iterator();
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(_i -> keyIter.next(), _i -> valIter.next()));
    }
    public static Map<String, String> getMap() throws IOException {

        Set<String> words = new LinkedHashSet<>();
        Set<String> translate = new LinkedHashSet<>();
        FileReader fr = new FileReader("myFile.txt");
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            String[] s2 = s.split(" ");

            for (int i = 0; i < s2.length; i++) {
                if (i % 2 == 0) {
                    words.add(s2[i]);
                } else {
                    translate.add(s2[i]);
                }
            }
        }

        return zipToMap(words, translate);
    }
}
