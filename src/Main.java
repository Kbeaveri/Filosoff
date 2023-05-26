public class Main {
    public static void main(String[] args) throws Exception {

        Philosoff[] philosophers = new Philosoff[5];
        Object[] forks = new Object[philosophers.length];

        for(int i = 0; i<forks.length; i++){
            forks[i] = new Object();
        }

        for(int j = 0; j<philosophers.length; j++){
            Object leftFork = forks[j];
            Object rightFrk = forks[(j+1) % forks.length];

            if(j == philosophers.length - 1){
                philosophers[j] = new Philosoff(rightFrk, leftFork);
            }else{
                philosophers[j] = new Philosoff(leftFork, rightFrk);
            }

            Thread thread = new Thread(philosophers[j], "Философ номер  " + (j+1));
            thread.start();
        }
    }
}