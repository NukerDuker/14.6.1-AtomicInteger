import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private AtomicInteger money = new AtomicInteger(10000);


    class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                if(money.get() >= 1000) {
                    money.addAndGet(-1000);
                    money.addAndGet(1000);
                }
            }
        }
    }


    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while(true) {
            System.out.println(bank.money.get());
            Thread.sleep(1000);
        }
    }

}