
interface Executable { // собственный интерфейс аналог структуры Runnable
    int execute(int x, int y);
}

class Runner { // класс, ждет в качестве аргумента класс, реализующий интерфейс executable
    public void run(Executable e) {
        int a = e.execute(10, 13);
        System.out.println(a);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        int a = 1;
        runner.run(new Executable() { // способ - анонимный класс
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        });


        runner.run((x, y) -> {
            return x + y + a;
        }); // способ через лямбду, можно даже не указыать тип и круглые скобки ,есди один аргумент
    }
}

