Day2Service day2Service = new Day2Service();

new File('src/main/resources/input').each { day2Service.addInputRow it }

println "Result is ${day2Service.findMatchingCharacters()}"