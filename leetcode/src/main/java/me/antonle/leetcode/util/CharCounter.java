package me.antonle.leetcode.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCounter {

    public static Map<Character, Long> countCharacters(String text) {
        if (text == null) {
            return Collections.emptyMap();
        }
        return text
            .chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    }

    public static Map<Character, Long> countCharacters(Iterator<Character> iterator) {
        if (iterator == null) {
            return Collections.emptyMap();
        }
        Map<Character, Long> counter = new HashMap<>();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            Long i = counter.getOrDefault(character, 0L);
            counter.put(character, ++i);
        }
        return counter;
    }

}
