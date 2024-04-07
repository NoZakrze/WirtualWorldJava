package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class Antylopa extends Zwierze
{
    public Antylopa(int Y, int X,Swiat swiat, Random rng)
    {
        super(4, 4, X, Y,  "Antylopa", true, swiat,0,rng, new Color(107, 21, 16));
    }
    Antylopa(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila,4,X,Y,"Antylopa",true,swiat,wiek,rng,new Color(107, 21, 16));
    }

    protected void rozmnazanie(int Y, int X,Swiat swiat, Random rng)
    {
        Organizm nowy = new Antylopa(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
    public void akcja()
    {
        boolean ruch = false;
        int X = polozenieX, Y = polozenieY;
        while (!ruch)
        {
            int los = rng.nextInt(8);
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
            else if (los == 4 && polozenieY > 1)
            {
                Y = Y - 2;
                ruch = true;
            }
            else if (los == 5 && polozenieX < swiat.GetN() - 2)
            {
                X = X + 2;
                ruch = true;
            }
            else if (los == 6 && polozenieY < swiat.GetM() - 2)
            {
                Y = Y + 2;
                ruch = true;
            }
            else if (los == 7 && polozenieX > 1)
            {
                X = X - 2;
                ruch = true;
            }
            Organizm rywal = swiat.zajetePole(Y, X);
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
    }
    public void porazka(Organizm rywal, boolean atak)
    {
        boolean ucieczka = rng.nextBoolean();
        if (!ucieczka)
        {
            super.porazka(rywal, atak);
        }
        else
        {
            int X = polozenieX, Y = polozenieY;
            boolean udana = false;
            if (atak)
            {
                X = rywal.getX();
                Y = rywal.getY();
            }
            else
            {
                rywal.setX(X);
                rywal.setY(Y);
            }
            boolean flaga1 = true, flaga2 = true, flaga3 = true, flaga4 = true;
            while (!udana && (flaga1 || flaga2 || flaga3 || flaga4))
            {
                int los = rng.nextInt(4);
                if (los == 0 && flaga1 == true)
                {
                    if (Y <= 0)
                        flaga1 = false;
                    else
                    {
                        Organizm tmp = swiat.zajetePole(Y - 1, X);
                        if (tmp == null)
                        {
                            Y--;
                            udana = true;
                        }
                        else
                            flaga1 = false;
                    }
                }
                else if (los == 1 && flaga2 == true)
                {
                    if (X >= swiat.GetN() - 1)
                        flaga2 = false;
                    else
                    {
                        Organizm tmp = swiat.zajetePole(Y, X + 1);
                        if (tmp == null)
                        {
                            X++;
                            udana = true;
                        }
                        else
                            flaga2 = false;
                    }
                }
                else if (los == 2 && flaga3 == true)
                {
                    if (Y >= swiat.GetM() - 1)
                        flaga3 = false;
                    else
                    {
                        Organizm tmp = swiat.zajetePole(Y + 1, X);
                        if (tmp == null)
                        {
                            Y++;
                            udana = true;
                        }
                        else
                            flaga3 = false;
                    }
                }
                else if (los == 3 && flaga4 == true)
                {
                    if (X <= 0)
                        flaga4 = false;
                    else
                    {
                        Organizm tmp = swiat.zajetePole(Y,X - 1);
                        if (tmp == null)
                        {
                            X--;
                            udana = true;
                        }
                        else
                            flaga4 = false;
                    }
                }
            }
            if (udana)
            {
                System.out.println(this.getnazwa() + " ucieka na pole " + X + " " + Y+ '\n');
                swiat.dodajNapis(this.getnazwa() + " ucieka na pole " + X + " " + Y);
                this.setX(X);
                this.setY(Y);
            }
            else
            {
                zywe = false;
                System.out.println(this.getnazwa() + " nie zyje" + '\n');
                swiat.dodajNapis(this.getnazwa() + " nie zyje");
                swiat.usunMartwe();
            }
        }
    }
}
