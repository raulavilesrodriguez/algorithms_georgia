public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addToFront(3);
        list.addToFront(8);
        list.addToFront(5);
        list.addToBack(1);
        list.addToBack(14);
        System.out.println(list.toString());
        System.out.println(list.size());

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addToBack(0);
        list2.addToBack(1);
        list2.addToBack(2);
        list2.addToBack(3);
        list2.addToBack(4);
        list2.addToBack(5);
        list2.addToBack(6);
        list2.addToBack(7);
        list2.addToBack(8);
        System.out.println(list2.toString());
        System.out.println(list2.size());
        System.out.println(list2.removeFromFront());
        System.out.println(list2.toString());
        System.out.println(list2.removeFromFront());
        System.out.println(list2.toString());
        System.out.println(list2.removeFromFront());
        System.out.println(list2.toString());
        System.out.println(list2.removeFromBack());
        System.out.println(list2.toString());
        System.out.println(list2.removeFromBack());
        System.out.println(list2.toString());

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.addToBack(0);
        list3.addToBack(1);
        list3.addToBack(2);
        list3.addToBack(3);
        list3.addToBack(4);
        list3.addToBack(5);
        list3.addToBack(6);
        list3.addToBack(7);
        list3.addToBack(8);
        System.out.println(list3.toString());
        list3.addToBack(9);
        System.out.println(list3.toString());

        ArrayList<String> list4 = new ArrayList<>(5);
        list4.addToBack("hi");
        list4.addToBack("cata");
        list4.addToBack("fia");
        list4.addToBack("presa");
        list4.addToBack("foca");
        System.out.println(list4.toString());
        System.out.println(list4.get(1));
        list4.addToFront("pil");
        System.out.println(list4.toString());
        list4.add(2, "fiera");
        System.out.println(list4.toString());
        list4.remove(5);
        System.out.println(list4.toString());
        list4.clear();
        System.out.println(list4.toString());

        ArrayList<String> list5 = new ArrayList<>(5);
        System.out.println(list5.toString());
    }
}
