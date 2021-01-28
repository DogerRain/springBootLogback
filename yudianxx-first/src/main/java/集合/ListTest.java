package 集合;


import java.util.*;

/**
 * @author huangyongwen
 * @date 2021/1/27
 * @Description
 */
public class ListTest {
    public static void main(String[] args) {
        testArrayList();


    }

    static void testArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("五菱宏光");
        arrayList.add("五菱宏光");
        arrayList.add("宝马");
        arrayList.add(null);

        arrayList.remove("五菱宏光");

        for (String str : arrayList) {
            System.out.println(str);
        }


    }

    static void test() {
        List<String> linkedList = new LinkedList<>();

    }

    static void testVector() {
        Vector<String> vector = new Vector();
        vector.add("五菱宏光");

        for (String str : vector) {
            System.out.println(str);
        }
    }
}
