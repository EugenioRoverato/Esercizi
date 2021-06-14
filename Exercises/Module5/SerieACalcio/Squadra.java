package Old.SerieACalcio;

public class Squadra
{
    String id, nome;
    String[] rosa;
    int punti, goalFatti, goalSubiti;

    public Squadra(String id, int goalFatti)
    {
        this.id = id;
        this.goalFatti = goalFatti;
        punti = 0;
        goalSubiti = 0;
    }

    public Squadra() {
    }

    public int getPunti() {
        return punti;
    }

    public String getId() {
        return id;
    }

    public int getGoalFatti() {
        return goalFatti;
    }

    public int getGoalSubiti() {
        return goalSubiti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public void setGoalFatti(int goalFatti) {
        this.goalFatti = goalFatti;
    }

    public void setGoalSubiti(int goalSubiti) {
        this.goalSubiti = goalSubiti;
    }
}
