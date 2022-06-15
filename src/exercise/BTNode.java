package exercise;

//二分木・深さ優先探索(DFS)
public class BTNode {
    final private String label;
    final private BTNode left;
    final private BTNode right;

    public BTNode(String label, BTNode left, BTNode right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    public String printNode() {
        return printNode("");//prefix:
    }

    public String printNode(String prefix) {
        // TODO: ツリーを表す文字列を返す
        String str = "";
        if(right != null) {
        	str += left.printNode(prefix + "   ");
        }
        str += prefix + this + "\n";
        if(left != null) {
        	str += this.right.printNode(prefix + "   ");
        }
        return str;
    }

    public BTNode searchPreorder(String name) {
        // TODO: 行きがけ順で深さ優先探索する
    	System.out.print(this);
    	if(label.equals(name)) {
    		return this;
    	}
    	if(left != null) {
    		BTNode node = left.searchPreorder(name);
    		if(node != null) {
    			return node;
    		}
    	}
    	if(right != null) {
    		BTNode node = right.searchPreorder(name);
    		if(node != null) {
    			return node;
    		}
    	}
    	return null;

    }

    public BTNode searchPostorder(String name) {
        // TODO: 通りがけ順で深さ優先探索する
    	if(left != null) {
    		BTNode node = left.searchPostorder(name);
    		if(node != null) {
    			return node;
    		}
    	}
    	if(right != null) {
    		BTNode node = right.searchPostorder(name);
    		if(node != null) {
    			return node;
    		}
    	}
    	System.out.print(this);
    	if(label.equals(name)) {
    		return this;
    	}
    	return null;
    }

    public String toString() {
        return "[" + label + "]";
    }

    public static void main(String[] args) {
        BTNode tree = new BTNode(
                "A",
                new BTNode("B",
                        new BTNode("C", null, null),
                        new BTNode("E", null, null)
                ),
                new BTNode("D",
                        new BTNode("F", null, null),
                        new BTNode("G", null, null)
                )
        );
        System.out.println(tree.printNode());
        System.out.println("行きがけ順");
        for (String target : new String[]{"A", "B", "C", "D", "E", "F", "G", "Z"}) {
            System.out.println(target + "を探す");
            BTNode result = tree.searchPreorder(target);
            System.out.println(); // 改行
            System.out.println("あった? " + result);
        }
        System.out.println();
        System.out.println("帰りがけ順");
        for (String target : new String[]{"A", "B", "D", "Z"}) {
            System.out.println(target + "を探す");
            BTNode result = tree.searchPostorder(target);
            System.out.println(); // 改行
            System.out.println("あった? " + result);
        }
    }
}