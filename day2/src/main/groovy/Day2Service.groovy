class Day2Service {

    String inputRow;

    void addInputRow(String row) {
        inputRow = row
    }

    boolean containsLetterTwoTimes() {
        containsLetterNTimes 2
    }

    boolean containsLetterThreeTimes() {
        containsLetterNTimes 3
    }

    boolean containsLetterNTimes(int n) {
        inputRow.chars().map { occurrences(it) }.filter{ it == n}.findAny().isPresent()
    }


    int occurrences(int searchCharacter) {
        inputRow.chars().filter { it == searchCharacter }.count();
    }
}