import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

interface activationFunc{
    public double f(double val);
}

public class NeuronNet {
    private final ArrayList<ArrayList<Neuron>> layers = new ArrayList<ArrayList<Neuron>>();
    private final activationFunc activation;

    private double result;

    private double deriv_sigmoid(double x) {
        double fx = 1/(1+Math.exp(-x));
        return fx*(1-fx);
    }

    private double mse_loss(double[] y_true, double[] y_pred) {
        double sum = 0.0;
        for (int i = 0; i<y_true.length; i++) {
            final double r = y_true[i]-y_pred[i];
            sum=r*r;
        }
        return sum/y_true.length;
    }

    public NeuronNet(activationFunc func, int[] layers) {
        this.activation = func;

        // Создание входного слоя
        this.layers.add(new ArrayList<Neuron>());
        for (int i = 0; i<layers[0]; i++) {
            this.layers.get(0).add(new InputNeuron());
        }
        // Создание скрытых слоёв
        for (int i = 1; i<(layers.length-1); i++) {
            this.layers.add(new ArrayList<Neuron>());
            for (int k = 0; k<layers[i]; k++) {
                HiddenNeuron n = new HiddenNeuron(ThreadLocalRandom.current().doubles(layers[i-1]).toArray(), Math.random(), this.activation);
                for (Neuron ln : this.layers.get(i-1)) {
                    ln.connect(n);
                }
                this.layers.get(i).add(n);
            }
        }
        // Создание выходного слоя
        this.layers.add(new ArrayList<Neuron>());
        for (int i = 0; i<layers[layers.length-1]; i++) {
            OutputNeuron n = new OutputNeuron(ThreadLocalRandom.current().doubles(layers[layers.length-2]).toArray(), Math.random(), this.activation, this);
            for (Neuron ln : this.layers.get(layers.length-2)) {
                ln.connect(n);
            }
            this.layers.get(layers.length-1).add(n);
        }
    }

    public void activate(double[] input) {
        for (int i=0; i<input.length; i++) {
            this.layers.get(0).get(i).signal(input[i]);
        }
    }

    public void result(double result) {
        this.result = result;
    }

    // TODO
    public void learn(double[][] data, double[] trues) {
        final double learn_rate = 0.1;
        final int epochs = 1000;
        for (int epoch = 0; epoch<epochs; epoch++) {
            for (int i=0; i<trues.length; i++) {
                final double[] x = data[i];
                final double y_true = trues[i];
            }
        }
    }

}
