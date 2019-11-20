import java.util.ArrayList;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        char[] ca = {'a', 'b'};
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('b');
        System.out.println(ca);
        System.out.println(ca.toString()); // 返回的是数组的地址
        System.out.println(characters);
    }
}
