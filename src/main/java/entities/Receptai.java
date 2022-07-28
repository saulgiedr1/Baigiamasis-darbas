package entities;

public class Receptai {
    private int id;
    private String pavadinimas;
    private double kaina;
    private String nurodymai;

    public Receptai() {
    }

    public Receptai(int id, String pavadinimas, double kaina, String nurodymai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.nurodymai = nurodymai;
    }

    public Receptai(String pavadinimas, double kaina, String nurodymai) {
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.nurodymai = nurodymai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public String getNurodymai() {
        return nurodymai;
    }

    public void setNurodymai(String nurodymai) {
        this.nurodymai = nurodymai;
    }


    @Override
    public String toString() {
        return "Receptai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kaina=" + kaina +
                ", nurodymai='" + nurodymai + '\'' +
                '}';
    }
}
