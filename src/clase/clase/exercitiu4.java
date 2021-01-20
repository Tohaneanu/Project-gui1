package clase.clase;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class exercitiu4 {


    Student[] array = new Student[] { new Student(1,"S1", "S2", 1), new Student(2,"S3", "S4", 1),
            new Student(3,"S4", "S5", 1), new Student(4,"S6", "S7", 1), new Student(5,"S8", "S9", 1),};
    int i = 0;
    public void scrie() {



        synchronized (this) {
            for (; i < array.length; ) {

                try {
                    File studenti = new File("Studenti1.csv");

                    if (!studenti.exists()) {
                        studenti.createNewFile();
                    }
                    FileWriter fw = new FileWriter(studenti.getAbsoluteFile(),true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("Nume: " +array[i].nume+" prenume: "+array[i].prenume+ " grupa: "+ array[i].grupa+ "\n");



                    bw.close();
                }
                catch (IOException e){
                    System.out.println(" error");
                }




                System.out.println("thread name " + Thread.currentThread().getName() + "  : " + array[i]);
                i++;

                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }



    }
    public void checkDub() throws IOException {

        BufferedReader br=null;
        String line = "";
        String COMA_DELIMITER = ",";


        FileWriter fileWriter = new FileWriter("Studenti1.csv");
        HashSet<String> lines = new HashSet<>();



        try {
            br = new BufferedReader(new FileReader("Studenti1.csv"));
            while ((line = br.readLine()) != null) {
                if (lines.add(line)) {
                    fileWriter.append(line);
                    fileWriter.append("\n");
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}}
