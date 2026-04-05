
class TimeMap {
    Map<String, List<Pair<String, Integer>> > map;
    public TimeMap() {
        this.map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair<String, Integer>(value, timestamp);     
        if (map.containsKey(key)){
            List<Pair<String, Integer>> temp = this.map.get(key);
            temp.add(pair);
        } else {
            List<Pair<String, Integer>> list =  new ArrayList<>();
            list.add(pair);
            this.map.put(key, list);
        }        
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        List <Pair<String, Integer>> list = map.get(key);
        
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List <Pair<String, Integer>> list, int target){
        int left = 0;
        int right = list.size() - 1;
        String result = "";
        while (left <= right){
            int middle = left + ((right - left) / 2);
            if (list.get(middle).getValue() <=  target){
                result = list.get(middle).getKey();
                left = middle + 1;
            } else {
                right = middle - 1;
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