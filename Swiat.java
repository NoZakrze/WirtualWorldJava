package WirtualnySwiatJava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Swiat implements ActionListener, KeyListener {
    private Random random;
    private int rozmiar_n;
    private int rozmiar_m;
    private int licznik_organizmow;
    private Organizm[] organizmy;
    private JButton[][] Przyciski;
    private JFrame Okno;
    private JPanel Mapa;
    private JButton tura;
    private JButton zapis;
    private JButton odczyt;
    private JButton umiejetnosc;
    private JButton info;
    private JTextField[] napisy;
    private int licznik_napisow;
    private final int iloscnapisow=30;
    private final int szerokosc=900;
    private final int wysokosc=700;


    public Swiat() {
        random = new Random((new Date()).getTime());
        licznik_organizmow = 0;
        Okno = new JFrame("Norbert Zakrzewski 193391");
        Mapa = new JPanel();
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Okno.setSize(szerokosc, wysokosc);
        Okno.getContentPane().setBackground(Color.BLACK);
        Okno.setVisible(true);
        Okno.setResizable(false);
        Okno.addKeyListener(this);
        Okno.setFocusable(true);
        Mapa.setLayout(null);
        Mapa.setSize(szerokosc, wysokosc);
        Mapa.setBackground(Color.BLUE);
        Mapa.setVisible(true);
        String rn=JOptionPane.showInputDialog(Okno,"Podaj szerokosc mapy");
        String rm=JOptionPane.showInputDialog(Okno,"Podaj wysokosc mapy");
        rozmiar_n = Integer.parseInt(rn);
        rozmiar_m = Integer.parseInt(rm);
        organizmy = new Organizm[rozmiar_n * rozmiar_m];
        Przyciski = new JButton[rozmiar_m][rozmiar_n];
        napisy = new JTextField[iloscnapisow];
        licznik_napisow =0;
        planszaNapisy();
        przyciski();
        Mapa.repaint();
        Okno.add(Mapa);
        Okno.repaint();
    }
    public int GetM()
    {
        return rozmiar_m;
    }
    public int GetN()
    {
        return rozmiar_n;
    }
    public void dodajNapis(String s)
    {
        if(licznik_napisow<iloscnapisow)
        {
            napisy[licznik_napisow].setText(s);
            licznik_napisow++;
        }
    }
    public void GenerujSwiat()
    {
        int populacja = rozmiar_n * rozmiar_m / 50;

        int pY = random.nextInt(rozmiar_m);
        int pX = random.nextInt(rozmiar_n);
        Organizm nowy = new Czlowiek(pY, pX, this,random);
        dodajOrganizm(nowy);

        int los;
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Antylopa(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new BarszczSosnowskiego(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Guarana(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Lis(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Mlecz(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Owca(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Trawa(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new WilczeJagody(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Wilk(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        los = random.nextInt(7)+2;
        for (int i = 0; i < los; i++)
        {
            boolean wybor = false;
            while (!wybor)
            {
                int Y = random.nextInt(rozmiar_m);
                int X = random.nextInt(rozmiar_n);
                if (zajetePole(Y, X) == null)
                {
                    nowy = new Zolw(Y, X, this, random);
                    dodajOrganizm(nowy);
                    wybor = true;
                }
            }
        }
        zakonczture();
    }
    public Organizm zajetePole(int Y, int X)
    {
        Organizm wynik = null;
        for (int i = 0; i < rozmiar_m * rozmiar_n; i++)
        {
            if (organizmy[i] != null)
            {
                if (organizmy[i].getX() == X && organizmy[i].getY() == Y)
                {
                    wynik = organizmy[i];
                    break;
                }
            }
        }
        return wynik;
    }
    public Organizm[] getOrganizmy() {
        return organizmy;
    }
    public JButton[][]  getPrzyciski()
    {
        return Przyciski;
    }
    public void dodajOrganizm(Organizm nowy)
    {
        int i = 0;
        Organizm tmp = organizmy[i];
        while (tmp != null)
        {
            i++;
            tmp = organizmy[i];
        }
        organizmy[i] = nowy;
        licznik_organizmow++;
    }
    public void sortuj()
    {
        for (int i = 0; i < licznik_organizmow; i++)
        {
            if (organizmy[i] == null)
            {
                int j = licznik_organizmow;
                while (organizmy[j] == null)
                    j++;
                Organizm tmp = organizmy[i];
                organizmy[i] = organizmy[j];
                organizmy[j] = tmp;
            }
        }
        sortujZywe(organizmy, 0, licznik_organizmow - 1);
    }
    public void sortujZywe(Organizm[] t, int start, int koniec)
    {
        Organizm v = t[(start + koniec) / 2];
        int i = start;
        int j = koniec;
        do
        {
            while (t[i].getInicjatywa() > v.getInicjatywa() || (t[i].getInicjatywa() == v.getInicjatywa() && t[i].getWiek() > v.getWiek())) i++;
            while (t[j].getInicjatywa() < v.getInicjatywa() || (t[j].getInicjatywa() == v.getInicjatywa() && t[j].getWiek() < v.getWiek())) j--;
            if (i <= j)
            {
                Organizm tmp = t[i];
                t[i] = t[j];
                t[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < koniec) sortujZywe(t, i, koniec);
        if (j > start) sortujZywe(t, start, j);
    }
    public void usunMartwe()
    {
        for (int i = 0; i < rozmiar_n * rozmiar_m; i++)
        {
            if (organizmy[i] != null)
            {
                if (!organizmy[i].getZywe())
                {
                    organizmy[i] = null;
                    licznik_organizmow--;
                }
            }
        }
    }
    public Organizm getCzlowiek()
    {
        Organizm wynik = null;
        for (int i = 0; i < rozmiar_m * rozmiar_n; i++)
        {
            if (organizmy[i] != null)
            {
                if (organizmy[i].getnazwa() == "Czlowiek")
                {
                    wynik = organizmy[i];
                    break;
                }
            }
        }
        return wynik;
    }

    public JTextField[] getNapisy() {
        return napisy;
    }

    public int getLicznik_organizmow() {
        return licznik_organizmow;
    }
    public void setLicznik_napisow(){
        licznik_napisow++;
    }
    public void NoweNapisy()
    {
        for(int i=0;i<iloscnapisow;i++)
        {
            napisy[i].setText("");
        }
    }
    public void zakonczture()
    {
        for (int i = 0; i < rozmiar_m * rozmiar_n; i++)
        {
            if (organizmy[i] != null)
            {
                organizmy[i].koniectury();
            }
        }
    }
    public void RysujSwiat()
    {
        for (int i = 0; i < rozmiar_m; i++)
        {
            for (int j = 0; j < rozmiar_n; j++)
            {
                Przyciski[i][j].setBackground(new JButton().getBackground());
            }
        }
        for (int i = 0; i < rozmiar_m * rozmiar_n; i++)
        {
            if(organizmy[i]!=null)
            {
                if(organizmy[i].getZywe())
                {
                    organizmy[i].rysowanie();
                }
            }
        }
        Okno.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==tura)
        {
            if(getCzlowiek()==null)
           {
               licznik_napisow=0;
               NoweNapisy();
               sortuj();
               for(int i=0;i<licznik_organizmow;i++)
               {
                   if (organizmy[i] != null)
                   {
                       if(organizmy[i].getWiek()>0)
                       {
                           organizmy[i].akcja();
                       }
                   }
               }
               zakonczture();
               RysujSwiat();
           }
        }
        else if(e.getSource()==umiejetnosc)
        {
            Organizm gracz = getCzlowiek();
            if(gracz!= null)
            {
                ((Czlowiek)gracz).Umiejetnosc();
            }
        }
        else if(e.getSource()==zapis)
        {
            String nazwa=JOptionPane.showInputDialog(Okno,"Podaj nazwe pliku");
            File plik = new File(nazwa+".txt");
            if(!plik.exists()) {
                try {
                    plik.createNewFile();
                } catch (IOException ex) {
                    System.out.println("Blad przy zapisie do pliku");
                }
            }
            try
            {
                PrintWriter zapis = new PrintWriter(nazwa+".txt");
                zapis.println(rozmiar_n + " " + rozmiar_m);
                for (int i = 0; i < rozmiar_m * rozmiar_n; i++)
                {
                    if (organizmy[i] != null)
                    {
                        organizmy[i].zapis(zapis);
                    }
                }
                zapis.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Blad przy zapisie do pliku");
            }

        }
        else if(e.getSource()==odczyt)
        {
                odczyt();
        }
        else if(e.getSource()==info)
        {
            JOptionPane.showMessageDialog(Okno,
                    "O-bialy, W-szary, C-blekitny, Z-niebieski, A-brazowy, L-pomaranczony, " +
                            "B-czerwony, J-fioletowy, T-zielony, M-zolty, G-rozowy");
        }
        else {
            for (int i = 0; i < rozmiar_m; i++) {
                for (int j = 0; j < rozmiar_n; j++) {
                    if (e.getSource() == Przyciski[i][j] && Przyciski[i][j].getBackground() == (new JButton().getBackground())) {
                        String nazwa = JOptionPane.showInputDialog(Okno, "Podaj nazwe organizmu");
                        if (nazwa.equals("Mlecz")) {
                            Organizm nowy = new Mlecz(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Trawa")) {
                            Organizm nowy = new Trawa(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("BarszczSosnowskiego")) {
                            Organizm nowy = new BarszczSosnowskiego(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Guarana")) {
                            Organizm nowy = new Guarana(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("WilczeJagody")) {
                            Organizm nowy = new WilczeJagody(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Owca")) {
                            Organizm nowy = new Owca(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Wilk")) {
                            Organizm nowy = new Wilk(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Zolw")) {
                            Organizm nowy = new Zolw(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Lis")) {
                            Organizm nowy = new Lis(i, j, this, random);
                            dodajOrganizm(nowy);
                        } else if (nazwa.equals("Antylopa")) {
                            Organizm nowy = new Antylopa(i, j, this, random);
                            dodajOrganizm(nowy);
                        }
                        RysujSwiat();

                    }

                }
            }
        }
    }
    public void przyciski()
    {
        tura = new JButton("Nastepna tura");
        Mapa.add(tura);
        tura.setBounds(20, 550, 80, 50);
        tura.setFont(new Font("Roboto", Font.BOLD, 12));
        tura.setFocusable(false);
        tura.addActionListener(this);

        umiejetnosc = new JButton("Ult");
        Mapa.add(umiejetnosc);
        umiejetnosc.setBounds(120, 550, 80, 50);
        umiejetnosc.setFont(new Font("Roboto", Font.BOLD, 12));
        umiejetnosc.setFocusable(false);
        umiejetnosc.addActionListener(this);

        zapis = new JButton("Zapis");
        Mapa.add(zapis);
        zapis.setBounds(220, 550, 80, 50);
        zapis.setFont(new Font("Roboto", Font.BOLD, 12));
        zapis.setFocusable(false);
        zapis.addActionListener(this);

        odczyt = new JButton("Odczyt");
        Mapa.add(odczyt);
        odczyt.setBounds(320, 550, 80, 50);
        odczyt.setFont(new Font("Roboto", Font.BOLD, 12));
        odczyt.setFocusable(false);
        odczyt.addActionListener(this);

        info = new JButton("Info");
        Mapa.add(info);
        info.setBounds(420, 550, 80, 50);
        info.setFont(new Font("Roboto", Font.BOLD, 12));
        info.setFocusable(false);
        info.addActionListener(this);
    }
    public void planszaNapisy()
    {
        for (int i = 0; i < rozmiar_m; i++) {
            for (int j = 0; j < rozmiar_n; j++) {
                Przyciski[i][j] = new JButton();
                Mapa.add(Przyciski[i][j]);
                Przyciski[i][j].setBounds(j * 500 / rozmiar_n, i * 500 / rozmiar_m, 500 / rozmiar_n, 500 / rozmiar_m);
                Przyciski[i][j].setFont(new Font("Roboto", Font.BOLD, 5));
                Przyciski[i][j].setFocusable(false);
                Przyciski[i][j].addActionListener(this);
            }

        }
        for(int i=0;i<iloscnapisow;i++)
        {
            napisy[i]= new JTextField("");
            napisy[i].setVisible(true);
            Mapa.add(napisy[i]);
            napisy[i].setFont(new Font("Roboto", Font.BOLD, 10));
            napisy[i].setBounds(520,i*15,350,20);
            napisy[i].setEditable(false);
        }
    }
    public void odczyt()
    {
        String nazwa=JOptionPane.showInputDialog(Okno,"Podaj nazwe pliku");
        Scanner load = null;
        try {
            load = new Scanner(new File(nazwa+".txt"));
            Okno.remove(Mapa);
            Mapa = new JPanel();
            rozmiar_n = load.nextInt();
            rozmiar_m = load.nextInt();
            organizmy = new Organizm[rozmiar_n * rozmiar_m];
            licznik_organizmow = 0;
            Przyciski = new JButton[rozmiar_m][rozmiar_n];
            Mapa.setLayout(null);
            Mapa.setSize(szerokosc, wysokosc);
            Mapa.setBackground(Color.BLUE);
            Mapa.setVisible(true);
            licznik_napisow=0;
            planszaNapisy();
            przyciski();
            Okno.add(Mapa);
            Okno.repaint();
            while(load.hasNextLine() && load.hasNext())
            {
                String gatunek = load.next();
                int sila,wiek,X,Y;
                if(gatunek.equals("Mlecz"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Mlecz(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Trawa"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Trawa(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Guarana"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Guarana(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("BarszczSosnowskiego"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new BarszczSosnowskiego(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("WilczeJagody"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new WilczeJagody(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Owca"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Owca(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Wilk"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Wilk(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Lis"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Lis(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Zolw"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Zolw(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Antylopa"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    Organizm nowy = new Antylopa(Y,X,this,sila,wiek,random);
                    dodajOrganizm(nowy);
                }
                else if(gatunek.equals("Czlowiek"))
                {
                    X=load.nextInt();
                    Y=load.nextInt();
                    sila=load.nextInt();
                    wiek=load.nextInt();
                    int odliczanie;
                    boolean gotowa;
                    gotowa=load.nextBoolean();
                    odliczanie=load.nextInt();
                    Organizm nowy = new Czlowiek(Y,X,this,sila,wiek,random,odliczanie,gotowa);
                    dodajOrganizm(nowy);
                }
                RysujSwiat();
                Okno.repaint();
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Blad odczytu z pliku");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(getCzlowiek()!=null)
        {
            Organizm gracz = getCzlowiek();
            if(gracz instanceof Czlowiek)
            {
                boolean done = false;
                if (e.getKeyCode() == 38 && gracz.getY() > 0)
                {
                    ((Czlowiek) gracz).setRuch(0);
                    done = true;
                } else if (e.getKeyCode() == 39 && gracz.getX() < rozmiar_n - 1)
                {
                    ((Czlowiek) gracz).setRuch(1);
                    done = true;
                } else if (e.getKeyCode() == 40 && gracz.getY() < rozmiar_m - 1)
                {
                    ((Czlowiek) gracz).setRuch(2);
                    done = true;
                } else if (e.getKeyCode() == 37 && gracz.getX() > 0)
                {
                    ((Czlowiek) gracz).setRuch(3);
                    done = true;
                }
                if (done)
                {
                    licznik_napisow=0;
                    NoweNapisy();
                    sortuj();
                    for(int i=0;i<licznik_organizmow;i++)
                    {
                        if (organizmy[i] != null)
                        {
                            if(organizmy[i].getWiek()>0)
                            {
                                organizmy[i].akcja();
                            }
                        }
                    }
                    zakonczture();
                    RysujSwiat();
                }
            }
        }
    }
}
