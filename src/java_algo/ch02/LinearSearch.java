package java_algo.ch02;

//線形探索法（リニアサーチ）
//リニアサーチ計算量:オーダーO(n)
public class LinearSearch {

    /*
     * tableのentry
     */
    static private class Entry {

        int key;
        Object data;

        /**
         *generate entry
         * @param key 
         * @param data 
         */
        private Entry(int key, Object data){
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 100;         // dataの最大個数
    Entry[] table = new Entry[MAX];     
    int n = 0;                          // table に登録されているデータの個数

    /*
     * データを登録する
     *
     * @param key 
     * @return data
     */
    public void add(int key, Object data){
        if (n >= MAX) {
            throw new IllegalStateException("データの個数が多すぎます");
        }
        table[n++] = new Entry(key, data);
    }

    /*
     * キーに対応するデータを探す
     *
     * @param key 
     * @return data
     */
    public Object search(int key){
        int i = 0;                        
        while (i < n) {                   
            if (table[i].key == key)      
                return (table[i].data);   
            i++;                          
        }
        return null;                      
    }
}
