package clase.clase;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MySwing extends JFrame {
    JFrame f;
    JFrame[] operatia = new JFrame[8];
    JPanel panel;

    MySwing() {
        f = new JFrame("Database");
        panel = new JPanel();
        for (int i = 0; i < operatia.length; i++) {
            operatia[i] = new JFrame("INTRODUCETI DATELE CORESPUNZATOARE!");
            operatia[i].setVisible(false);
        }

        Button b = new Button("Adaugare curs");
        Button b1 = new Button("Editare curs");
        Button b2 = new Button("Stergere curs");
        Button b3 = new Button("Adaugare student");
        Button b4 = new Button("Editare student");
        Button b5 = new Button("Stergere student");
        Button b7 = new Button("Editare profesor");
        Button b8 = new Button("Stergere profesor");
        b.setBounds(0, 0, 150, 30);
        b1.setBounds(0, 30, 150, 30);
        b2.setBounds(0, 60, 150, 30);
        b3.setBounds(0, 90, 150, 30);
        b4.setBounds(0, 120, 150, 30);
        b5.setBounds(0, 150, 150, 30);

        b7.setBounds(0, 180, 150, 30);
        b8.setBounds(0, 210, 150, 30);

        panel.add(b);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);

        panel.add(b7);
        panel.add(b8);


        //     Border bord =BorderFactory.createLineBorder(Color.BLACK, 5);

        f.setSize(1000, 310);
        Csv csv = new Csv();
        ArrayList<Student> studenti1 = csv.extragereStudentiDinFisier();
        ArrayList<Profesor> profesori1 = csv.extrageProfesorDinFisier();
        ArrayList<Curs> cursuri1 = csv.extrageCursDinFisier(profesori1, studenti1);
        ManagerCursuri mng = new ManagerCursuri();
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 500, 100);
                textArea.setText("Scrie numele cursului pe care doriti sa l stergeti!");

                JTextField text = new JTextField();
                text.setBounds(20, 140, 150, 50);
                text.setBackground(Color.GRAY);
                JButton button = new JButton("Stergeti!");
                button.setBounds(250, 150, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String curs = text.getText();
                        text.setText("");
                        operatia[2].dispose();

                        for (int i = 0; i < cursuri1.size(); i++) {
                            String c_nume = cursuri1.get(i).nume;
                            if (c_nume.equals(curs))
                                cursuri1.remove(cursuri1.get(i));

                        }
                        csv.salvareCursuriInFisier(cursuri1);
                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();

                    }
                });

                operatia[2].add(textArea);
                operatia[2].add(text);
                operatia[2].add(button);
                operatia[2].setSize(450, 310);

                operatia[2].setLayout(null);
                operatia[2].setVisible(true);
                operatia[2].setResizable(false);
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 350, 50);
                textArea.setText("Scrieti datele cursului pe care doriti sa l adaugati!");
                JLabel nume = new JLabel();
                nume.setBounds(0, 35, 100, 40);
                nume.setText("Numele Curs:");
                JTextField numetxt = new JTextField();
                numetxt.setBounds(110, 35, 300, 40);
                numetxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel descriere = new JLabel();
                descriere.setBounds(0, 75, 100, 40);
                descriere.setText("Descriere Curs:");
                JTextField descrieretxt = new JTextField();
                descrieretxt.setBounds(110, 75, 300, 40);
                descrieretxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel numeprof = new JLabel();
                numeprof.setBounds(0, 115, 90, 40);
                numeprof.setText("Nume Profesor:");
                JTextField numeproftxt = new JTextField();
                numeproftxt.setBounds(110, 115, 300, 40);
                numeproftxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel prenumprof = new JLabel();
                prenumprof.setBounds(0, 155, 110, 40);
                prenumprof.setText("Prenume Profesor:");
                JTextField prenumproftxt = new JTextField();
                prenumproftxt.setBounds(110, 155, 300, 40);
                prenumproftxt.setBackground(Color.getHSBColor(255, 255, 153));

                JButton button = new JButton("Adaugati!");
                button.setBounds(250, 240, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Profesor p = new Profesor(profesori1.size() + 1, numeproftxt.getText(), prenumproftxt.getText());
                        profesori1.add(p);
                        csv.salvareProfesoriInFisier(profesori1);
                        Curs c = new Curs(cursuri1.size() + 1, numetxt.getText(), descrieretxt.getText(), p, new ArrayList<Student>());

                        cursuri1.add(c);
                        numetxt.setText("");
                        prenumproftxt.setText("");
                        descrieretxt.setText("");
                        numeproftxt.setText("");

                        csv.salvareCursuriInFisier(cursuri1);
                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();
                        operatia[0].dispose();
                    }
                });

                operatia[0].add(textArea);
                operatia[0].add(nume);
                operatia[0].add(numetxt);
                operatia[0].add(descriere);
                operatia[0].add(descrieretxt);
                operatia[0].add(numeprof);
                operatia[0].add(numeproftxt);
                operatia[0].add(prenumprof);
                operatia[0].add(prenumproftxt);

                operatia[0].add(button);
                operatia[0].setSize(450, 310);

                operatia[0].setLayout(null);
                operatia[0].setVisible(true);
                operatia[0].setResizable(false);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 350, 50);
                textArea.setText("Scrieti numele cursului pe care doriti sa l modificati!");
                JLabel nume = new JLabel();
                nume.setBounds(0, 35, 100, 40);
                nume.setText("Curs:");
                JTextField numetxt = new JTextField();
                numetxt.setBounds(0, 85, 330, 40);
                numetxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel descriere = new JLabel();
                descriere.setBounds(0, 125, 240, 40);
                descriere.setText("Introduceti noua descriere a Cursului dat:");
                JTextField descrieretxt = new JTextField();
                descrieretxt.setBounds(0, 165, 330, 40);
                descrieretxt.setBackground(Color.getHSBColor(255, 255, 153));


                JButton button = new JButton("Modificati!");
                button.setBounds(250, 240, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String curs = numetxt.getText();

                        for (int i = 0; i < cursuri1.size(); i++) {
                            String c_nume = cursuri1.get(i).nume;
                            if (c_nume.equals(curs))
                                cursuri1.get(i).descriere = descrieretxt.getText();

                        }

                        numetxt.setText("");
                        descrieretxt.setText("");
                        csv.salvareCursuriInFisier(cursuri1);
                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();

                        operatia[1].dispose();
                    }
                });
                operatia[1].add(textArea);
                operatia[1].add(nume);
                operatia[1].add(numetxt);
                operatia[1].add(descriere);
                operatia[1].add(descrieretxt);


                operatia[1].add(button);
                operatia[1].setSize(450, 310);

                operatia[1].setLayout(null);
                operatia[1].setVisible(true);
                operatia[1].setResizable(false);
            }

        });

        b3.addActionListener(new ActionListener() {         ///////////// adaugare student
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 350, 50);
                textArea.setText("Scrieti datele Studentului pe care doriti sa l adaugati!");

                JLabel numec = new JLabel();
                numec.setBounds(0, 35, 300, 40);
                numec.setText("Numele cursului la care doriti sa adaugati studentul:");
                JTextField numectxt = new JTextField();
                numectxt.setBounds(10, 75, 300, 40);
                numectxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel nume = new JLabel();
                nume.setBounds(0, 115, 150, 40);
                nume.setText("Nume student:");
                JTextField numetxt = new JTextField();
                numetxt.setBounds(130, 115, 300, 40);
                numetxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel descriere = new JLabel();
                descriere.setBounds(0, 155, 150, 40);
                descriere.setText("Prenume student:");
                JTextField descrieretxt = new JTextField();
                descrieretxt.setBounds(130, 155, 300, 40);
                descrieretxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel numeprof = new JLabel();
                numeprof.setBounds(0, 195, 90, 40);
                numeprof.setText("Grupa:");
                JTextField numeproftxt = new JTextField();
                numeproftxt.setBounds(130, 195, 300, 40);
                numeproftxt.setBackground(Color.getHSBColor(255, 255, 153));


                JButton button = new JButton("Adaugati!");
                button.setBounds(250, 240, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Student s = new Student(studenti1.size() + 1, numetxt.getText(), descrieretxt.getText(), Integer.valueOf(numeproftxt.getText()));
                            for (int i = 0; i < cursuri1.size(); i++) {
                                if (cursuri1.get(i).nume.equals(numectxt.getText()))
                                    cursuri1.get(i).studenti.add(s);
                            }
                            studenti1.add(s);
                            csv.salvareStudentiInFisier(studenti1);
                            csv.salvareCursuriInFisier(cursuri1);

                        }catch (NumberFormatException exx){
                            JOptionPane.showMessageDialog(new JFrame(), "Nu este acceptat string pentru grupa!");
                        }

                        numectxt.setText("");
                        numetxt.setText("");
                        descrieretxt.setText("");
                        numeproftxt.setText("");

                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();
                        operatia[3].dispose();
                    }
                });
                operatia[3].add(textArea);
                operatia[3].add(numec);
                operatia[3].add(numectxt);
                operatia[3].add(nume);
                operatia[3].add(numetxt);
                operatia[3].add(descriere);
                operatia[3].add(descrieretxt);
                operatia[3].add(numeprof);
                operatia[3].add(numeproftxt);


                operatia[3].add(button);
                operatia[3].setSize(450, 310);

                operatia[3].setLayout(null);
                operatia[3].setVisible(true);
                operatia[3].setResizable(false);

            }
        });

        b4.addActionListener(new ActionListener() {  ////////////editare student
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 350, 50);
                textArea.setText("Scrieti numele studentului pe care doriti sa l modificati!");
                JLabel nume = new JLabel();
                nume.setBounds(0, 35, 100, 40);
                nume.setText("Nume:");
                JTextField numetxt = new JTextField();
                numetxt.setBounds(10, 85, 330, 40);
                numetxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel descriere = new JLabel();
                descriere.setBounds(0, 125, 240, 40);
                descriere.setText("Introduceti noua grupa:");
                JTextField descrieretxt = new JTextField();
                descrieretxt.setBounds(10, 165, 330, 40);
                descrieretxt.setBackground(Color.getHSBColor(255, 255, 153));


                JButton button = new JButton("Modificati!");
                button.setBounds(250, 240, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {



                        try {
                            for (Student s : studenti1) {
                                if (s.nume.equals(numetxt.getText())) {
                                    s.grupa = Integer.valueOf(descrieretxt.getText());
                                }
                            }
                        }catch (NumberFormatException exx){
                            JOptionPane.showMessageDialog(new JFrame(), "Nu este acceptat string pentru grupa!");
                        }
                        numetxt.setText("");
                        descrieretxt.setText("");
                        csv.salvareStudentiInFisier(studenti1);
                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();

                        operatia[4].dispose();
                    }
                });
                operatia[4].add(textArea);
                operatia[4].add(nume);
                operatia[4].add(numetxt);
                operatia[4].add(descriere);
                operatia[4].add(descrieretxt);


                operatia[4].add(button);
                operatia[4].setSize(450, 310);

                operatia[4].setLayout(null);
                operatia[4].setVisible(true);
                operatia[4].setResizable(false);
            }

        });

        b5.addActionListener(new ActionListener() {      ////stergere student
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 500, 100);
                textArea.setText("Scrie numele Studentului pe care doriti sa l stergeti!");

                JTextField text = new JTextField();
                text.setBounds(20, 140, 150, 50);
                text.setBackground(Color.GRAY);

                JButton button = new JButton("Stergeti!");
                button.setBounds(250, 150, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String student = text.getText();
                        text.setText("");
//                                for (Curs c: cursuri1){
//                                    for (Student s:c.studenti){
//                                        if (s.nume.equals(student))
//                                            c.studenti.remove(s);
//                                    }
//                                }
                        Student st = new Student();
                        for (Student s : studenti1) {
                            if (s.nume.equals(student)) {
                                st = s;
                                studenti1.remove(s);
                                break;
                            }
                        }
//                                for (Curs c:cursuri1){
//                                    if(c.studenti.)
//                                }

                        for (Curs c : cursuri1)
                            if (c.studenti.contains(st)) {
                                c.studenti.remove(st);
                            }

                        csv.salvareCursuriInFisier(cursuri1);

                        csv.salvareStudentiInFisier(studenti1);

                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();
                        operatia[5].dispose();

                    }
                });
                operatia[5].add(textArea);
                operatia[5].add(text);
                operatia[5].add(button);
                operatia[5].setSize(450, 310);

                operatia[5].setLayout(null);
                operatia[5].setVisible(true);
                operatia[5].setResizable(false);
            }

        });


        b7.addActionListener(new ActionListener() {      //////////editare profesor
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 350, 50);
                textArea.setText("Scrieti Numele profesorului pe care doriti sa l adaugati cursului!");

                JLabel numec = new JLabel();
                numec.setBounds(0, 35, 300, 40);
                numec.setText("Numele cursului la care doriti sa adaugati profesorul:");
                JTextField numectxt = new JTextField();
                numectxt.setBounds(10, 75, 300, 40);
                numectxt.setBackground(Color.getHSBColor(255, 255, 153));

                JLabel nume = new JLabel();
                nume.setBounds(0, 115, 150, 40);
                nume.setText("Nume Profesor:");
                JTextField numetxt = new JTextField();
                numetxt.setBounds(130, 115, 300, 40);
                numetxt.setBackground(Color.getHSBColor(255, 255, 153));


                JButton button = new JButton("Modificati!");
                button.setBounds(250, 240, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        for (Curs c : cursuri1) {
                            if (c.nume.equals(numectxt.getText())) {
                                for (Profesor p : profesori1) {
                                    if (p.nume.equals(numetxt.getText())) {
                                        c.profu = p;
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                        numectxt.setText("");
                        numetxt.setText("");

                        csv.salvareCursuriInFisier(cursuri1);

                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();
                        operatia[7].dispose();
                    }
                });
                operatia[7].add(textArea);
                operatia[7].add(numec);
                operatia[7].add(numectxt);
                operatia[7].add(nume);
                operatia[7].add(numetxt);


                operatia[7].add(button);
                operatia[7].setSize(450, 310);

                operatia[7].setLayout(null);
                operatia[7].setVisible(true);
                operatia[7].setResizable(false);


            }
        });

        b8.addActionListener(new ActionListener() {          /////stergere prof
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel textArea = new JLabel();
                textArea.setBounds(0, 0, 500, 100);
                textArea.setText("Scrie numele Profesorului pe care doriti sa l stergeti!");

                JTextField text = new JTextField();
                text.setBounds(20, 140, 150, 50);
                text.setBackground(Color.GRAY);

                JButton button = new JButton("Stergeti!");
                button.setBounds(250, 150, 150, 30);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String profesor = text.getText();
                        text.setText("");
//                                for (Curs c: cursuri1){
//                                    for (Student s:c.studenti){
//                                        if (s.nume.equals(student))
//                                            c.studenti.remove(s);
//                                    }
//                                }
                        Profesor st = new Profesor();
                        for (Profesor p : profesori1) {
                            if (p.nume.equals(profesor)) {
                                st = p;
                                profesori1.remove(p);
                                break;
                            }
                        }
//                                for (Curs c:cursuri1){
//                                    if(c.studenti.)
//                                }

                        for (Curs c : cursuri1)
                            if (c.profu.equals(st)) {
                                c.profu=new Profesor();
                            }

                        csv.salvareCursuriInFisier(cursuri1);

                        csv.salvareProfesoriInFisier(profesori1);

                        panel.validate();
                        panel.validate();
                        panel.repaint();
                        afisare();
                        panel.repaint();
                        operatia[6].dispose();

                    }
                });
                operatia[6].add(textArea);
                operatia[6].add(text);
                operatia[6].add(button);
                operatia[6].setSize(450, 310);

                operatia[6].setLayout(null);
                operatia[6].setVisible(true);
                operatia[6].setResizable(false);
            }
        });


        afisare();
        // f.pack();
