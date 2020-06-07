class Trie {
    //实现Trie
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pre = root;
        for (int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if (pre.links[c - 'a'] == null){
                pre.links[c - 'a'] = new TrieNode();
            }
            pre = pre.links[c - 'a'];  //指向当前节点
        }
        pre.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //从根出发
        TrieNode target = this.root;
        for (int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if (target.links[ch - 'a'] == null){
                return false;
            }
            target = target.links[ch - 'a'];
        }
        return target.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode target = this.root;
        for (int i = 0;i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if (target.links[ch - 'a'] == null){
                return false;
            }
            target = target.links[ch - 'a'];
        }
        return true;
    }


}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
        isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
