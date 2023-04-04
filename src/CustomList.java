import java.util.NoSuchElementException;

public class CustomList<T> {
    private class Node{
        T value;
        Node next;
    }
    private Node first = null;
    private Node last = null;

    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        node.next = null;

        if(first == null){
            this.first = node;
            this.last = node;
        }
        else{
            last.next = node;
            this.last = node;
        }
    }

    public T getLast(){
        if(last != null){
            return last.value;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void addFirst(T value){
        Node node = new Node();
        node.value = value;

        if(first == null){
            node.next = null;
            this.first = node;
            this.last = node;
        }
        else{
            node.next = first;
            this.first = node;
        }
    }

    T getFirst(){
        if(first != null){
            return first.value;
        }
        else{
            throw new NoSuchElementException();
        }

    }

    T removeFirst(){
        if(first != null){
            T result = getFirst();
            first = first.next;
            return result;
        }
        else if(first == last){
            T result = getFirst();
            first = null;
            last = null;
            return result;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    T removeLast(){
        if(last != null){
            T result = last.value;

            Node actual = first;
            while(actual.next != last){
                actual = actual.next;
            }
            actual.next = null;
            last = actual;

            return result;
        }
        else if(first == last){
            T result = getFirst();
            first = null;
            last = null;
            return result;
        }
        else{
            throw new NoSuchElementException();
        }
    }


}
