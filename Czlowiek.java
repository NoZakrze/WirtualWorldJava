package WirtualnySwiatJava;


import java.awt.*;
import java.io.PrintWriter;
import java.util.Random;
public class Czlowiek extends Zwierze{

    private int ruch;
    private int odliczanie;
    private boolean gotowa;
    public Czlowiek(int Y, int X,Swiat swiat,Random rng)
    {
        super(5,4,X,Y,"Czlowiek",true,swiat,0,rng,new Color(50, 141, 168));
        ruch = 0;
        odliczanie = 0;
        gotowa = true;
    }
    public Czlowiek(int Y, int X, Swiat swiat, int sila, int wiek, Random rng, int odliczanie, boolean gotowa)
    {
        super(sila, 4, X, Y,  "Czlowiek", true, swiat, wiek,rng, new Color(50, 141, 168));
        this.odliczanie = odliczanie;
        this.gotowa = gotowa;
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
       return;
    }
    public void akcja() {
        int X = polozenieX, Y = polozenieY;
        if (ruch == 0) {
            Y--;
        } else if (ruch == 1) {
            X++;
        } else if (ruch == 2) {
            Y++;
        } else if (ruch == 3) {
            X--;
        }
        Organizm rywal = this.swiat.zajetePole(Y, X);
        if (rywal != null) {
            System.out.println("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y + '\n');
            swiat.dodajNapis("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y);
            kolizja(rywal, true);
        } else {
            this.setX(X);
            this.setY(Y);
            System.out.println(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY() + '\n');
            swiat.dodajNapis(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY());
        }
    }
    public void koniectury()
    {
        wiek++;
        if (odliczanie <= 9 && odliczanie >= 5)
        {
            sila--;
        }
        if (odliczanie > 0)
        {
            odliczanie--;
        }
        if (odliczanie == 0)
        {
            gotowa = true;
        }
    }
    public void setRuch(int a)
    {
        this.ruch = a;
    }
    public void Umiejetnosc()
    {
        if (gotowa)
        {
            odliczanie = 10;
            sila = sila+5;
            System.out.println("Uzyto umiejetnosci specjalnej" + '\n');
            swiat.dodajNapis("Uzyto umiejetnosci specjalnej");
            gotowa = false;
        }
        else
        {
            System.out.println("Nie mozna uruchomic umiejetnosci specjalnej" + '\n');
            swiat.dodajNapis("Nie mozna uruchomic umiejetnosci specjalnej");
        }
    }
    public void zapis(PrintWriter plik)
    {
        plik.println(nazwa + " " + polozenieX + " " + polozenieY + " " + sila + " " + wiek + " " + gotowa + " " + odliczanie);

    }

}


