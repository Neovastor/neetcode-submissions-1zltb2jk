class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] chArr;
        for (int i= 0; i < strs.length; i++){
             chArr = new char[26];
             for (Character ch: strs[i].toCharArray()){
                chArr[ch - 'a']++;
             }
             
             String st = Arrays.toString(chArr);
             if (Objects.isNull(map.get(st))){
                map.put(st, new ArrayList<>());
             }
             map.get(st).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
