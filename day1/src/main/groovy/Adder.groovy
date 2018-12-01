import javax.swing.text.NumberFormatter

class Adder {

    int sum = 0;

    void add(String nextValue) {
        sum += parseValue(nextValue)
    }

    int parseValue(String value) {
        if (value.startsWith('+')) {
            return Integer.parseInt(value.substring(1));
        } else if (value.startsWith('-')) {
            return Integer.parseInt(value);
        }
        throw new IllegalArgumentException("unknown number " + value);
    }

    int getSum() {
        return sum;
    }
}
