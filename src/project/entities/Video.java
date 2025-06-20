package project.entities;

public class Video extends Element {
    private int time;
    private int brightness;

    public Video(String titolo, int time, int brightness) {
        super(titolo);
        this.time = time;
        this.brightness = brightness;
    }
}
