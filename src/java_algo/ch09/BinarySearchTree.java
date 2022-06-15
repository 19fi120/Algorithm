package java_algo.ch09;

//二分探索法（バイナリーサーチ）
//バイナリサーチ計算量:オーダーO(log_2 n)

/*
 * 二部探索木
 * 平衡木（balanced tree）
 * 木の形をなるべく完全二分木に近くなるようにした木
 * ex.)ALV木	すべての節において、左部分木と右部分木の高さの差が1以内でなければならない
 * 	   B木
 */
class BinarySearchTree
{
    private Node  root; // ルート

    public BinarySearchTree()
    {
        root = null;
    }

    //---------------------------------------------
    // メソッド定義
    //---------------------------------------------

    /**
     * 探索
     *
     * @param key  キー
     * @return  キーkeyを持った節が見つかればそれを返し、見つかれなければnullを返す
     */
    public Node search(Integer key)
    {
        Node p = root;                  // まず根に注目
        while (p != null) {             //注目している節がある限り続ける
                                        
            int result = key.compareTo(p.data);
            if (result == 0) {          // 節とキーが等しい、見つかった
                return p;               
            } else if (result < 0) {    // キーのほうが小さければ、左部分木に進む
                p = p.left;             
            } else {                    // キーのほうが大きければ、右部分木に進む
                p = p.right;            
            }
        }
        return null;                    // 探索失敗
    }

    /**
     * 挿入
     *
     * @param key  キー
     * @return  挿入したキーkeyを持つ節へのリンクを返し、すでに登録されていればnullを返す
     */
    public Node insert(Integer key)
    {
        Node p = root;                  // まず根に注目
        Node parent = null;             // parentは現在注目している節の親を指す
        boolean  isLeftChild = false;   // pがparentの左の子ならtrue、右の子ならfalse
                                        

        while (p != null) {             // 注目している節がある限り続ける
                                        
            int result = key.compareTo(p.data);
            if (result == 0) {          // 節とキーが等しければ、すでに登録されている
                return null;            
            } else if (result < 0) {    // キーのほうが小さければ、左部分木に進む
                parent = p;             
                isLeftChild = true;
                p = p.left;
            } else {                    // キーのほうが大きければ、右部分木に進む
                parent = p;             
                isLeftChild = false;
                p = p.right;
            }
        }

        // 新しい節を適切な場所に挿入
        Node newNode = new Node(key);   // 新しい節を割り当てる
        if (parent == null) {
            root = newNode;             // 新しい節は根になる
        } else if (isLeftChild) {
            parent.left = newNode;      // 節parentの左の子になる
        } else {
            parent.right = newNode;     // 節parentの右の子になる
        }

        return newNode;
    }

    /**
     * 二分探索木からキーkeyをもつ節を削除
     *
     * @param key  削除するキー
     * @return  削除に成功すればtrue、要素が存在すればfalseを返す
     */
    public boolean delete(Integer key)
    {
        Node p = root;                  // まず根に注目
        Node parent = null;             // parentは現在注目している節の親を指す
        boolean  isLeftChild = false;   // pがparentの左の子ならtrue、右の子ならfalse

        while (p != null) {             
            // 注目している節とキーを比較
            int result = key.compareTo(p.data);
            if (result == 0) {          // 見つかった
                if (p.left == null && p.right == null) { // 葉である
                    // 葉を削除
                    if (parent == null) {		//pが根を指している
                        root = null;
                    } else if (isLeftChild) {	//pがparentの左の子
                        parent.left = null;
                    } else {					//pがparentの右の子
                        parent.right = null;
                    }
                } else if (p.left == null) {            // 右の子のみもつ
                    // 右の子を親にする
                    if (parent == null) {
                        root = p.right;
                    } else if (isLeftChild) {
                        parent.left = p.right;
                    } else {
                        parent.right = p.right;
                    }
                } else if (p.right == null) {           // 左の子のみもつ
                    // 左の子を親にする
                    if (parent == null) {
                        root = p.left;
                    } else if (isLeftChild) {
                        parent.left = p.left;
                    } else {
                        parent.right = p.left;
                    }
                } else {                                // 左右2つの子を持つ
                    // 右部分木の最小の要素を取り除いて変数xに入れる
                    Node x = deleteMin(p, p.right);

                    // 注目している節に最小の要素xを入れる
                    if (parent == null) {
                        root = x;               
                    } else if (isLeftChild) {
                        parent.left = x;        
                    } else {
                        parent.right = x;       
                    }
                    x.right = p.right;          
                    x.left  = p.left;           
                }
                return true;            // 削除成功

            } else if (result < 0) {    // キーのほうが小さければ、左部分木に進む
                parent = p;             
                isLeftChild = true;
                p = p.left;
            } else {                    // キーのほうが大きければ、右部分木に進む
                parent = p;             
                isLeftChild = false;
                p = p.right;
            }
        }

        // 削除対象が見つからなかった
        return false;
    }

    /**
     * 二部探索木から最小の要素を削除
     *
     * @param  p  二部探索木
     * @param  parent  pの親の節
     * @return    削除した節
     */
    private static Node deleteMin(Node parent, Node p)
    {
        boolean  isLeftChild = false;   // pがparentの左の子ならtrue、右の子ならfalse
                                        // メソッドが呼び出された時点でpはparentの右の子なので、初期化はfalseである
        while (p.left != null) {        // 最小の要素を見つける
            parent = p;
            isLeftChild = true;
            p = p.left;
        }

        if (isLeftChild) {              // 最小の要素を削除
            parent.left = p.right;
        } else {
            parent.right = p.right;
        }
        return p;                       // 最小の要素を返す
    }

    /**
     * 通りがけ順
     */
    private static void inorder(Node p)
    {
        if (p == null) {
            return;
        } else {
            inorder(p.left);
            System.out.println(p.data);
            inorder(p.right);
        }
    }

    /**
     * 二分探索木の全要素を昇順に表示
     */
    public void showAll()
    {
        inorder(root);
    }

// ���̑�:  toString���\�b�h
    private static String toStringAux(Node p)
    {
        if (p == null)
            return "-";

        return "(" + p.data + " " + toStringAux(p.left) + " "
            + toStringAux(p.right) + ")";
    }

    public String toString()
    {
        return toStringAux(root);
    }

}
