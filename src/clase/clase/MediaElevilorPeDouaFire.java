package clase.clase;

import java.util.ArrayList;

public class MediaElevilorPeDouaFire implements Runnable{
   ArrayList<Integer> note;
    Thread t;
    double media;
    MediaElevilorPeDouaFire(ArrayList<Integer> note){
        this.note=note;

         t=new Thread(this);
        System.out.println("firul: " +t.getName() + " a pornit!" );

        t.start();

    }
    @Override
    public void run() {
        try{

            int i=0;
            double sum=0;
            for(int integ: note) {
                System.out.println("firul:"+t.getName());
                sum+=integ;
                i++;
                Thread.sleep(5000);
            }
            this.media= sum/i;
        }
        catch (InterruptedException e){
            System.out.println("Primul fir intrerupt!");
        }
        System.out.println("incheierea  firuli"+ t.getName());
    }


}
