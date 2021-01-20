package clase.clase;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Curs implements OperatiiCurs {
	int id;
	String nume;
	String descriere;
	Profesor profu;
	ArrayList<Student> studenti;
	Map<Student, Integer> note;

public Curs(int id,String nume, String descriere) {
	this.id=id;
	this.nume = nume;
	this.descriere = descriere;
	profu = new Profesor();
	studenti = new ArrayList();

}
	public Curs(int id,String nume, String descriere, Profesor profu, ArrayList<Student> studenti) {
		this.id=id;
		this.nume = nume;
		this.descriere = descriere;
		this.profu = profu;
		this.studenti = studenti;
		this. note=new HashMap<>();
	}

	public Curs() {

	}


	public void UpdateProfesor(Profesor profu) {
		this.profu = profu;
	}



	public void AddStudent(Student student) {
		studenti.add(student);
	}

	@Override
	public void RemoveStudent(Student student) {
		studenti.remove(student);
	}

	@Override
	public void UpdateStudent(Student student) {
		for (Student s : studenti) {
			if ((student.nume == s.nume) && (student.prenume == s.prenume))
				s.grupa = student.grupa;
		}
	}

	@Override
	public void UpdateCurs(String nume, String descriere) {
		this.nume = nume;
		this.descriere = descriere;
	}

	@Override
	public String toString() {
		String str = "Curs: " + "nume=" + nume + ", descriere=" + descriere + ",\nprofu=" + profu +",\n numar studenti="+studenti.size()+",\nstudenti:\n";
		for (Student s : studenti) {
			str += s + "\n";
		}
		return str;
	}

	public String getNume() {
		return nume;
	}


	public void noteazaStudent(Student studentNotat, int nota) {
		if (studenti.contains(studentNotat))
			note.put(studentNotat, nota);
	}

	//
	public void raportStudentiInscrisi() {
		for (Student s : studenti) {
			System.out.println(s);
		}
	}

	public void raportNoteStudenti() {
		for (Student s : studenti)
			System.out.println(s+" este notat si  nota e: "+ note.get(s));
	}

	//
	public void raportMediaStudentilor() {
		ArrayList<Integer> arr=new ArrayList<Integer>(note.values());
		ArrayList<Integer> jum1=new ArrayList<>();
		ArrayList<Integer> jum2=new ArrayList<>();

		for (int i=0;i<arr.size()/2;i++){
			jum1.add(arr.get(i));
		}
		for(int i=arr.size()/2;i<arr.size();i++)
		{
			jum2.add(arr.get(i));
		}
		MediaElevilorPeDouaFire m=new MediaElevilorPeDouaFire(jum1);


		MediaElevilorPeDouaFire m1=new MediaElevilorPeDouaFire(jum2);
		try {
			m.t.join();
			m1.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double media2=m1.media;
		double media1=m.media;
		System.out.println("media:"+(media1+media2)/2);
	}

	public Profesor getProfu() {
		return profu;
	}

	public boolean isEqual(Curs c) {
		return c.getNume().equals(nume);
	}

}