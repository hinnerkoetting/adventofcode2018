Adder adder = new Adder();

new File('src/main/resources/input').each {
    String line -> adder.add(line);
}

println "Result is $adder.sum"

