/*
Store key in hash map and store values with key as time in list and in this list find the max value <= time by binary search
*/

class TimeMap {
    class Pair{
        int time;
        String value;
        Pair(int time,String value){
            this.time = time;
            this.value = value;
        }
    }
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int time) {
        List<Pair> list = map.getOrDefault(key,new ArrayList<Pair>());
        Pair pair = new Pair(time,value);
        list.add(pair);
        map.put(key,list);
    }
    
    public String get(String key, int time) {
            List<Pair> list =  map.get(key);
            String result = "";
            if(list == null) return result;



            int start = 0;
            int end = list.size()-1;
            while(start<=end){
                int mid = start + (end-start)/2;
                Pair  temp = list.get(mid);
                if(temp.time == time){
                    result = temp.value;
                    break;
                }else if(time < temp.time){
                    end = mid-1;
                }else{
                    result = temp.value;
                    start = mid+1;
                }
            }


            return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */