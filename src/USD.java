public class USD extends Coin {
    private final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getvalue() {
        return 0;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }

}
