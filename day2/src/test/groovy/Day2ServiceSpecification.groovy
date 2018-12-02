import spock.lang.Specification

class Day2ServiceSpecification extends Specification {

    def example1() {
        given:
        Day2Service day2Service = new Day2Service();

        when:
        day2Service.addInputRow('abcdef')

        then:
        !day2Service.containsLetterTwoTimes()
        !day2Service.containsLetterThreeTimes()
    }

    def example2() {
        given:
        Day2Service day2Service = new Day2Service();

        when:
        day2Service.addInputRow('bababc')

        then:
        day2Service.containsLetterTwoTimes()
        day2Service.containsLetterThreeTimes()
    }
}