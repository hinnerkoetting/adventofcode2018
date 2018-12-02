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
        inputRows.stream ().map { containsLetterTwoTimes(it) }.filter { it }.count()
    }

    int numberOfThreesFound() {
        inputRows.stream ().map { containsLetterThreeTimes(it) }.filter { it }.count()
    }

    int occurrences(String row, int searchCharacter) {
        row.chars().filter { it == searchCharacter }.count();
    }
}