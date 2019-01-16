package Incremental;

class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        this.next = null;
    }
    public String toString(){
        if(data == null){
            return "null";
        }
        else {
            return data.toString();
        }
    }
}

class SList<T>{
    Node<T> head = new Node<T>(null);
    public String toString(){
        if(head.next == null){
            return "List is empty.";
        }
        SListIterator<T> iterator = iterator();
        String listInStringFormat = "";
        while(iterator.hasNext()){
            listInStringFormat = listInStringFormat + iterator.next() + " --> ";
        }
        return listInStringFormat+" NULL";
    }
    SListIterator<T> iterator(){
        return new SListIterator<T>(head);
    }
}

class SListIterator<T>{
    Node<T> current;
    Node<T> head;
    public SListIterator(Node<T> head) {
        this.current = head;
        this.head = head;
    }

    public boolean hasNext(){
        if(current.next == null){
            return false;
        }
        else {
            return true;
        }
    }

    public Node<T> next(){
        current = current.next;
        return current;
    }
    public void insert(T data) {
        current.next = new Node<T>(data);
        current = current.next;
    }
    public void remove(){
        Node<T> temp = head;
        if(temp.next == null){
            System.out.println("List is empty");
            return ;
        }
        while(temp.next.next != null){
            temp = temp.next;
        }
        current = temp;
        temp.next = null;
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {
        SList<Integer> list = new SList<Integer>();
        SListIterator<Integer> iterator = list.iterator();
        System.out.println(list);
        iterator.insert(35);
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
        iterator.insert(3);
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
        iterator.insert(80);
        iterator.insert(98);
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
    }
}
