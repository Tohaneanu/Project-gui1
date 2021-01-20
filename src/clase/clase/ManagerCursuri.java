package clase.clase;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ManagerCursuri implements OperatiiManagerCursuri {
	List<Curs> cursuri=new ArrayList<>();

	public ManagerCursuri() {
		cursuri = new ArrayList<>(0);
	}
	public void salveazaCursuri(){
		Csv csv=new Csv();
		csv.salvareCursuriInFisier(cursuri);
	}
	public void extrageCursuri(){
		Csv csv=new Csv();

		cursuri=csv.extrageCursDinFisier(csv.extrageProfesorDinFisier(),csv.extragereStudentiDinFisier());
	}

	public void AddCurs(Curs curs) {
		curs.id= cursuri.size();

     cursuri.add(curs);
	}

	@Override
	public void UpdateCurs(Curs curs) {
		for (Curs c : cursuri) {
			if (c.nume==curs.nume)
			c=curs;
		}

	}

	@Override
	public void DeleteCurs(Curs curs) {
			cursuri.remove(curs);
	}

	public void AfiseazaCursuriLaConsola() {
		for (Curs c : cursuri)
			System.out.println(c);
	}
	
	public void RaportStudentiInscrisiLaCurs(String numeCurs) {
		for (Curs c : cursuri) {
			if (c.getNume().equals(numeCurs)) {
				c.raportStudentiInscrisi();
				return;
			}
		}
	}
//
	public void NoteazaStudent(String numeCurs, Student studentNotat, int nota) {
		for(Curs c: cursuri) {
			if ( c.getNume().equals(numeCurs)) {
				c.noteazaStudent(studentNotat, nota);
			}

		}
	}

	public void RaportNoteTotiStudentii() {
		for (Curs c : cursuri ) {
			c.raportNoteStudenti();
		}
	}

	public void mediaNotelorDateDeProfesor(Profesor prof) {
		System.out.println("Media notelor date de profesorul " + prof + ":");
		for ( Curs c: cursuri) {
			if ( c.getProfu().isEqual(prof)) {
				c.raportMediaStudentilor();
			}
		}





}
}