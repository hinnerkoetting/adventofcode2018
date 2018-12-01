import spock.lang.Specification

class AdderTest extends Specification {



    def 'example1'(){
        given:
        Adder adder = new Adder();

        when:
        adder.add("+1");
        adder.add("-2");
        adder.add("+3");
        adder.add("+1");
        then:
        assert adder.sum ==3
    }

}