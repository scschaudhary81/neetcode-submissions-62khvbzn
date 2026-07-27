class Leaderboard {
    // HashMap
    // Sorted List of player ids
    HashMap<Integer,Integer> playerScoreMapping;
    List<Integer> playerIds;

    private void refresh(){
        Collections.sort(playerIds,(a,b)-> playerScoreMapping.get(b)-playerScoreMapping.get(a));
    }
    public Leaderboard() {
        playerScoreMapping = new HashMap<>();
        playerIds = new ArrayList<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!playerScoreMapping.containsKey(playerId)){
            playerIds.add(playerId);
            playerScoreMapping.put(playerId,score);
        }else{
            int prevScore = playerScoreMapping.get(playerId);
            playerScoreMapping.put(playerId,score + prevScore);
        }
    }
    
    public int top(int k) {
        refresh();
        int top_sum = 0;
        for(int playerId : playerIds){
            if(k == 0) break;
            else{
                k--;
                top_sum+=playerScoreMapping.get(playerId);
            }
        }
        return top_sum;
    }
    
    public void reset(int playerId) {
        playerScoreMapping.put(playerId,0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
