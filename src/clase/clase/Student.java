package clase.clase;

public class Student extends Persoana {
	int id;
	int grupa;

	public Student(int id,String nume, String prenume, int grupa) {
		this.id=id;
		this.nume = nume;
		this.prenume = prenume;
		this.grupa = grupa;

	}

	public Student() {
		this.prenume="";
		this.nume="";
		this.grupa=0;
	}

	@Override
	public String toString() {
		return "Student{" + "nume=" + nume + ", prenume=" + prenume + ", grupa=" + grupa + '}';
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getGrupa() {
		return grupa;
	}

	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}
}