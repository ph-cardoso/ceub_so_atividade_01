package fork;

import java.util.concurrent.Callable;

public class ForkTask implements Callable<String> {
    private final String data;

    public ForkTask(String data) {
        this.data = data;
    }

    @Override
    public String call() {
//        System.out.println("Running " + Thread.currentThread().getName() + "...");
        return data.toUpperCase();
    }
}
