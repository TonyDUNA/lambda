public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> { // заменили интерф Runnable лямбдой
            System.out.println("Hello!");
        });
    }
}
