package project.entities;

import project.interfaces.Execute;
import project.interfaces.Playable;

import java.util.Scanner;

public class Audio extends Element implements Playable, Execute {
    Scanner scanner = new Scanner(System.in);
    private int time;
    private int volume;

    public Audio(String titolo, int time, int volume) {
        super(titolo);
        this.time = time;
        this.volume = volume;
    }


    @Override

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String volOut = "";
        for (int i = 0; i < volume; i++) {
            volOut += "!";
        }
        for (int i = 0; i < time; i++) {
            System.out.println(title + " " + volOut + " Volume = " + volume);
        }


        int index = 0;
        do {
            System.out.println("Inserisci 1 se desideri aumentare il volume.");
            System.out.println("Inserisci 2 se desideri diminuire il volume.");
            System.out.println("inserisci 0 se desideri continuare.");
            index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index > 2) {
                System.out.println("Il valore inserito non è compreso nel range fornito, riprova.");
            }
        } while (index < 0 || index > 2);
        switch (index) {
            case 0:
                break;
            case 1:
                increaseVolume();
                break;
            case 2:
                decreaseVolume();
                break;
        }


    }

    @Override
    public void increaseVolume() {
        System.out.println("Il volume attuale è: " + volume);
        if (volume == 10) {
            System.out.println("Il volume è al massimo");
            return;
        } else if (volume == 9) {
            System.out.println("L'unico valore inseribile è : " + 10);
            volume = 10;

            String volOut = "";
            for (int i = 0; i < volume; i++) {
                volOut += "!";
            }
            System.out.println(title + " " + volOut + " Il nuovo volume è : " + volume);
            return;
        } else {
            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per il volume tra " + (volume + 1) + " e " + 10);
                j = Integer.parseInt(scanner.nextLine());
                if (j <= volume || j > 10) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j <= volume || j > 10);
            volume = j;
            String volOut = "";
            for (int i = 0; i < volume; i++) {
                volOut += "!";
            }
            System.out.println(title + " " + volOut + " Il nuovo volume è : " + volume);
            return;

        }

    }


    @Override
    public void decreaseVolume() {
        System.out.println("Il volume attuale è: " + volume);
        if (volume == 0) {
            System.out.println("Il volume è al minimo");
            return;
        } else if (volume == 1) {
            System.out.println("L'unico valore inseribile è : " + 0);
            volume = 0;
            String volOut = "";
            for (int i = 0; i < volume; i++) {
                volOut += "!";
            }
            System.out.println(title + " " + volOut + " Il nuovo volume è : " + volume);
            return;

        } else {

            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per il volume tra " + 0 + " e " + (volume - 1));
                j = Integer.parseInt(scanner.nextLine());
                if (j < 0 || j >= (volume)) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j < 0 || j > (volume - 1));
            volume = j;
            String volOut = "";
            for (int i = 0; i < volume; i++) {
                volOut += "!";
            }
            System.out.println(title + " " + volOut + " Il nuovo volume è : " + volume);
            return;

        }

    }

    @Override
    public void exe() {
        play();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
