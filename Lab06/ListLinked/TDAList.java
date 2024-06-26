package ListLinked;
public interface TDAList<T> { 
    void add(T x); 
    int indexOf(T x); 
    void remove(T x); 
    boolean isEmpty(); 
} 