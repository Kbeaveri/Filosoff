public class Philosoff implements Runnable {
    private  Object leftFork;
    private  Object rightFork;

    Philosoff(Object left, Object right){
        this.leftFork = left;
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random()*5000)));
    }

    @java.lang.Override
    public void run() {
        try{
            while(true){
                doAction(": Думает");
                synchronized (leftFork) {
                    doAction(": Взял левую вилку");
                    synchronized (rightFork) {
                        doAction(": Взял правую вилку и начал есть");
                        doAction(": Положил правую вилку");
                    }
                    doAction(": Положил левую вилку и вернулся к размышлением");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}