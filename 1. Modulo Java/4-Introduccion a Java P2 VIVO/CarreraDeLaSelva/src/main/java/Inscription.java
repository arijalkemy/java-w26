public class Inscription {
    private int idInscription;
    private Category category;
    private Participant participant;
    private Double amount;
    private boolean status;

    public Inscription(int idInscription, Category category, Participant participant) {
        this.idInscription = idInscription;
        this.category = category;
        this.participant = participant;
        this.amount = this.validateAmountToPlay(participant.getAge(), category.getId());
        this.status = this.amount != 0.0d;
    }
    // Validate the age of the participant
    public Double validateAmountToPlay(int age, int categoryId){
        switch (categoryId){
            // Short Run
            case 0:
                return (age < 18) ? 1300.0d : 1500.0d;

            // Medium Run
            case 1:
                return (age < 18) ? 2000.0d : 2300.0d;

            // Advanced run
            case 2:
                return (age < 18) ? 0.0d : 2800.0d;

            default:
                return 0.0d;
        }
    }


    // Setters and Getters
    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
