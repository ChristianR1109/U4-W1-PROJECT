package project.entities;

public class Image extends Element {
    private int brightness;

    public Image(String title, int brightness) {
        super(title);
        this.brightness = brightness;
    }
}
