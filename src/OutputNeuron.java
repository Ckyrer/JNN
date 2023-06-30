public class OutputNeuron extends Neuron {
    final private double[] weights;
    final private double bias;
    final private activationFunc func;
    final private NeuronNet host;
    private int inputs_ready = 0;

    public OutputNeuron(double[] weights, double bias, activationFunc f, NeuronNet host) {
        this.weights = weights;
        this.bias = bias;
        this.func = f;
        this.host = host;
    }

    private double output = 0.0;

    public void connect(Neuron n) {
        System.out.println("ERROR: Output neuron cannot be connected");
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
        System.out.println("Answer: "+ String.valueOf(output));
        host.result(output);
    }
    
}
