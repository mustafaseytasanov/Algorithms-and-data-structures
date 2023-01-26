import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/*
Выведите второй по величине элемент в построенном дереве. Гарантируется, 
что такой найдется.

Формат ввода
Дана последовательность целых чисел, оканчивающаяся нулем. Сам ноль 
в последовательность не входит.

Формат вывода
Выведите ответ на задачу.
*/

public class SecondMax {

    static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public void printNode() {
            System.out.println(" Выбранный узел имеет значение :" + value);
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(final Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(final Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }


    private static Node rootNode;

    public SecondMax() {
        rootNode = null;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        String[] array = str.split(" ");

        int value;
        SecondMax tree = new SecondMax();
        for (int i = 0; i < array.length - 1; i++) {
            value = Integer.parseInt(array[i]);
            tree.insertNode(value);
        }
        Node localNode = rootNode;
        Node child;

        while (true) {
            child = localNode.getRightChild();
            if (child == null) {
                break;
            } else {
                localNode = child;
            }
        }
        int firstMax = localNode.getValue();
        SecondMax tree2 = new SecondMax();
        for (int i = 0; i < array.length - 1; i++) {
            value = Integer.parseInt(array[i]);
            if (value != firstMax) {
                tree2.insertNode(value);
            }
        }
        localNode = rootNode;
        while (true) {
            child = localNode.getRightChild();
            if (child == null) {
                break;
            } else {
                localNode = child;
            }
        }

        int secondMax = localNode.getValue();
        System.out.println(secondMax);
    }

    public void insertNode(int value) {

        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else { // корневой узел занят
            Node currentNode = rootNode;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }


}
