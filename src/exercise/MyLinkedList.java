package exercise;

public class MyLinkedList {
    private Element head; // 先頭
    private Element tail; // 末尾

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int size() {
        // TODO: リストの要素数を数えて返す

    	int count = 0;
        if (head == null) {
            return count;
        }
        Element p = head;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }

    public void addFirst(String str) {
        // 先頭に要素を追加
        // リストが空なら要素を作って先頭と末尾に
        Element newElem = new Element(str);
        if (head == null) {
            head = newElem;
            tail = head;
            return;
        }else {	// TODO: リストが空でないなら先頭に追加
        	//tail = head;
        	head.setPrevious(newElem);
        	newElem.setNext(head);
        	head = newElem;
        	Element p = head;
            while (p != null) {
            	tail = p;
                p = p.getNext();
            }
        return;
        }
    }

    public void addLast(String str) {
        // 末尾に要素を追加
        // リストが空なら要素を作って先頭と末尾に
        Element newElem = new Element(str);
        if (head == null) {
            head = newElem;
            tail = head;
            return;
        }else {		// TODO: リストが空でないなら末尾に追加
        	tail.setNext(newElem);
        	newElem.setPrevious(tail);
        	tail = newElem;
        	Element p = head;
            while (p.getNext() != null) {
                p = p.getNext();
                tail = p;
            }
        return;
        }
    }

    public void add(int index, String str) {
        // index番目に要素を挿入
        // indexの範囲チェック
        if (index < 0 || size() < index) {
            System.out.println("インデックスが範囲外です。");
            return;
        }
        // TODO: indexがゼロなら先頭に追加
        // TODO: indexがサイズと同じなら末尾に追加
        // TODO: それ以外、i番目を見つけて、その前に追加
        Element newElem = new Element(str);
        if (head == null) {
            head = newElem;
            tail = head;
            return;
        }else if (index == 0) {
        	//head.setPrevious(newElem);
        	//newElem.setNext(head);
        	//head = newElem;
        	addFirst(str);
            return;
        } else if (index == size()) {
        	//tail.setNext(newElem);
        	//newElem.setPrevious(tail);
        	//tail = newElem;
        	addLast(str);
            return;
        }else {
        	Element p = head;
        	int i = 0;
            while (p != null) {
            	if(index == i) {
            		newElem.setPrevious(p.getPrevious());
            		newElem.setNext(p);
            		p.getPrevious().setNext(newElem);
            		p.setPrevious(newElem);
            	}
                p = p.getNext();
                i++;
            }
        }
    }

    public String removeFirst() {
        // 先頭の要素を削除
        // 要素がない場合
        if (head == null) {
            System.out.println("削除する要素がありません。");
            return null;
        }
        // 要素が1つ以上
        Element next = head.getNext();
        Element target = head; // 削除する要素
        if (next != null) {
            // TODO: 要素が2つ以上
        	head.setNext(null);
        	next.setPrevious(null);
        }
        head = next;
        return target.getData();
    }

    public String removeLast() {
        // 末尾の要素を削除
        // 要素があるかチェック
        if (tail == null) {
            System.out.println("削除する要素がありません。");
            return null;
        }
        // 要素が1つ以上
        Element target = tail;
        Element prev = tail.getPrevious();
        if (tail != null) {
            // TODO: 要素が2つ以上
        	tail.setPrevious(null);
        	prev.setNext(null);
        }
        tail = prev;
        return target.getData();
    }

    public String remove(int index) {
        // index番目の要素を削除
        // indexの範囲チェック
        if (index < 0 || index >= size()) {
            System.out.println("インデックスが範囲外です。");
            return null;
        }
        // indexがゼロなら先頭を削除
        if (index == 0) return removeFirst();
        // indexがサイズ-1なら末尾を削除
        if (index == size() - 1) return removeLast();
        // TODO: それ以外

        // 要素がない場合
        if (head == null) {
            System.out.println("削除する要素がありません。");
            return null;
        }
        // 要素が1つ以上
        Element p = head;
    	int i = 0;
        while (p != null) {
        	if(index == i) {
        		Element next = p.getNext();
                Element target = p; // 削除する要素
                Element prev = p.getPrevious();
                prev.setNext(next);
                next.setPrevious(prev);
                return target.getData();
        	}
            p = p.getNext();
            i++;
        }
        return null;
    }

    public boolean contains(String str) {
        // 要素が含まれているかどうか返す
        // 要素がないならfalse
        if (head == null) {
            return false;
        }else { // TODO: 要素をたどってあるかないか探す
        	Element p = head;
            while (p != null) {
            	if(p.getData() == str) {
                	return true;
                }
                p = p.getNext();
            }
        }
        return false;
    }

    public void print() {
        // 要素を先頭から表示
        System.out.print("Forward: ");
        if (head == null) {
            System.out.println("null");
            return;
        }
        Element p = head;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getNext();
        }
        System.out.println("null");
    }

    public void printReverse() {
        // 要素を末尾から表示
        System.out.print("Reverse: ");
        if (tail == null) {
            System.out.println("null");
            return;
        }
        Element p = tail;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getPrevious();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // いろいろと試す
        System.out.println("リストの生成");
        MyLinkedList list = new MyLinkedList();
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("dを先頭に追加");
        list.addFirst("d");
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("cを先頭に追加");
        list.addFirst("c");
        list.print();
        System.out.println("eを最後に追加");
        list.addLast("e");
        list.print();
        list.printReverse();
        System.out.println("bを先頭に追加");
        list.addFirst("b");
        list.print();
        System.out.println("fを最後に追加");
        list.addLast("f");
        list.print();
        list.printReverse();
        System.out.println("fが含まれているか?: " + list.contains("f"));
        System.out.println("bが含まれているか?: " + list.contains("b"));
        System.out.println("dが含まれているか?: " + list.contains("d"));
        System.out.println("zが含まれているか?: " + list.contains("z"));
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("0番目にdを追加");
        list.add(0, "d");
        list.print();
        System.out.println("0番目にbを追加");
        list.add(0, "b");
        list.print();
        System.out.println("2番目にfを追加");
        list.add(2, "f");
        list.print();
        System.out.println("1番目にcを追加");
        list.add(1, "c");
        list.print();
        System.out.println("3番目にeを追加");
        list.add(3, "e");
        list.print();
        System.out.println("5番目にgを追加");
        list.add(5, "g");
        list.print();
        list.printReverse();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("4番目を削除");
        list.remove(4);
        list.print();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("2番目を削除");
        list.remove(2);
        list.print();
        list.printReverse();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("end.");
    }
}