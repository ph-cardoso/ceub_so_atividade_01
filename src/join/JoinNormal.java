package join;

import utils.Utils;

import java.util.List;

public class JoinNormal {
    private final List<String> partesList;
    private final String model;
    private final int splitLength;

    public JoinNormal(List<String> partesList, String model, int n){
        this.partesList = partesList;
        this.model = model.toUpperCase();
        this.splitLength = n;
    }

    public String runJoin() {
        StringBuilder builder = new StringBuilder(model.length());
        List<String> modelSplitted = Utils.getStrings(model, splitLength);
//        System.out.println(modelSplitted);
//        System.out.println(partesList);

        for (String split : modelSplitted) {
            for (String parte : partesList) {
                if (split.equals(parte)) {
                    builder.append(parte);
                }
            }
        }

        return builder.toString();
    }
}
