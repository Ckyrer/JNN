import java.util.ArrayList;

public class HiddenNeuron extends Neuron {
    final private double[] weights;
    final private double bias;
    final private activationFunc func;
    private int inputs_ready = 0;

    public HiddenNeuron(double[] weights, double bias, activationFunc f) {
        this.weights = weights;
        this.bias = bias;
        this.func = f;
    }

    private ArrayList<Neuron> next_layer = new ArrayList<Neuron>();
    private double output = 0.0;

    public void connect(Neuron n) {
        next_layer.add(n);
    }

    public void signal(double val) {
        inputs_ready++;
        output += val*weights[inputs_ready-1];
        if (inputs_ready==weights.length) {
            output+=bias;
            output = func.f(output);

            sendSignal();
        }
    }

    public void sendSignal() {
        for (Neuron n: next_layer) {
            n.signal(output);
        }
    }
    
}