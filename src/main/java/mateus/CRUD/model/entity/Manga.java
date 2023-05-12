package mateus.CRUD.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.net.URI;

@Entity
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String title;
    @NotNull
    @Min(1)
    private int volume;
    @Min(0)
    private double price;
    @NotBlank
    private String author;
    @NotNull
    private Boolean oneShot;
    private URI cover;
    public Manga() {
    }
    public Manga(String title, int volume, double price, String author, Boolean oneShot, URI cover) {
        this.title = title;
        this.volume = volume;
        this.price = price;
        this.author = author;
        this.oneShot = oneShot;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getOneShot() {
        return oneShot;
    }

    public void setOneShot(Boolean oneShot) {
        this.oneShot = oneShot;
    }

    public URI getCover() {
        return cover;
    }

    public void setCover(URI cover) {
        this.cover = cover;
    }
}
