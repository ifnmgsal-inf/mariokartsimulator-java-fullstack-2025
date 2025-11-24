package br.ifnmg.ds.backend;

/**
 * Class that represents a Mario character
 * @author leonardo
 */
public class Character {
    private int id;
    private String name;
    private int speed;
    private int maneuverability;
    private int power;
    private String image;

    public Character(int id, String name, int speed, int maneuverability, int power, String image) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.maneuverability = maneuverability;
        this.power = power;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getManeuverability() {
        return maneuverability;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", maneuverability=" + maneuverability +
                ", power=" + power +
                '}';
    }
}
