public class Main {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> map = new ExternalChainingHashMap<>();
        map.put(1, 16);
        map.put(15, 1);
        map.put(3,5);
        map.put(4, 6);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        map.put(11, 20);
        System.out.println("KEYS: " + map.keySet());
        System.out.println("VALUES: " + map.values());
        System.out.println("SIZE: " + map.size());
        System.out.println(map.get(3));
        System.out.println(map.get(11));
    }
}
