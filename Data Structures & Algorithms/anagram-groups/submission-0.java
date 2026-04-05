class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i= 0; i < strs.length; i++){
             char[] temp = strs[i].toCharArray();
              Arrays.sort(temp);
             String st = new String(temp);
             if (Objects.isNull(map.get(st))){
                map.put(st, new ArrayList<>());
             }
             map.get(st).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list  : map.values()){
            result.add(list);
        }
        return result;
    }
}
