import java.util.*;

class Cat extends Object {
    int x;
    int y;

    public Cat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat c = (Cat) o;
        return c.x == this.x && c.y == this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}