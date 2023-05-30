import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private long id;
    private long time;
    private List<Node> deps;

    public Node(int id) {
        this.id = id;
        this.time = 0;
        this.deps = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public List<Node> getDeps() {
        return deps;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addDep(Node dep) {

        deps.add(dep);
    }
}
