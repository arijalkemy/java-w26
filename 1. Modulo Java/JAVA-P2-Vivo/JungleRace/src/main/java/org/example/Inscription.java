package org.example;

public class Inscription {
    private int idInscription;
    private Category category;
    private Participant participant;
    private Double amountPayable;
    private boolean status;

    public Inscription(int idInscription, Category category, Participant participant) {
        this.idInscription = idInscription;
        this.category = category;
        this.participant = participant;
        this.amountPayable = this.validateAmountToPlay(participant.getAge(), category.getId());
        this.status = (this.amountPayable == 0.0d) ? false : true;
    }
    // Validate the age of the participant
    public Double validateAmountToPlay(int age, int categoryId){
        switch (categoryId){
            // Short category
            case 0:
                return (age < 18) ? 1300.0d : 1500.0d;

            // Medium category
            case 1:
                return (age < 18) ? 2000.0d : 2300.0d;

            // Large category
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

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
