import java.util.ArrayList;

public class InputNeuron extends Neuron {
    final private ArrayList<Neuron> nextLayer = new ArrayList<Neuron>();
    private double value;

    public final void connect(Neuron n) {
        nextLayer.add(n);
    }

    public final void signal(double val) {
        value = val;
        sendSignal();
    }

    public final void sendSignal() {
        for (Neuron n : nextLayer) {
            n.signal(value);
        }
    }

}
