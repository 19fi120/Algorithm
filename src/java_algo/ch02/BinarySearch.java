package java_algo.ch02;

//二分探索法（バイナリーサーチ）
//バイナリサーチ計算量:オーダーO(log_2 n)
public class BinarySearch {

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
     * キーに対応するデータを探す
     *
     * @param key 
     * @return data
     */
    public Object search(int key){
        int low = 0;                            
        int high = n - 1;                       

        while (low <= high) {                   
            int middle = (low + high) / 2;      
            if (key == table[middle].key)       
                return table[middle].data;      
            else if (key < table[middle].key)   
                high = middle - 1;              
            else // key > table[middle].key 
                low = middle + 1;               
        }
        return null;                            
    }
}
