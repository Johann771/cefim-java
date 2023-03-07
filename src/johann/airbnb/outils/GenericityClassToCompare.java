package johann.airbnb.outils;

public class GenericityClassToCompare<T extends Comparable<T>>  {
    private T first;
    private T second;

    public GenericityClassToCompare(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
    public T getLower(){
        return (this.first.compareTo(this.second) < 0) ? this.first : this.second;
    }
    public T getHigher(){
        return (this.first.compareTo(this.second) > 0) ? this.first : this.second;
    }
}
