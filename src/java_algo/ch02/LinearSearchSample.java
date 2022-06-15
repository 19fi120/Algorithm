package java_algo.ch02;

public class LinearSearchSample {
	/**
     * リニアサーチの実装
     */
    public static int execute(int[] data, int target) {
        int notfound = -1; // 見つからなかった場合の戻り値
        for(int i = 0; i < data.length; i++) {
          if (data[i] == target) {
              return i; // 配列のインデックスを返す
          }
        }
        return notfound; 
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5}; // 配列
        int result;
        // ``3''を持っているインデックスを探す
        result = LinearSearchSample.execute(data, 3);
        if (result != -1) {
            System.out.println("Found: index key = " + result);
        } else {
            System.out.println("Not found.");
        }
    }
}
