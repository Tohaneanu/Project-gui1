package clase.clase;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Test {
	public static void main(String[] args) {
//		//definire studenti
//		Set<Student> studenti=new HashSet();
//		Student s=new Student("Ion","Pop",2);
//	//	Student st=new Student("dasd","faadf",345425);
//	//	Student st2=new Student("aasf","dfe",1);
//	//	Student st3=new Student("fff","ttt",6);
//		studenti.add(s);
//		studenti.add(st);
//		studenti.add(st2);
//		studenti.add(st3);
//		//definire profesor
//		Profesor prof = new Profesor("Anton","Panaitescu");
//		Profesor prof1 = new Profesor("Badea","rafea");
//		Profesor prof2 = new Profesor("Ton","asd");
//		Profesor prof3 = new Profesor("Aldica","fg");
//		Profesor prof4 = new Profesor("Care","yetsh");
//		//definire curs nou
//		Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,\n" +
//		"diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
//		"suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple", prof, studenti);
//		Curs curs1=new Curs("Sport","Educatie fizica",prof1,studenti);
//		Curs curs2=new Curs("Electro","ada daaff",prof2,studenti);
//		Curs curs3=new Curs("Analiza","matematica",prof3,studenti);
//		Curs curs4=new Curs("Info","daad",prof4,studenti);
//		ManagerCursuri cursuri = new ManagerCursuri();
//		cursuri.AddCurs(curs);
//		cursuri.AddCurs(curs1);
//		cursuri.AddCurs(curs2);
//		cursuri.AddCurs(curs3);
//		cursuri.AddCurs(curs4);
//
//		Student st4=new Student("Egs","GGG",87);
//		curs4.AddStudent(st4);
//		curs2.AddStudent(new Student("Gio","psaf",3));
//		curs2.AddStudent(new Student("Ezi","ladfa",89));
//
//		curs.noteazaStudent( st, 8);
//		curs.noteazaStudent( st2, 10);
//		curs.noteazaStudent(s,4);
//		curs.noteazaStudent(st3,10);
//		curs.noteazaStudent(st4,7);
//
//
//		System.out.println("		raportare note studenti:");
//		curs.raportNoteStudenti();
//		System.out.println(" 		media notelor:");
//		curs.raportMediaStudentilor();
//		System.out.println(" 		media note date de un profesor:");
//		cursuri.mediaNotelorDateDeProfesor(prof);
//		cursuri.NoteazaStudent(curs.getNume(),st4,10);
//		cursuri.RaportNoteTotiStudentii();
//
//
//		System.out.println(" 			AFISARE CURSURI INITIALE:");
//		cursuri.AfiseazaCursuriLaConsola();
//
//			NameComparator comp=new NameComparator();
//		cursuri.cursuri.sort(comp);
//		System.out.println("			SORTARE CURSURI DUPA NUME:");
//		cursuri.AfiseazaCursuriLaConsola();
//
//		NumeProfesorComparator comp_prof=new NumeProfesorComparator();
//		cursuri.cursuri.sort(comp_prof);
//		System.out.println(" 			SORTARE CURSURI DUPA NUME PROFESOR:");
//		cursuri.AfiseazaCursuriLaConsola();
//
//		NumarStudentiComparator comp_numar_studenti=new NumarStudentiComparator();
//		cursuri.cursuri.sort(comp_numar_studenti);
//		System.out.println(" 			SORTARE CURSURI DUPA NUMARUL DE STUDENTI: "	);
//		//cursuri.AfiseazaCursuriLaConsola();
//		cursuri.salvareStudentiInFisier();
//		///////////////////////////////////////////////////////////////////  LAB 6
//

//		Csv a = new Csv();
//		ArrayList<Student> Studenti = new ArrayList<>(a.extragereStudentiDinFisier());
//		ArrayList<Profesor> profesori = new ArrayList<>(a.extrageProfesorDinFisier());
//		ArrayList<Curs> cursuri=new ArrayList<>(a.extrageCursDinFisier(profesori,Studenti));
//		for (Curs c:cursuri)
//			System.out.println("curs: "+c.getNume()+" descriere: "+c.descriere+" profesor: "+c.profu+" studenti: "+c.studenti);
//		ArrayList<Student> st = new ArrayList<Student>();
//		st.add(new Student(1, "Pop", "Petrescu", 23));
//		st.add(new Student(2, "Tudose", "Raul", 56));
//		st.add(new Student(3, "Tudodsase", "Raulica", 560));
//		a.salvareStudentiInFisier(st);
//		Profesor prof = new Profesor(1, "Danciu", "gabriel");
//		Curs curs = new Curs(1, "Pclp", "programarea calculatoarelor si limbajele programarii", prof, st);
//		ArrayList<Curs> cs = new ArrayList<>();
//		cs.add(curs);
//		a.salvareCursuriInFisier(cs);

		Student s=new Student(1,"Elev1","Daa",33);
		Student s1=new Student(2,"Elev2","Daa",332);
		Student s2=new Student(3,"Elev3","Daa",332);
		Student s3=new Student(4,"Elev4","Daa",333);
		ArrayList<Student> arr=new ArrayList<>();
		arr.add(s);
		arr.add(s1);
		arr.add(s2);
		arr.add(s3);
		Profesor p=new Profesor(1,"das","daad");
		Curs c= new Curs(1,"Pclp","daa",p,arr);
		ManagerCursuri manager= new ManagerCursuri();

		manager.extrageCursuri();
//		manager.AddCurs(c);
//
	//manager.salveazaCursuri();
	//	manager.AfiseazaCursuriLaConsola();
		c.noteazaStudent(s,10);
		c.noteazaStudent(s1,9);
		c.noteazaStudent(s2,10);
		c.noteazaStudent(s3,9);

	//	c.raportNoteStudenti();
		//c.raportMediaStudentilor();
//////////////////////////////////////////exercitiu 4
		final exercitiu4 er=new exercitiu4();
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				er.scrie();

			}
		}, "T1");
		Thread t21=new Thread(new Runnable() {

			@Override
			public void run() {
				er.scrie();

			}
		}, "T2");
		t1.start();
		t21.start();
		try {
			er.checkDub();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MySwing swing=new MySwing();

	}

}
///////////////////// MAI PUNE SUB BUTOANE O LISTA CU TOT CE AI IN CSV URI, CARE SA FIE MEREU DESCHISA (PENTRU A PUTEA VEDEA TOT)+
/////////////////////+ TRATARE EXCEPTII----facuta cred.
/////////////////////+ BUTON NOTARE STUDENTI++ RAPORT MEDIA NOTELOR
///CA SA FIE FRUMOS