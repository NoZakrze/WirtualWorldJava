package WirtualnySwiatJava;


import java.io.PrintWriter;
import java.util.Random;
import java.awt.*;

abstract public class Roslina extends Organizm
{
    public Roslina(int sila, int polozenieX, int polozenieY, String nazwa, boolean ataki, Swiat swiat, int wiek, Random rng, Color reprezentacja)
    {
        super(sila,0,polozenieX,polozenieY,nazwa,ataki,swiat,wiek,rng,reprezentacja);
    }
    abstract protected void rozmnazanie(int Y, int X, Swiat swiat,Random rng);
    public void akcja()
    {
        int los = rng.nextInt(100);
        if (los <= 10)
        {
            wybierzGdzieDziecko();
        }
    }
    public void kolizja(Organizm rywal, boolean atak)
    {
        porazka(rywal, atak);
    }
    public void porazka(Organizm rywal, boolean atak)
    {
        this.zywe = false;
        rywal.setX(polozenieX);
        rywal.setY(polozenieY);
        System.out.println(this.getnazwa() + " nie zyje" + '\n');
        swiat.dodajNapis(this.getnazwa() + " nie zyje");
        swiat.usunMartwe();
    }
    public void koniectury()
    {
        super.koniectury();
    }
    public void zapis(PrintWriter plik)
    {
        super.zapis(plik);
    }
}
