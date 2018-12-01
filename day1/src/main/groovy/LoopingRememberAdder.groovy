class LoopingRememberAdder {

    List<String> inputs = new ArrayList<>();
    RememberAdder rememberAdder = new RememberAdder();

    void add(String nextValue) {
        inputs.add(nextValue);
    }

    int determineFirstDuplicate() {
        int safetyCounter = 1_000
        while (!rememberAdder.duplicateFound && safetyCounter >0) {
            safetyCounter--;
            inputs.each { input -> rememberAdder.add(input) }
        }
        rememberAdder.firstDuplicate
    }
}
