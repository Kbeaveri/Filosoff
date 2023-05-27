public class Philosoff implements Runnable {
    private  Object leftFork;
    private  Object rightFork;

    Philosoff(Object left, Object right){
        this.leftFork = left;
        this.rightFork = right;
    }

    @Override
    public void run() {
        try{
            while(true){
                waiter("Думает");
                synchronized (leftFork) {
                    waiter("Взял левую вилку");
                    synchronized (rightFork) {
                        waiter("Взял правую вилку и начал есть");
                        waiter("Положил правую вилку");
                    }
                    waiter("Положил левую вилку и вернулся к размышлением");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void waiter(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random()*5000)));
    }
}