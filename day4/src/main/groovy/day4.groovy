import  groovy.transform.ToString;

def inputs = new ArrayList();

new File('src/main/resources/input').each {
    splits = it.split(']');
    def date  = splits[0].substring(1);
    Entry entry = new Entry();
    entry.date = Date.parse("yy-MM-dd HH:mm", date)
    if (it.contains ('Guard ')) {
        entry.id = it.substring('[1518-02-12 23:47] Guard #'.length());
        entry.id = entry.id.split('begins')[0]
    } else if (it.contains ('wakes ')) {
        entry.wakes =true;
    } else if (it.contains ('falls')) {
        entry.sleeps =true;
    }

    inputs.add(entry);
}


Collections.sort(inputs, { a, b -> a.date.compareTo(b.date)})

for (int i = 0; i< inputs.size(); i++) {
    if (inputs.get(i).id == null) {
        inputs.get(i).id = inputs.get(i - 1).id;
    }
}

def map = new HashMap();

def start;
for (int i = 0; i< inputs.size(); i++) {

    if (inputs.get(i).sleeps) {
        start = inputs.get(i).date;
    }
    if (inputs.get(i).wakes) {
        int minutes = inputs.get(i).date.getMinutes() - start.getMinutes()

        def id = inputs.get(i).id
        if (!map.containsKey(id)) {
            map.put(id, minutes);
        } else{
            map.put(id, map.get(id) + minutes);
        }
        start = null;

    }
}

int max = 0;
String resultId;


map.entrySet().stream().forEach({
    if (it.value > max) {
        max = it.value
        resultId = it.key
    }
})

def minuteMap = new HashMap();
for (int i = 0; i < 60; i++) {
    minuteMap.put(i, 0);
}

for (int i = 0; i< inputs.size(); i++) {
    def input = inputs.get(i);
    if (input.id != resultId ) {
        continue;
    }


    if (input.sleeps) {
        start = inputs.get(i).date;
    }
    if (inputs.get(i).wakes) {
        for (int j = start.getMinutes(); j < input.date.getMinutes(); j++) {
            minuteMap.put(j,  minuteMap.get(j) + 1);
        }
        start = null;
    }

}

printf ('Part 1:')
printf("Max minutes $max \n");
printf("ResultId $resultId \n");

int maxMinute = 0;
int resultMinute;

minuteMap.entrySet().stream().forEach({
    if (it.value > maxMinute) {
        maxMinute = it.value
        resultMinute = it.key
    }
})

printf("Result minute is $resultMinute \n");
printf("Times of asleep at resultmninute $maxMinute \n");

printf ('Part 2:')



def allGuardsMap =  new HashMap<String, Map<Integer, Integer>>();

for (int i = 0; i< inputs.size(); i++) {
    def input = inputs.get(i);
    if (inputs.get(i).sleeps) {
        start = inputs.get(i).date;
    }
    if (inputs.get(i).wakes) {
        if (!allGuardsMap.containsKey(input.id)) {
            Map minuteMap2 =  new HashMap();
            for (int j = 0; j < 60; j++) {
                minuteMap2.put(j, 0);
            }

            allGuardsMap.put(input.id, minuteMap2);
        }

        for (int j = start.getMinutes(); j < input.date.getMinutes(); j++) {
            Map minuteMap2 = allGuardsMap.get(input.id);
            minuteMap2.put(j,  minuteMap2.get(j) + 1);
        }
        start = null;

    }
}

int maxMinute2Times = 0;
int maxMinute2 = 0;
String resultGuard;


allGuardsMap.entrySet().stream().forEach({ guard ->
    guard.value.entrySet().stream().forEach { mm ->
        if (mm.value > maxMinute2Times) {
            maxMinute2Times = mm.value
            maxMinute2 = mm.key
            resultGuard = guard.key
        }
    }
});

printf("Resultguard2 is $resultGuard \n");
printf("Result minute2 is $maxMinute2 \n");
printf("Result times2 appears $maxMinute2Times \n");


@ToString
class Entry {
    Date date;
    String id;
    boolean wakes;
    boolean sleeps;
}
