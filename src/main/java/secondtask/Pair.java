package secondtask;

import java.util.Objects;

public class Pair implements Comparable<Pair>{
    private int id;
    private String value;

    public Pair(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        int compare = this.getId() - o.getId();
        if (compare == 0)
            return this.value.compareTo(o.getValue());
        return compare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return id == pair.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + value;
    }
}
