import parcs.*;

import java.util.ArrayList;
import java.util.List;

public class DFS implements AM {
    public void run(AMInfo info) {
        Node n = (Node) info.parent.readObject();
        System.out.println("[" + n.getId() + "] Build started.");

        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();
        List<Node> deps = n.getDeps();
        for (Node d : deps) {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("DFS");
            c.write(d);
            points.add(p);
            chans.add(c);
        }
        long sum = n.getTime();
        for (channel c : chans) {
            sum += c.readLong();
        }
        try {
            Thread.sleep(n.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("[" + n.getId() + "] Build finished.");
        info.parent.write(sum);
    }
}
