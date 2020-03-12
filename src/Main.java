import cards.FileReader1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        Map<String, String> mapCards = FileReader1.getMap();

        Object[] objects = mapCards.keySet().toArray();
        Object[] objects1 = mapCards.values().toArray();

        for (int i = 0; i < objects.length; i++) {
            System.out.println("Напишите перевод \"" + objects[i] + "\"");

            String next = in.next();
            if (next.equals(objects1[i])) {
                System.out.println("Правильно.");
            } else {
                System.out.print("Неправильно. Ответ \""
                        + objects1[i] + "\" а твое слово будет" +
                        " \"");

                Optional<String> result = mapCards.entrySet()
                        .stream()
                        .filter(entry -> ((Object) next).equals(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .findFirst();
                result.ifPresent(System.out::print);
                System.out.println("\"");
            }
        }

    }

    private static String getStringCard(Scanner in) {
        return in.next();
    }

    private static void isKeyExists(String key, HashMap<String, String> map) {
        if (map.containsKey(key)) {
            System.out.println("Такая карточка уже есть. Введи другую:");
            key = getStringCard(in);
            isKeyExists(key, map);
        }
    }

    private static void isValueExists(String val, HashMap<String, String> map) {
        if (map.containsValue(val)) {
            System.out.println("Такое определение уже есть. Давай другое:");
            val = getStringCard(in);
            isValueExists(val, map);
        }
    }

    private static void showCards(HashMap<String, String> mapCards) {
        mapCards.forEach((e, k) -> {
            System.out.println(e + " " + k);
        });
    }
}
