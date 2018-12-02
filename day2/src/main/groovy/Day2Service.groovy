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

    String findMatchingCharacters() {
        List<String> correctBoxIds = findCorrectBoxIds()
        String first = correctBoxIds[0]
        String second = correctBoxIds[1]

        String result = ''
        for (int i = 0; i < first.length(); i++) {
            result += first.charAt(i) == second.charAt(i) ? first.charAt(i) : ''
        }
        result
    }

    List<String> findCorrectBoxIds() {
        def result = new ArrayList<>();
        inputRows.stream()
                .map { Arrays.asList(it, findAlmostMatchingRow(it)) }
                .filter { it.get(1).isPresent() }
                .map{ Arrays.asList(it.get(0), it .get(1).get()) }
                .findFirst().get()
    }

    Optional<String> findAlmostMatchingRow(String input) {
        inputRows.stream().filter {
            int numberDifferences = 0;
            for (int i = 0; i < it.length(); i++) {
                numberDifferences += it.charAt(i) == input.charAt(i) ? 0 : 1;
            }
            numberDifferences == 1
        }.findFirst()
    }
}