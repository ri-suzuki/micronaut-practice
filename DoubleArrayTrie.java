import java.util.*;

class DoubleArrayTrie {
    private static final int INITIAL_SIZE = 1000;  // 初期配列サイズ
    private static final int BASE_ROOT = 1;  // ルートノードの初期BASE値
    private static final int UNUSED = -1;  // 未使用を示す値

    private int[] base;
    private int[] check;
    private int size;

    public DoubleArrayTrie() {
        base = new int[INITIAL_SIZE];
        check = new int[INITIAL_SIZE];
        Arrays.fill(base, UNUSED);
        Arrays.fill(check, UNUSED);
        base[0] = BASE_ROOT;
        size = 1;
    }

    // 単語をトライに挿入するメソッド
    public void insert(String word) {
        int node = 0;  // ルートノードから開始
        for (char c : word.toCharArray()) {
            int code = c - 'a' + 1;  // a=1, b=2, c=3, ...
            int next = base[node] + code;

            if (next >= size) {
                resize(next + 1);
            }

            if (check[next] == UNUSED) {  // 未使用なら新しいノードを作成
                base[next] = 1;  // 初期値（他の文字に変える必要があるかもしれません）
                check[next] = node;
            }

            node = next;
        }
        base[node] = -1;  // 終端を示すための値（他の文字に変える必要があるかもしれません）
    }

    // 単語をトライから検索するメソッド
    public boolean search(String word) {
        int node = 0;
        for (char c : word.toCharArray()) {
            int code = c - 'a' + 1;
            int next = base[node] + code;

            if (next >= size || check[next] != node) {
                return false;
            }

            node = next;
        }
        return base[node] == -1;  // 終端かどうか確認
    }

    // 配列を拡張するメソッド
    private void resize(int newSize) {
        base = Arrays.copyOf(base, newSize);
        check = Arrays.copyOf(check, newSize);
        Arrays.fill(base, size, newSize, UNUSED);
        Arrays.fill(check, size, newSize, UNUSED);
        size = newSize;
    }

    public static void main(String[] args) {
        DoubleArrayTrie trie = new DoubleArrayTrie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        System.out.println(trie.search("cat"));  // true
        System.out.println(trie.search("car"));  // true
        System.out.println(trie.search("dog"));  // true
        System.out.println(trie.search("cow"));  // false
    }
}
