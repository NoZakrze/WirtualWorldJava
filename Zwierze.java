package WirtualnySwiatJava;
import java.io.PrintWriter;
import java.util.Random;
import java.awt.*;
abstract public class Zwierze extends Organizm
{
        public Zwierze(int sila, int inicjatywa, int polozenieX, int polozenieY, String nazwa, boolean ataki, Swiat swiat, int wiek, Random rng, Color reprezentacja)
        {
            super(sila,inicjatywa,polozenieX,polozenieY,nazwa,ataki,swiat,wiek,rng,reprezentacja);
        }
        abstract protected void rozmnazanie(int Y, int X, Swiat swiat,Random rng);
        public void akcja()
        {
            boolean ruch = false;
            int X = polozenieX, Y = polozenieY;
            while (!ruch)
            {
                int los = rng.nextInt(4);
                if (los == 0 && polozenieY > 0)
                {
                    Y--;
                    ruch = true;
                }
                else if (los == 1 && polozenieX < swiat.GetN() - 1)
                {
                    X++;
                    ruch = true;
                }
                else if (los == 2 && polozenieY < swiat.GetM() - 1)
                {
                    Y++;
                    ruch = true;
                }
                else if (los == 3 && polozenieX > 0)
                {
                    X--;
                    ruch = true;
                }
            }
            Organizm rywal = this.swiat.zajetePole(Y, X);
            if (rywal != null)
            {
               System.out.println("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y + '\n');
                swiat.dodajNapis("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y);
                kolizja(rywal, true);
            }
            else
            {
                this.setX(X);
                this.setY(Y);
               System.out.println(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY()+ '\n');
                swiat.dodajNapis(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY());
            }

        }
        public void kolizja(Organizm rywal, boolean atak)
        {
            if (this.nazwa == rywal.getnazwa())
            {
                if(rywal.getWiek() > 0)
                    wybierzGdzieDziecko();
            }
            else
            {
                if (atak == true)
                {
                    if (sila >= rywal.getSila())
                    {
                        rywal.kolizja(this, false);
                    }
                    else
                    {
                        if (rywal.getAtaki() == false)
                            rywal.kolizja(this, false);
                        else
                            porazka(rywal, true);
                    }
                }
                else
                {
                    porazka(rywal, false);
                }
            }
        }
        public void porazka(Organizm rywal, boolean atak)
        {
            if (atak == false)
            {
                rywal.setX(polozenieX);
                rywal.setY(polozenieY);
            }
            this.zywe = false;
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
