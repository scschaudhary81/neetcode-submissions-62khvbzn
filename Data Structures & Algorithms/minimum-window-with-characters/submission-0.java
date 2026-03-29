
class Solution {
    public boolean isEqual(HashMap<Character, Integer> one, HashMap<Character, Integer> two) {
        for (Map.Entry<Character, Integer> entry : one.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();
            if (two.getOrDefault(key, 0)<value)
                return false;
        }

        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int a = -1;
        int b = -1;
        int start = 0;
        int end = s.length();
        int min = Integer.MAX_VALUE;
        int current = 0;
        HashMap<Character, Integer> currentMap = new HashMap<>();

        while (current < end && start <= current) {
            char currentChar = s.charAt(current);
                currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);
                while(isEqual(map, currentMap)) {
                    char startChar = s.charAt(start);
                    if (min > (current - start + 1)) {
                        min = current - start + 1;
                        a = start;
                        b = current;
                    }
                    currentMap.put(startChar, currentMap.getOrDefault(startChar, 0) - 1);
                    start++;
                }
                current++;
            }
    return a==-1 ? "" : s.substring(a,b+1);
}}