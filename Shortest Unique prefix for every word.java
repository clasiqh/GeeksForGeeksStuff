class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        
        Trie root = new Trie();
        String[] ans = new String[N];
        for(String str : arr)
            root.addWord(str);

        for(int i=0; i<N;i++)
            ans[i] = root.findMin(arr[i]);
            
        return ans;
    }
}

class Trie{
    
    class Node{
        boolean isWord = false;
        HashMap<Character, Node> child = new HashMap<>();
        int count = 0;
    }
    
    Node root = new Node();
    
    void addWord(String str){
        Node temp = root;
        for(char c : str.toCharArray()){
            if(!temp.child.containsKey(c))
                temp.child.put(c, new Node());
            temp = temp.child.get(c);
            temp.count++;
        }
        temp.isWord = true;
    }
    
    String findMin(String str){
        Node temp = root;
        for(int i=0; i<str.length();i++){
            if(temp.count==1)
                return str.substring(0,i);
            temp = temp.child.get(str.charAt(i));
        }
        return str;
    }
}
