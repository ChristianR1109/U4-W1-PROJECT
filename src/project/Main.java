package project;

import project.entities.Audio;
import project.entities.Image;
import project.entities.Video;
import project.interfaces.Execute;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------PLAYER MULTIMEDIALE----------");
        int num = 0;

        do {
            System.out.println("Inserisci il numero di elementi multimediali che desideri aggiungere tra 1 e 5");
            num = Integer.parseInt(scanner.nextLine());
        } while (num < 1 || num > 5);
        Execute[] multimedials = new Execute[num];
        for (int i = 0; i < num; i++) {
            String text = "";
            do {
                System.out.println("Inserisci la tipologia di file tra Audio, Video, Immagine del file numero : " + (i + 1));
                text = scanner.nextLine().toUpperCase();
            } while (!text.equals("AUDIO") && !text.equals("VIDEO") && !text.equals("IMMAGINE"));

            if (text.equals("AUDIO")) {
                System.out.println("Inserisci il titolo dell'audio : ");
                String title = scanner.nextLine();
                int riproduz = 0;
                do {
                    System.out.println("Inserisci la durata di riproduzione dell'audio tra 1 e 10 : ");
                    riproduz = Integer.parseInt(scanner.nextLine());
                } while (riproduz < 1 || riproduz > 10);
                int vol = 0;
                do {
                    System.out.println("Inserisci il volume dell'audio tra 1 e 10 : ");
                    vol = Integer.parseInt(scanner.nextLine());
                } while (vol < 0 || vol > 10);
                multimedials[i] = new Audio(title, riproduz, vol);

            } else if (text.equals("VIDEO")) {
                System.out.println("Inserisci il titolo del video : ");
                String title = scanner.nextLine();
                int riproduz = 0;
                do {
                    System.out.println("Inserisci la durata di riproduzione del video tra 1 e 10 : ");
                    riproduz = Integer.parseInt(scanner.nextLine());
                } while (riproduz < 1 || riproduz > 10);
                int vol = 0;
                do {
                    System.out.println("Inserisci il volume del video tra 1 e 10  : ");
                    vol = Integer.parseInt(scanner.nextLine());
                } while (vol < 0 || vol > 10);
                int lum = 0;
                do {
                    System.out.println("Inserisci la luminosità del video tra 1 e 10 : ");
                    lum = Integer.parseInt(scanner.nextLine());
                } while (lum < 0 || lum > 10);
                multimedials[i] = new Video(title, riproduz, vol, lum);
            } else {
                System.out.println("Inserisci il titolo dell'immagine : ");
                String title = scanner.nextLine();
                int lum = 0;
                do {
                    System.out.println("Inserisci la luminosità dell'immagine tra 0 e 10 : ");
                    lum = Integer.parseInt(scanner.nextLine());
                } while (lum < 0 || lum > 10);
                multimedials[i] = new Image(title, lum);
            }

        }


        int pos = 0;
        do {
            do {
                System.out.println("Inserisci la posizione dell'elemento che vuoi riprodurre tra " + 1 + " e " + num + ", inserisci 0 per uscire : ");
                for (int i = 0; i < num; i++) {
                    System.out.println("POSIZIONE " + (i + 1) + " : " + multimedials[i].getTitle());
                }
                pos = Integer.parseInt(scanner.nextLine());
            } while (pos < 0 || pos > multimedials.length);
            if (pos > 0) {
                int j = (pos - 1);
                multimedials[j].exe();
            }

        } while (pos != 0);
        System.out.println("-----GRAZIE!-----");


    }
}