package project.entities;

import project.interfaces.Playable;

public class Audio extends Element implements Playable {
    private int time;

    public Audio(String titolo, int time) {
        super(titolo);
        this.time = time;
    }

    @Override
    public void play() {
        System.out.println();
    }
}
