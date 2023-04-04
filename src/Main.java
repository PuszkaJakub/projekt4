public class Main {
    public static void main(String[] args) {

        CustomList<String> test1 = new CustomList<>();
        test1.addFirst("1");
        test1.addLast("2");
        System.out.println(test1.getFirst()+" "+ test1.getLast());


    }
}