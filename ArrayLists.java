import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list);
        list.add(1, 3);
        list.set(2, 4);
        list.add(2, 2);
        System.out.println(list);
        System.out.println(list.contains(4));

        ArrayList<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        for (int i = 0; i < letters.size(); i++) {
            System.out.print(letters.get(i) + " ");
        }
    }
}
