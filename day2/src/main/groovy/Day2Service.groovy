import java.util.stream.Collectors

class Day2Service {

    def inputRows = new ArrayList<>();

    void addInputRow(String row) {
        inputRows << row
    }

    boolean containsLetterTwoTimes(String row) {
        containsLetterNTimes row, 2
    }

    boolean containsLetterThreeTimes(String row) {
        containsLetterNTimes row, 3
    }

    boolean containsLetterNTimes(String row, int n) {
        row.chars().map { occurrences(row, it) }.filter{ it == n}.findAny().isPresent()
    }

    int numberOfTwosFound() {
        numberOfNsFound(2)
    }

    int numberOfThreesFound() {
        numberOfNsFound(3)
    }

    int numberOfNsFound(int n) {
        inputRows.stream ().map { containsLetterNTimes(it, n) }.filter { it }.count()
    }

    int calculateProduct() {
        numberOfNsFound(3) * numberOfNsFound(2)
    }

    int occurrences(String row, int searchCharacter) {
        row.chars().filter { it == searchCharacter }.count();
    }
}