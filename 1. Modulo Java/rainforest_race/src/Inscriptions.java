public class Inscriptions {
    private int inscriptionNumber;
    private int categoryId;
    private int contestantId;
    private double inscriptionAmount;

    public Inscriptions(int inscriptionNumber, int categoryId, int contestantId, double inscriptionAmount) {
        this.inscriptionNumber = inscriptionNumber;
        this.categoryId = categoryId;
        this.contestantId = contestantId;
        this.inscriptionAmount = inscriptionAmount;
    }

    public int getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(int inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getContestantId() {
        return contestantId;
    }

    public void setContestantId(int contestantId) {
        this.contestantId = contestantId;
    }

    public double getInscriptionAmount() {
        return inscriptionAmount;
    }

    public void setInscriptionAmount(double inscriptionAmount) {
        this.inscriptionAmount = inscriptionAmount;
    }
}
