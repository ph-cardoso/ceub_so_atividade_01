package fork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinTask;

public class ExemploFork extends RecursiveAction {

    private final String palavra;
    private static final int LIMITE = 12;

    private static List<String> resultList;

    public ExemploFork(String palavra) {
        this.palavra = palavra;
    }

    private void transformaPalavra() {
        String resultado = palavra.toUpperCase();
        resultList.add(resultado);
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

    public List<String> runFork() {
        resultList = new ArrayList<>();
        this.compute();
        return resultList;
    }
}