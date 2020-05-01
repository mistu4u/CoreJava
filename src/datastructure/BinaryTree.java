package datastructure;

public class BinaryTree {
    BinaryTree left, right;
    int value;

    BinaryTree(int value) {
        this.value = value;
    }

    public void insert(int newValue) {
        if (newValue <= value) {
            if (left == null) {
                left = new BinaryTree(newValue);
            } else {
                left.insert(newValue);
            }
        } else {
            if (right == null) {
                right = new BinaryTree(newValue);
            } else {
                right.insert(newValue);
            }
        }
    }

    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.print(value + "->");
        if (right != null) {
            right.print();
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(5);
        bt.insert(10);
        bt.insert(1);
        bt.insert(2);
        bt.print();
    }
}
