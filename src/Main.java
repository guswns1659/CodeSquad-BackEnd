import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        testIOStream();
//        testCollection();
        testOptional();
    }

    private static void testOptional() {
        Optional<String> optionalS = Optional.of("String-String");
        Optional<String> optionalS2 = Optional.ofNullable("String");
        Stream.of("String-String")
                .flatMap(s -> Stream.of(s.split("-")))
                .forEach(System.out::println);
    }

    private static void testCollection() {
        int[] ints = new int[3];
    }

    private static void testIOStream() {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("test.md"));
             BufferedReader br =
                     new BufferedReader(new FileReader("test.md"))) {
            bw.write("hello");
            while (br.readLine() == null) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("에러");
            e.printStackTrace();
        }
        System.out.println("catch() 이후");

    }
}
