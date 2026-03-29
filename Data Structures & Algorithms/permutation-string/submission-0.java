class Solution {
    public boolean checkIfValid(HashMap<Character,Integer> mapOne,HashMap<Character,Integer> mapTwo){
        boolean result = true;
        for(Map.Entry<Character,Integer> entry: mapOne.entrySet()){
            result = result && mapTwo.getOrDefault(entry.getKey(),0) == entry.getValue();
        }
        return result;
    }

    
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> mapOne = new HashMap<>();
        HashMap<Character,Integer> mapTwo = new HashMap<>();
        int size = s1.length();
        for(char c: s1.toCharArray()) mapOne.put(c,mapOne.getOrDefault(c,0)+1);
        int start = 0;
        int current = -1;
        int currentSize = 0;
        int end = s2.length();

        while(current<end-1){
            current++;
            currentSize++;
            char c = s2.charAt(current);
            mapTwo.put(c,mapTwo.getOrDefault(c,0)+1);
            if(currentSize ==  size){
                System.out.println(currentSize);
                System.out.println(start+" "+current);
                if(checkIfValid(mapOne,mapTwo)) {
                    return true;
                }
                else{
                    char remove = s2.charAt(start);
                    mapTwo.put(remove,mapTwo.get(remove)-1);
                    currentSize--;
                    start++;
                }
            }
        }
        return false;
        
    }
}