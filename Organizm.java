package WirtualnySwiatJava;

import java.io.PrintWriter;
import java.util.Random;
import java.awt.*;


abstract public class Organizm
{
    protected int sila;
    protected int inicjatywa;
    protected int polozenieX;
    protected int polozenieY;
    protected int wiek;
    protected boolean zywe = true;
    protected boolean ataki;
    protected String nazwa;
    protected Swiat swiat;
    protected Random rng;
    protected Color reprezentacja;
    abstract protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng);
    public Organizm(int sila, int inicjatywa, int polozenieX, int polozenieY, String nazwa, boolean ataki, Swiat swiat, int wiek, Random rng, Color reprezentacja)
    {
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.nazwa = nazwa;
        this.ataki = ataki;
        this.swiat = swiat;
        this.wiek = wiek;
        this.rng = rng;
        this.reprezentacja = reprezentacja;

    }
    abstract public void akcja();
    abstract public void kolizja(Organizm rywal, boolean atak);
    abstract public void porazka(Organizm rywal, boolean atak);
    public void rysowanie()
    {
        swiat.getPrzyciski()[polozenieY][polozenieX].setBackground(reprezentacja);
    }
    public int getSila()
    {
        return this.sila;
    }
    public void setSila(int new_sila)
    {
        this.sila = new_sila;
    }
    public int getInicjatywa()
    {
        return this.inicjatywa;
    }
    public int getX()
    {
        return this.polozenieX;
    }
    public void setX(int new_X)
    {
        this.polozenieX = new_X;
    }
    public int getY()
    {
        return this.polozenieY;
    }
    public void setY(int new_Y)
    {
        this.polozenieY = new_Y;
    }
    public boolean getZywe()
    {
        return this.zywe;
    }
    public void setZywe()
    {
        this.zywe = false;
    }
    public boolean getAtaki()
    {
        return this.ataki;
    }
    public int getWiek()
    {
        return this.wiek;
    }
    public void setWiek()
    {
        this.wiek++;
    }
    public boolean miejsceObok(Swiat swiat)
    {
        boolean miejsce = false;
        if (swiat.zajetePole(polozenieY - 1, polozenieX) == null && polozenieY>0)
            miejsce = true;
        else if (swiat.zajetePole(polozenieY, polozenieX + 1) == null &&  polozenieX < swiat.GetN() - 1)
            miejsce = true;
        else if (swiat.zajetePole(polozenieY + 1, polozenieX) == null && polozenieY < swiat.GetM() - 1)
            miejsce = true;
        else if (swiat.zajetePole(polozenieY, polozenieX - 1) == null && polozenieX > 0)
            miejsce = true;
        return miejsce;
    }
    public void wybierzGdzieDziecko()
    {
        boolean ruch = false;
        int X = polozenieX, Y = polozenieY;

        if (miejsceObok(swiat))
        {
            while (!ruch)
            {
                int los = rng.nextInt(4);
                if (los == 0 && polozenieY > 0 && swiat.zajetePole(Y - 1, X) == null)
                {
                    Y--;
                    ruch = true;
                }
                else if (los == 1 && polozenieX < swiat.GetN() - 1 && swiat.zajetePole(Y, X + 1) == null)
                {
                    X++;
                    ruch = true;
                }
                else if (los == 2 && polozenieY < swiat.GetM() - 1 && swiat.zajetePole(Y + 1, X) == null)
                {
                    Y++;
                    ruch = true;
                }
                else if (los == 3 && polozenieX > 0 && swiat.zajetePole(Y, X - 1) == null)
                {
                    X--;
                    ruch = true;
                }
            }
            rozmnazanie(Y, X,swiat,rng);
        }
    }
    public String getnazwa()
    {
        return this.nazwa;
    }
    public void koniectury()
     {
         this.wiek++;
     }
    public void zapis(PrintWriter plik)
    {
        plik.println(nazwa + " " + polozenieX + " " + polozenieY + " " + sila + " " + wiek);
    }
}
