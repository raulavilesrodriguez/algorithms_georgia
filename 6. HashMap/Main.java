public class Main {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> map = new ExternalChainingHashMap<>();
        map.put(1, 16);
        map.put(15, 101);
        map.put(3,5);
        map.put(4, 6);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        System.out.println(map.getTable()[1].getNext());
        System.out.println(map.remove(1));
        System.out.println(map.getTable()[1].getNext());
        System.out.println(map.remove(15));
        System.out.println(map.getTable()[1]);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        map.put(1, 16);
        map.put(15, 101);
        map.put(11, 20);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        System.out.println(map.get(3));
        System.out.println(map.get(11));
        System.out.println(map.containsKey(110));

        map.put(0, 2);
        map.put(30, 29);
        map.put(45, 69);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        System.out.println(map.getTable()[0].getNext().getNext().getNext());
        
        // Multiple nodes. Test Remove()
        System.out.println(map.remove(15));
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        System.out.println(map.getTable()[0].getNext().getNext());
        System.out.println(map.containsKey(15));

        // One node. Test Remove()
        System.out.println(map.getTable()[3]);
        System.out.println(map.remove(3));
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());

        // Two nodes. Test Remove()
        map.put(3,5);
        map.put(18,99);
        System.out.println(map.getTable()[3].getNext());
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());

        System.out.println(map.remove(3));
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println("Lenght Map: " + map.lenght());
        System.out.println(map.getTable()[3]);
        System.out.println(map.containsKey(3));

        //System.out.println(map.remove(33));

        ExternalChainingHashMap<String, Integer> mapS = new ExternalChainingHashMap<>();
        mapS.put("T", 10);
        mapS.put("F", 13);
        mapS.put("Y",5);
        mapS.put("E", 6);

        System.out.println("KEYS: " + mapS.keySet());
        System.out.println("VALUES: " + mapS.values());
        System.out.println("SIZE: " + mapS.size());
        System.out.println("Lenght Map: " + mapS.lenght());
        System.out.println(mapS.getTable()[0].getNext());

    }
}
