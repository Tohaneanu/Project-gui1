package clase.clase;

import java.util.Comparator;

public class NumeProfesorComparator implements Comparator<Curs> {

    @Override
    public int compare(Curs o1, Curs o2) {
        if(o1.profu.nume.equals(o2.profu.nume))
            return o1.profu.prenume.compareTo(o2.profu.prenume);
        return o1.profu.nume.compareTo(o2.profu.nume);
    }
}
