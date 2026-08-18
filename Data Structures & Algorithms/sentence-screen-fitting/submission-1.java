class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
      int currentWordIndex = 0;
      int cycle = 0;
      for(int i=0;i<rows;i++){
        int j = 0;
        while(j<cols){
            // check for cycle complete
            if(currentWordIndex == sentence.length){
                cycle++;
                currentWordIndex = 0;
            }
            int endOfWord = j + sentence[currentWordIndex].length() - 1;
            if(endOfWord < cols){
                currentWordIndex++;
                j=endOfWord+2;
            }else{
                break;
            }
        }
      }

      // check for cycle complete
      if(currentWordIndex == sentence.length){
                cycle++;
                currentWordIndex = 0;
        }
      return cycle;
    }
}
