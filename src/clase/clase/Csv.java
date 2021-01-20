package clase.clase;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Csv {
    File studenti, profesori,cursuri;

    public Csv() {
        try {
            this.studenti = new File("studenti.csv");
            this.profesori = new File("profesori.csv");
            this.cursuri = new File("cursuri.csv");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<Student> extragereStudentiDinFisier() {
        ArrayList<Student> studentList = new ArrayList<Student>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(studenti));
            String row= csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Student student=new Student(Integer.valueOf(data[0]),data[1],data[2],Integer.valueOf(data[3]));
                studentList.add(student);
            }
            csvReader.close();
        }
        catch (IOException | NumberFormatException e){
            System.out.println("eroare la citirea din fisier");
        }

        return studentList;
    }
    public ArrayList<Profesor> extrageProfesorDinFisier(){
        ArrayList<Profesor> profesorList = new ArrayList<Profesor>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(profesori));
            String row=csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Profesor profesor=new Profesor(Integer.valueOf(data[0]),data[1],data[2]);
                profesorList.add(profesor);
            }
            csvReader.close();
        }
        catch (IOException | NumberFormatException e){
            System.out.println("eroare la citirea din fisier");
        }
        return profesorList;
    }
    public ArrayList<Curs> extrageCursDinFisier(ArrayList<Profesor> profesorList,ArrayList<Student> studentList){
        ArrayList<Curs> cursList = new ArrayList<Curs>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(cursuri));
            String row=csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Curs curs=new Curs(Integer.valueOf(data[0]),data[1],data[2],null,null);
                if (data.length>3){
                    int idProf=Integer.valueOf(data[3]);
                    for(Profesor p:profesorList){
                        if (p.id==idProf){
                            curs.profu=p;
                            break;
                        }
                    }
                }
                if (data.length>4)
                {
                    int index=4;
                    curs.studenti=new ArrayList<Student>();
                    while (index < data.length)
                    {
                        int studentid = Integer.valueOf(data[index]);
                        for (Student s : studentList) {
                            if (s.id == studentid)
                            {
                                curs.studenti.add(s);
                                break;
                            }
                        }
                        index++;
                    }
                }
                cursList.add(curs);
            }
            csvReader.close();
        }
        catch (IOException | NumberFormatException e){
            System.out.println("eroare la citirea din fisier");
        }
        return cursList;
    }
    public void salvareStudentiInFisier(ArrayList<Student> studentList){

        try{
            BufferedWriter wr=new BufferedWriter(new FileWriter(studenti));
            if (studenti.length()==0) {
                wr.write("Id");
                wr.write(",");
                wr.write("Nume");
                wr.write(",");
                wr.write("Prenume");
                wr.write(",");
                wr.write("Grupa");
                wr.write(",");
                wr.write("\n");
            }

            for(Student s: studentList){
                wr.write(String.valueOf(s.id));
                wr.write(",");
                wr.write(s.nume);
                wr.write(",");
                wr.write(s.prenume);
                wr.write(",");
                wr.write(String.valueOf(s.grupa));
                wr.write(",");
                wr.write("\n");
            }
            wr.flush();
            wr.close();
        }
        catch (IOException e){
            System.out.println(" error");
        }

    }
    public void salvareProfesoriInFisier(ArrayList<Profesor> profesorList){

        try{
            FileWriter wr=new FileWriter(profesori);
            if(profesori.length()==0) {
                wr.append("Id");
                wr.append(",");
                wr.append("Name");
                wr.append(",");
                wr.append("Prenume");
                wr.append(",");
                wr.append("\n");
            }
            for(Profesor p: profesorList){

                wr.append(String.valueOf(p.id));
                wr.append(",");
                wr.append(p.nume);
                wr.append(",");
                wr.append(p.prenume);
                wr.append(",");
                wr.append("\n");
            }
            wr.flush();
            wr.close();
        }
        catch (IOException e){
            System.out.println(" error");
        }

    }
    public void salvareCursuriInFisier(List<Curs> cursList){

            try{
            FileWriter wr=new FileWriter(cursuri);
if (cursuri.length()==0){
    wr.append("Id");
    wr.append(",");
    wr.append("Nume");
    wr.append(",");
    wr.append("Descriere");
    wr.append(",");
    wr.append("IdProfesor");
    wr.append(",");
    wr.append("Id_uriStudenti");
    wr.append(",");
    wr.append("\n");
}
            for(Curs c: cursList){
                wr.append(String.valueOf(c.id));
                wr.append(",");
                wr.append(c.nume);
                wr.append(",");
                wr.append(c.descriere);
                wr.append(",");
                wr.append(String.valueOf(c.profu.id));
                wr.append(",");
                if(!(c.studenti ==null)) {
                    for (Student s : c.studenti) {
                        wr.append(String.valueOf(s.id));
                        wr.append(",");
                    }
                }
                wr.append("\n");
            }
            wr.flush();
            wr.close();
        }
        catch (IOException e){
            System.out.println(" error");
        }

    }

    }

