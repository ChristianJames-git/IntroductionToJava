import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class GenMethods<E> {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> noDupes = new ArrayList<E>();
        for (E element : list) {
            if (!noDupes.contains(element))
                noDupes.add(element);
        }
        return noDupes;
    }

    public static <E> void shuffle(ArrayList<E> list) {
        Random rand = new Random(340L);
        for (int i = 0; i < 30; i++) {
            Collections.swap(list, rand.nextInt(list.size()), rand.nextInt(list.size()));
        }
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(key))
                return i;
        }
        return -1;
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        Arrays.sort(list);
        return list[list.length - 1];
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        int counter = 0;
        for (E listSub[] : list) {
            for (E element2 : listSub) {
                if (max.compareTo(element2) < 0)
                    max = element2;
            }
            counter++;
        }
        return max;
    }

    public String getIdentificationString() {
        return "Program 7a, Christian James";
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer[] list = new Integer[n];
        List<Integer> linked = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list[i] = input.nextInt();
            linked.add(list[i]);
        }
        System.out.println( Arrays.toString(list) );
        System.out.println(linked);
        Integer k = input.nextInt();
        int r = linearSearch(list, k);
        System.out.println(r != -1 ? "Key " + k + " was found at position " + r : "Key " + k + " was not found");
        System.out.println(max(list) + " is the max element");
        int m = input.nextInt();
        int p = input.nextInt();
        Integer[][] list2 = new Integer[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                list2[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p-1; j++) {
                System.out.print(list2[i][j] + " ");
            }
            System.out.println(list2[i][p-1]);
        }
        System.out.println(max(list2) + " is the max element");
        ArrayList<Integer> alist = new ArrayList<>();
        for (int i = 0; i < linked.size(); i++) {
            alist.add(linked.get(i));
        }
        System.out.println(alist);
        alist = removeDuplicates(alist);
        System.out.println(alist);
        shuffle(alist);
        System.out.println(alist);
        System.out.println(max(alist) + " is the max element");
    }
}