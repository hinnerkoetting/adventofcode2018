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

    void example2() {
        given:
        def rememberAdder = new LoopingRememberAdder();
        when:
        rememberAdder.add("+3")
        rememberAdder.add("+3")
        rememberAdder.add("+4")
        rememberAdder.add("-2")
        rememberAdder.add("-4")
        then:
        rememberAdder.determineFirstDuplicate() == 10
    }

}
