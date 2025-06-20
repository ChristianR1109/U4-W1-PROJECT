package project.entities;

import project.interfaces.Adjustable;
import project.interfaces.Execute;
import project.interfaces.Playable;

import java.util.Scanner;

public class Video extends Element implements Playable, Adjustable, Execute {
    private int time;
    private int volume;
    private int brightness;

    public Video(String titolo, int time, int volume, int brightness) {
        super(titolo);
        this.time = time;
        this.volume = volume;
        this.brightness = brightness;
    }


    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        String volOut = "";
        for (int i = 0; i < volume; i++) {
            volOut += "!";
        }
        String brnOut = "";
        for (int i = 0; i < brightness; i++) {
            brnOut += "*";
        }
        for (int i = 0; i < time; i++) {
            System.out.println(title + " " + volOut + " " + brnOut + " Volume = " + volume + " Luminosità = " + brightness);

        }
        int index = 0;

        System.out.println("Desideri modificare il volume? Inserisci 1 per modificare, 0 per continuare.");
        index = Integer.parseInt(scanner.nextLine());
        switch (index) {
            case 0:
                break;
            case 1:
                do {
                    System.out.println("Inserisci 1 se desideri aumentare il volume.");
                    System.out.println("Inserisci 2 se desideri diminuire il volume.");
                    index = Integer.parseInt(scanner.nextLine());
                    if (index < 1 || index > 2) {
                        System.out.println("Il valore inserito non è compreso nel range fornito, riprova.");
                    }
                } while (index < 1 || index > 2);
                switch (index) {

                    case 1:
                        increaseVolume();
                        break;
                    case 2:
                        decreaseVolume();
                        break;
                }
                break;
        }

        System.out.println("Desideri modificare la luminosità? Inserisci 1 per modificare, 0 per continuare.");
        index = Integer.parseInt(scanner.nextLine());
        switch (index) {
            case 0:
                break;
            case 1:
                do {
                    System.out.println("Inserisci 1 se desideri aumentare la luminosità.");
                    System.out.println("Inserisci 2 se desideri diminuire la luminosità");

                    index = Integer.parseInt(scanner.nextLine());
                    if (index < 1 || index > 2) {
                        System.out.println("Il valore inserito non è compreso nel range fornito, riprova.");
                    }
                } while (index < 1 || index > 2);
                switch (index) {

                    case 1:
                        increaseBrightness();
                        break;
                    case 2:
                        decreaseBrightness();
                        break;
                }
                break;
        }


    }

    @Override
    public void increaseVolume() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
    public void increaseBrightness() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La luminosità attuale è: " + brightness);
        if (brightness == 10) {
            System.out.println("La luminosità è al massimo");
            return;
        } else if (brightness == 9) {
            System.out.println("L'unico valore inseribile è : " + 10);
            brightness = 10;

            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "!";
            }
            System.out.println(title + " " + brnOut + " La luminosità è : " + brightness);
            return;
        } else {
            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per la luminosità tra " + (brightness + 1) + " e " + 10);
                j = Integer.parseInt(scanner.nextLine());
                if (j <= brightness || j > 10) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j <= brightness || j > 10);
            brightness = j;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "*";
            }
            System.out.println(title + " " + brnOut + " La nuova luminosità è : " + brightness);
            return;

        }
    }

    @Override
    public void decreaseBrightness() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La luminosità attuale è: " + brightness);
        if (brightness == 0) {
            System.out.println("La luminosità è al minimo");
            return;
        } else if (brightness == 1) {
            System.out.println("L'unico valore inseribile è : " + 0);
            brightness = 0;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "*";
            }
            System.out.println(title + " " + brnOut + " La luminosità è : " + brightness);
            return;

        } else {

            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per la luminosità tra " + 0 + " e " + (brightness - 1));
                j = Integer.parseInt(scanner.nextLine());
                if (j < 0 || j >= (brightness)) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j < 0 || j > (brightness - 1));
            brightness = j;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "!";
            }
            System.out.println(title + " " + brnOut + " La nuova luminosità è : " + brightness);
            return;

        }
    }

    @Override
    public void exe() {
        play();
    }
}
