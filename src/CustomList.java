import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {

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

    @Override
    public T get(int index) {
        if(first != null && index < size()){
            Node actual = first;
            for(int i=1; i<index; i++){
                actual = actual.next;
            }
            return actual.value;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        if(first != null){
            Node actual = first;
            int counter = 0;
            while(actual.next != last){
                actual = actual.next;
                ++counter;
            }
            ++counter;
            return counter;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public boolean add(T t){
        addLast(t);
        return true;
    }


    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T value = currentNode.value;

                currentNode = currentNode.next;
                return value;
            }
        };
    }

    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();
        for(T entry : this) {
            streamBuilder.accept(entry);
        }
        return streamBuilder.build();
    }

}
