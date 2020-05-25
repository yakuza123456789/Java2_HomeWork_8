package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("Большой", new String[]{"Огромный", "Громадный", "Великий", "Колосальный"});
        dictionary.put("Человек", new String[]{"Персона", "Субъект", "Личность", "Гражданин"});
        dictionary.put("Красивый", new String[]{"Привлекательный", "Обоятельный", "Симпатичный", "Миловатый"});
        dictionary.put("Дом", new String[]{"Хата", "Жилище", "Убежище", "Вилла"});

        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);
        Set<String > keys = dictionary.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String [] values = dictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i < values.length; i++) {
                String newKeys = values[i];
                ArrayList<String> stringArrayList = new ArrayList<>(values.length);
                stringArrayList.addAll(Arrays.asList(values));
                stringArrayList.remove(newKeys);
                stringArrayList.add(key);
                String [] newValues = new String[stringArrayList.size()];
                newValues = stringArrayList.toArray(newValues);
                System.out.println(newKeys + " - " + Arrays.toString(values));
                bigDictionary.put(newKeys, newValues);
            }
        }

        System.out.println("__________");


        System.out.println("Введите любое слово словаря");

        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = dictionary.get(words[i]);
            if (synonyms != null) {
                Random random = new Random();
                int randomIndex = random.nextInt(synonyms.length);
                System.out.println(synonyms[+randomIndex]);
            } else {
                System.out.print("Слово не найдено ");
            }
        }

    }
}