//        f.revalidate();
        f.setSize(1000, 600);
        //      f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        afisare();
    }

    public void afisare() {
//        JButton auxi=new JButton();
//        panel.add(auxi);
        Csv csv = new Csv();

        ArrayList<Student> studenti = new ArrayList<>(csv.extragereStudentiDinFisier());
        ArrayList<Profesor> profesori = new ArrayList<>(csv.extrageProfesorDinFisier());
        ArrayList<Curs> cursuri = new ArrayList<>(csv.extrageCursDinFisier(profesori, studenti));
        int i = 0;
        JButton[] butoane = new JButton[cursuri.size()];
//        panel.removeAll();         //decomenteaza asta daca nu stii sa faci stergerea+ adauga butoanele direct in f
//        panel= new JPanel();          //si asta

        panel.setLayout(null);
        panel.setSize(130, 1000);
        panel.setBounds(200, 0, 130, 1000);
        panel.setBackground(Color.LIGHT_GRAY);

        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JButton)
                panel.remove(c);
        }
        Component[] compsonents = panel.getComponents();
        for (Component c : compsonents) {
            if (c instanceof JLabel)
                panel.remove(c);
        }

        for (Curs c : cursuri) {
            butoane[i] = new JButton(c.nume);
            butoane[i].setBounds(200, 30 * i, 150, 30);

            panel.add(butoane[i]);
            i++;

        }
        //

        f.add(panel);

        JLabel labels = new JLabel();
        JLabel profes = new JLabel();

        JLabel[] labels1 = new JLabel[10];
        for (int n = 0; n < labels1.length; n++) {
            labels1[n] = new JLabel();
        }
        for (JButton b : butoane)
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JLabel j : labels1) {
                        j.setText("");
                    }
                    labels.setBounds(400, 0, 170, 70);
                    String s = e.getActionCommand();
                    Curs c = new Curs();
                    for (Curs curs : cursuri)
                        if (s == curs.nume)
                            c = curs;
                    labels.setText("<html>Descriere: " + c.descriere + "<br><br>" + "Studenti:<br> </html>");
                    int i = 0;
                    if (!(c.studenti == null)) {
                        for (Student stud : c.studenti) {
                            labels1[i].setBounds(400, 70 * (i + 1), 200, 65);
                            labels1[i].setText("<html>" + (i + 1) + " :<br> Nume: " + stud.nume + "<br> Prenume: " + stud.prenume + " <br>Grupa: " + stud.grupa + "<br> </html>");
                            panel.add(labels1[i]);
                            i++;
                            panel.repaint();

                        }
                    } else {
                        labels1[0].setBounds(400, 60, 200, 65);
                        labels1[0].setText("Nu exista studenti la acest curs!");
                        panel.add(labels1[0]);
                        panel.repaint();
                    }

                    profes.setBounds(700, 0, 200, 70);
                    if (!(c.profu ==null)) {
                        profes.setText("<html>Profesor     <br> Nume Profesor: " + c.profu.nume + "<br>" + "Prenume Profesor: " + c.profu.prenume + "<br> </html>");
                    }
                    else{
                        profes.setText("<html>Profesor     <br> Nume Profesor: " + "<br>" + "Prenume Profesor: " + "<br> </html>");

                    }
                    panel.add(profes);

                    panel.add(labels);
                    panel.repaint();
                    panel.validate();
                    panel.repaint();


                }

            });
        panel.repaint();
        //       f.pack();
        f.setSize(1000, 600);
        //      f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
    }

}
