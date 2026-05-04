class PrefixTree {
    Tree root;


    public PrefixTree() {
        this.root = new Tree();
    }

    public void insert(String word) {
        Tree cur = this.root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (!cur.map.containsKey(ch)){
                Tree newTree = new Tree(ch);
                cur.map.put(ch, newTree);
            } 

            cur = cur.map.get(ch);

        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Tree cur = this.root;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (!cur.map.containsKey(ch)){
                return false;
            }
            cur = cur.map.get(ch);

        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Tree cur = this.root;

        for (int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (!cur.map.containsKey(ch)){
                return false;

            }
            cur = cur.map.get(ch);

        }
        return true;
    }
}

class Tree {
    public char value;
    public boolean isWord;
    public Map<Character, Tree> map = new HashMap<>();

    public Tree(char val){
        this.value = val;
    }

    public Tree(){
    }

}

