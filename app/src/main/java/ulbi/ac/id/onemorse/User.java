package ulbi.ac.id.onemorse;

public class User {
    private String namamatkul;
    private String dikumpul;

    public User(String namamatkul) {
        this.namamatkul = namamatkul;
        this.dikumpul = dikumpul;
    }

    public String getNamamatkul() {
        return namamatkul;
    }

    public void setNamamatkul(String namamatkul) {
        this.namamatkul = namamatkul;
    }

    public String getDikumpul() {
        return dikumpul;
    }

    public void setDikumpul(String dikumpul) {
        this.dikumpul = dikumpul;
    }
}
