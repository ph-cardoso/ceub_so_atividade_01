package fork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinTask;

public class ExemploFork extends RecursiveAction {

    public String palavra;
    public static final int LIMITE = 8;
    public ExemploFork(String palavra) {
        this.palavra = palavra;
    }

    private void transformaPalavra() {
        String resultado = palavra.toUpperCase();
        System.out.println("O resultado é:" + resultado + " e foi processsado"
                + " por: " + Thread.currentThread().getName());
    }

    @Override
    protected void compute() {
        if(palavra.length() < LIMITE) {
            transformaPalavra();
        } else {
            ForkJoinTask.invokeAll(criaSubtarefas());
        }
    }

    private List<ExemploFork> criaSubtarefas(){

        List<ExemploFork> subTarefas = new ArrayList<>();
        String parte1 = palavra.substring(0, palavra.length() / 2);
        String parte2 = palavra.substring(palavra.length() / 2);

        subTarefas.add(new ExemploFork(parte1));
        subTarefas.add(new ExemploFork(parte2));

        return subTarefas;
    }

    public void runFork() {
        this.compute();
    }
}