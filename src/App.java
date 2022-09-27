import fork.ExemploFork;
import fork.ForkThread;
import join.JoinNormal;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String model = "teste de string para o fork da atividade de sistemas operacionais...";
        int n = 4;

        ForkThread forkThread = new ForkThread(model, n);
        List<String> resultsForkThread = forkThread.runFork();
        System.out.println(resultsForkThread);

        JoinNormal joinNormal = new JoinNormal(resultsForkThread, model, n);
        System.out.println(joinNormal.joinList());
    }
}
