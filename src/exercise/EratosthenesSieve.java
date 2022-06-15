package exercise;

//エラトステネスのふるい
public class EratosthenesSieve {
	public static void main(String[] args){
		//  nまでの数の素数を表示する
		int N = 1000, i, k, n, m;
		int data[] = new int[N + 1];     //配列の生成
		int result[] = new int[N + 1];     //配列の生成
		
		//  配列の要素に1を入れる
		for(i = 2; i <= N; i++) {
			data[i] = 1; // i++はi=i+1と同じ意味
		}
		//  0と1は、最初から除外する
        data[0] = 0;
        data[1] = 0;
        n = 0;
        m = 0;
		
        //  素数の倍数をリストから削除する
		for(i = 2; i <= N; i++) {
		  if(data[i] == 1){
			  m = i;
		      System.out.print(i+" ");
		      for(k = 2; i * k <= N; k++) {
		    	  data[i * k] = 0;
		      }
		      //  結果を格納
		      result[n] = m;
		      n++;
		  }
		}
		System.out.println();
		for(n = 0; n < result.length; n++) {
			System.out.print(result[n] + " ");
		}
	}
}
