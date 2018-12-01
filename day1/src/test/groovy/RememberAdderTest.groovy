import spock.lang.Specification

class RememberAdderTest extends Specification {

    void example1() {
        given:
        def rememberAdder = new LoopingRememberAdder();
        when:
        rememberAdder.add("+1")
        rememberAdder.add("-1")
        then:
        rememberAdder.determineFirstDuplicate() == 0
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

    void example3() {
        given:
        def rememberAdder = new LoopingRememberAdder();
        when:
        rememberAdder.add("-6")
        rememberAdder.add("+3")
        rememberAdder.add("+8")
        rememberAdder.add("+5")
        rememberAdder.add("-6")
        then:
        rememberAdder.determineFirstDuplicate() == 5
    }

    void example4() {
        given:
        def rememberAdder = new LoopingRememberAdder();
        when:
        rememberAdder.add("+7")
        rememberAdder.add("+7")
        rememberAdder.add("-2")
        rememberAdder.add("-7")
        rememberAdder.add("-4")
        then:
        rememberAdder.determineFirstDuplicate() == 14
    }

}
