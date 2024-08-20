import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericList<T> {
    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    public void remove(T item) {
        list.remove(item);
    }

    public Optional<T> find(T item) {
        return list.stream().filter(i -> i.equals(item)).findFirst();
    }

    public int size() {
        return list.size();
    }

    public List<T> getAll() {
        return list;
    }
}