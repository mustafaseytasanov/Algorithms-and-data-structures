import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

/*
Реализуйте бинарное дерево поиска для целых чисел. Программа получает на вход 
последовательность целых чисел и строит из них дерево. Элементы в деревья 
добавляются в соответствии с результатом поиска их места. Если элемент уже 
существует в дереве, добавлять его не надо. Балансировка дерева не производится.

Формат ввода
На вход программа получает последовательность натуральных чисел. Последовательность 
завершается числом 0, которое означает конец ввода, и добавлять его в дерево не надо.

Формат вывода
Выведите единственное число – высоту получившегося дерева.
*/

public class TreeHeight {

    class Node {
        private int value; // ключ узла
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

    public TreeHeight() {
        rootNode = null;
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new
                FileReader("input.txt"));

        String str = br.readLine();
        String[] array = str.split(" ");
        TreeHeight tree = new TreeHeight();
        int value;
        for (int i = 0; i < array.length - 1; i++) {
            value = Integer.parseInt(array[i]);
            tree.insertNode(value);

        }

        tree.findHeight();
    }

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;
                }
                else  if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void findHeight() {

        int height = 0;

        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        boolean isRowEmpty = false;

        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }

            }
            height += 1;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }

        System.out.println(height);

    }


}
