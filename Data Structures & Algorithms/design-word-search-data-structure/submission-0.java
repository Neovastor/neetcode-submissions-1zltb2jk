class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        Trie cur = this.trie;
        for (int i = 0; i < word.length(); i++){
            char ch =  word.charAt(i);
            if (cur.map.get(ch) == null){
                cur.map.put(ch, new Trie());
            }
            
            cur = cur.map.get(ch);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(this.trie, word, 0);
    }

    public boolean dfs(Trie cur, String word, int index){
        if (word.length() == index){
            return cur.isWord;
        }
        char ch = word.charAt(index);
        
        if (ch == '.'){
            
            for (Trie child : cur.map.values()){
                if (dfs(child, word, index + 1)){
                    return true;
                }
            }
        }
        Trie child = cur.map.get(ch);
        if (child == null){
            return false;
        }
        return dfs(child, word, index +1);
    }

}

public class Trie{
    public Map<Character, Trie> map;
    public boolean isWord;
    
    public Trie() {
        this.map = new HashMap<>();        
    }

}
