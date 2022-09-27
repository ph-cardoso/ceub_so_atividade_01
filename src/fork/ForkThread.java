package fork;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ForkThread {
    private final List<String> output;
    private final String model;
    private final int n;

    public ForkThread(String model, int n) {
        this.output = new ArrayList<>();
        this.model = model;
        this.n = n;
    }

    public List<String> runFork() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<String>> subTasks = new ArrayList<>();

        List<String> words = Utils.getStrings(model, n);

        for (String word : words) {
            subTasks.add(new ForkTask(word));
        }

        List<Future<String>> results = executorService.invokeAll(subTasks);

        for (Future<String> result : results) {
            output.add(result.get());
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }


        return output;
    }
}
