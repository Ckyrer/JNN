public class App {
    public static void main(String[] args) throws Exception {
        activationFunc sigmoida = (double x) -> {
            return 1/(1+Math.exp(-x));
        };

        NeuronNet net = new NeuronNet(sigmoida, new int[] {2, 2, 1});

        net.activate(new double[] {2.0, 3.0});

        // Neuron o1 = new OutputNeuron(new double[]{0.0, 1.0}, 0.0, sigmoida);

        // HiddenNeuron h1 = new HiddenNeuron(new double[]{0.0, 1.0}, 0.0, sigmoida);
        // HiddenNeuron h2 = new HiddenNeuron(new double[]{0.0, 1.0}, 0.0, sigmoida);

        // h1.connect(o1);
        // h2.connect(o1);

        // InputNeuron x1 = new InputNeuron();
        // InputNeuron x2 = new InputNeuron();

        // x1.connect(h1);
        // x1.connect(h2);
        // x2.connect(h1);
        // x2.connect(h2);

        // x1.signal(2.0);
        // x2.signal(3.0);
    }
}
