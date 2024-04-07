package WirtualnySwiatJava;

import java.util.Random;
import java.awt.*;
public class Lis extends Zwierze {
    public Lis(int Y, int X, Swiat swiat, Random rng) {
        super(3, 7, X, Y, "Lis", true, swiat, 0, rng,new Color(247, 132, 37));
    }
    public Lis(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
       super(sila, 7,X, Y, "Lis",true,swiat, wiek,rng,new Color(247, 132, 37));
    }
    protected void rozmnazanie(int Y, int X,Swiat swiat, Random rng)
    {
        Organizm nowy = new Lis(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
    public void akcja() {
        boolean ruch = false, flaga1 = true, flaga2 = true, flaga3 = true, flaga4 = true;
        int X = polozenieX, Y = polozenieY;
        while (!ruch && (flaga1 || flaga2 || flaga3 || flaga4)) {
            int los = rng.nextInt(4);
            if (los == 0 && flaga1 == true) {
                if (polozenieY < 1)
                    flaga1 = false;
                else {
                    Organizm tmp = swiat.zajetePole(polozenieY - 1, polozenieX);
                    if (tmp == null) {
                        Y--;
                        ruch = true;
                    } else if (tmp.getSila() <= sila) {
                        Y--;
                        ruch = true;
                    } else
                        flaga1 = false;
                }
            } else if (los == 1 && flaga2 == true) {
                if (polozenieX >= swiat.GetN() - 1)
                    flaga2 = false;
                else {
                    Organizm tmp = swiat.zajetePole(polozenieY, polozenieX + 1);
                    if (tmp == null) {
                        X++;
                        ruch = true;
                    } else if (tmp.getSila() <= sila) {
                        X++;
                        ruch = true;
                    } else
                        flaga2 = false;
                }
            } else if (los == 2 && flaga3 == true) {
                if (polozenieY >= swiat.GetM() - 1)
                    flaga3 = false;
                else {
                    Organizm tmp = swiat.zajetePole(polozenieY + 1, polozenieX);
                    if (tmp == null) {
                        Y++;
                        ruch = true;
                    } else if (tmp.getSila() <= sila) {
                        Y++;
                        ruch = true;
                    } else
                        flaga3 = false;
                }
            } else if (los == 3 && flaga4 == true) {
                if (polozenieX <= 0)
                    flaga4 = false;
                else {
                    Organizm tmp = swiat.zajetePole(polozenieY, polozenieX - 1);
                    if (tmp == null) {
                        X--;
                        ruch = true;
                    } else if (tmp.getSila() <= sila) {
                        X--;
                        ruch = true;
                    } else
                        flaga4 = false;
                }
            }
        }
        if (ruch) {
            Organizm rywal = swiat.zajetePole(Y, X);
            if (rywal != null) {
                System.out.println("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y + '\n');
                swiat.dodajNapis("Kolizja " + this.getnazwa() + " z " + rywal.getnazwa() + " na polu " + X + " " + Y);
                kolizja(rywal, true);
            } else {
                this.setX(X);
                this.setY(Y);
                System.out.println(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY()+ '\n');
                swiat.dodajNapis(this.getnazwa() + " rusza sie na pole " + this.getX() + " " + this.getY());
            }
        }
    }
}
