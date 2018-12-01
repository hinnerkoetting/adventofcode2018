import spock.lang.Specification

class RememberAdderTest extends Specification {

    void example1() {
        given:
        def rememberAdder = new RememberAdder();
        when:
        rememberAdder.add("+1")
        rememberAdder.add("-1")
        then:
        rememberAdder.getFirstDuplicate() == 0
    }

}
