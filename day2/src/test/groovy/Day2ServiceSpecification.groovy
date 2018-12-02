import spock.lang.Specification

class Day2ServiceSpecification extends Specification {

    def example1() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        !day2Service.containsLetterTwoTimes('abcdef')
        !day2Service.containsLetterThreeTimes('abcdef')
    }

    def example2() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        day2Service.containsLetterTwoTimes('bababc')
        day2Service.containsLetterThreeTimes('bababc')
    }

    def example3() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        day2Service.containsLetterTwoTimes('abbcde')
        !day2Service.containsLetterThreeTimes('abbcde')
    }


    def example4() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        !day2Service.containsLetterTwoTimes('abcccd')
        day2Service.containsLetterThreeTimes('abcccd')
    }

    def example5() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        day2Service.containsLetterTwoTimes('aabcdd')
        !day2Service.containsLetterThreeTimes('aabcdd')
    }

    def example6() {
        given:
        Day2Service day2Service = new Day2Service();

        expect:
        !day2Service.containsLetterTwoTimes('ababab')
        day2Service.containsLetterThreeTimes('ababab')
    }

    def countingAll() {
        given:
        Day2Service day2Service = new Day2Service();

        when:
        day2Service.addInputRow('abcdef')
        day2Service.addInputRow('bababc')
        day2Service.addInputRow('abbcde')
        day2Service.addInputRow('abcccd')
        day2Service.addInputRow('aabcdd')
        day2Service.addInputRow('abcdee')
        day2Service.addInputRow('ababab')

        then:
        day2Service.numberOfTwosFound() == 4
        day2Service.numberOfThreesFound() == 3
        day2Service.calculateProduct() == 12
    }

    def part2() {
        given:
        Day2Service day2Service = new Day2Service();

        when:
        day2Service.addInputRow('abcde')
        day2Service.addInputRow('fghij')
        day2Service.addInputRow('klmno')
        day2Service.addInputRow('pqrst')
        day2Service.addInputRow('fguij')
        day2Service.addInputRow('axcye')
        day2Service.addInputRow('wvxyz')

        then:
        day2Service.findCorrectBoxIds() == ['fghij', 'fguij']
        day2Service.findMatchingCharacters() == 'fgij'
    }
}