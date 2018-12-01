class RememberAdder {

    Set<Integer> existingFrequencies = new HashSet<>();
    boolean duplicateFound = false;
    int firstDuplicate = Integer.MIN_VALUE;
    Adder adder = new Adder();

    RememberAdder() {
        existingFrequencies.add(0);
    }

    void add(String nextValue) {
        adder.add(nextValue);
        int sum = adder.sum;
        if (!duplicateFound) {
            if (!existingFrequencies.contains(sum)) {
                existingFrequencies.add(sum);
            } else {
                duplicateFound = true;
                firstDuplicate = sum;
            }
        }
    }

    int getFirstDuplicate() {
        if (!duplicateFound) {
            throw new IllegalArgumentException("No duplicate found");
        }
        return firstDuplicate;
    }
}
