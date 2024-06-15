package dataStructures;

public class LinkedList {

    //uma lista encadeada é formada por nós(nodes) precisa ter uma cabeça(head) e uma cauda(tail)
    //cada node vai apontar para o próximo ou null se for o último

    private Node head;
    private Node tail;
    private int listLength;

    // a classe node é descrita dentro da linkedlist e será usada para instanciar os nós que formam a lista
    // obrigatoriamente aqui recebem uma string(data), poderia ser implementado vazia, mas perde o objetivo, nesse caso

    public class Node {
        //cada nó é inicializado com uma String data como conteúdo
        public String data;

        //cada nó é inicializado com uma referencia para o proximo nó
        //na inicialização, como não há esse proximo nó, essa ref é null
        Node next;

        //construtor do nó
        public Node(String data) {
            this.data = data;
        }
    }

    public LinkedList(String data){
         listLength = 1;
         Node newNode = new Node(data);
         head = newNode;
         tail = newNode;

    }

    public void getTail(){
        if(this.tail == null){
            System.err.println("a lista está vazia");
        } else
            System.out.println("a cauda da lista é: " + tail.data);
    }

    public void getHead(){
        if(this.head == null){
            System.err.println("a lista está vazia");
        } else
            System.out.println("a cabeça da lista é: "+ head.data);

    }

    public void getLength(){
        System.out.println("o tamanho da lista é: " + listLength);
    }

    public void makeEmpty(){
        head = null;
        tail = null;
        listLength = 0;
    }

    public void print(){
        Node temp = this.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(String data){
        Node newNode = new Node(data);
        if(listLength == 0 ){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        listLength++;
    }

    public Node removeLast() {
        if (listLength == 0) return null;
        Node pre = head;
        Node temp = null;

        while(pre.next != tail){
            pre = pre.next;
        }

        temp = tail;
        tail = pre;
        tail.next = null;

        listLength--;

        if(listLength == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst(){
        if (listLength == 0) return null;
        Node temp = head;
        head = temp.next;
        listLength--;

        if(listLength == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if(listLength == 0){
           head = newNode;
           tail = newNode;
           listLength = 1;
        } else {
            newNode.next = head;
            head = newNode;
            listLength++;
        }
    }

    public Node get(int index){
        if(index < 0 || index >= listLength)return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //ou set, como na terminologia de um banco de dados, mas eu escrevi updateIndex antes de ver o professor fazer
    public void updateIndex(int index, String data){
        if(index < 0 || index >= listLength) return;

        Node temp = get(index);

        temp.data = data;
    }

    public void insert (int index, String data) {
        if(index == 0){
            prepend(data);
        }
        else if(index == listLength) {
            append(data);
        }
        else {
        Node newNode = new Node(data);
        newNode.next = get(index);

        Node pre = get(index - 1);
        pre.next = newNode;
        listLength++;

        }

    }

    public Node remove(int index){
        if(index <0 || index >= listLength) return null;
        if(index == 0){
            return removeFirst();
        }
        else if(index == listLength -1){
            return removeLast();
        }
        else {
            Node prev = get(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            listLength --;

            return temp;
        }
    }
}

