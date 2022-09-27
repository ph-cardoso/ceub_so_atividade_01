package join;

import java.util.List;

public class JoinParallel {
    private final List<String> data;

    public JoinParallel(List<String> data) {
        this.data = data;
    }

    public String runJoin() {
        return String.join("", data);
    }
}
