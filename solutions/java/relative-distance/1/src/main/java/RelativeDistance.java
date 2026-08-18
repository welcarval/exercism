import java.util.*;

class RelativeDistance {

    private final Map<String, Set<String>> neighborhood = new HashMap<>();

    RelativeDistance(Map<String, List<String>>  familyTree) {

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue(); 

            neighborhood.putIfAbsent(parent, new HashSet<>());

            for (String son : children) {
                neighborhood.putIfAbsent(son, new HashSet<>());
                neighborhood.get(parent).add(son);
                neighborhood.get(son).add(parent);

                for (String brother : children) {
                    if (!son.equals(brother)) {
                        neighborhood.putIfAbsent(brother, new HashSet<>());
                        neighborhood.get(son).add(brother);
                        neighborhood.get(brother).add(son);
                    }
                }
            }
        }
    }

    int degreeOfSeparation(String personA, String personB) {

        if (personA.equals(personB)) return 0;
        if (!neighborhood.containsKey(personA) || !neighborhood.containsKey(personB)) return -1;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();

        queue.add(personA);
        distances.put(personA, 0);

        while(!queue.isEmpty()) {
            String actual = queue.poll();
            int actualDist = distances.get(actual);

            if (actual.equals(personB)) {
                return actualDist;
            }

            for (String neighbor : neighborhood.get(actual)) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, actualDist + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}
