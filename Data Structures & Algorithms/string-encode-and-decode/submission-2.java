class Solution {
    private String delimiter = "`";

    public String encode(List<String> strs) {
        if (strs.size() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i));
            if (i != strs.size() - 1){
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null){
            return List.of();
        }
        
        return List.of(str.split(delimiter));
    }
}
