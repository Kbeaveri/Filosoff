public class Main {
    public static void main(String[] args) throws Exception {

        Philosoff[] philosoff = new Philosoff[5];
        Object[] forks = new Object[philosoff.length];

        for(int i = 0; i<forks.length; i++){
            forks[i] = new Object();
        }

        for(int j = 0; j<philosoff.length; j++){
            Object leftFork = forks[j];
            Object rightFrk = forks[(j+1) % forks.length];

            if(j == philosoff.length - 1){
                philosoff[j] = new Philosoff(rightFrk, leftFork);
            }else{
                philosoff[j] = new Philosoff(leftFork, rightFrk);
            }

            Thread thread = new Thread(philosoff[j], "Философ номер  " + (j+1));
            thread.start();
        }
    }
}