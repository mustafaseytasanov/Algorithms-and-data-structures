import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/*
В бинарное дерево поиска добавляются элементы. Выведите глубину для каждого 
добавленного элемента в том порядке, как они добавлялись. Если элемент уже 
есть в дереве, то ничего добавлять и выводить не нужно. Глубиной называется 
расстояние от корня дерева до элемента включительно.

Формат ввода
Вводится последовательность целых чисел, оканчивающаяся нулем. Сам ноль 
в последовательность не входит. По данной последовательности требуется построить дерево.

Формат вывода
Выведите ответ на задачу.
*/

public class ElementDepth {

    class Node {
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



    private Node rootNode;

    public ElementDepth() {
        rootNode = null;
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        String[] array = str.split(" ");
        ElementDepth tree = new ElementDepth();
        int value;
        int depth;
        for (int i = 0; i < array.length - 1; i++) {
            value = Integer.parseInt(array[i]);
            depth = tree.insertNode(value);
            if (depth != -1)
                System.out.print(depth + " ");
        }
    }

    public int insertNode(int value) {

        int depth = 1;

        Node newNode = new Node(); 
        newNode.setValue(value); 
        if (rootNode == null) { 
            rootNode = newNode;
        } else {
            Node currentNode = rootNode; 
            Node parentNode;
            while (true) 
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return -1;   
                } else if (value < currentNode.getValue()) { 
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) { 
                        parentNode.setLeftChild(newNode); 
                        depth++;
                        return depth;
                    }
                    depth++;
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { 
                        parentNode.setRightChild(newNode);
                        depth++;
                        return depth;
                    }
                    depth++;
                }
            }
        }

        return depth;
    }

}
