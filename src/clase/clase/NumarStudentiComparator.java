package clase.clase;

import java.util.Comparator;

public class NumarStudentiComparator implements Comparator<Curs> {

    @Override
    public int compare(Curs o1, Curs o2) {
        return o1.studenti.size()-o2.studenti.size();    }
}
