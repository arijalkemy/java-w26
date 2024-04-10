package org.example.CarreraDeLaSelva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Inscription {

    private Integer number;

    private Category category;

    private Competitor competitor;

    private Integer mount;

    private Status status;

    public Inscription(Integer number, Category category, Competitor competitor) {
        this.number = number;
        this.category = category;
        this.competitor = competitor;
        int mount = calculateMount(competitor.isOlder(), category.getKms());
        this.mount = mount;
        this.status = mount == 0 ? Status.DENIED : Status.ACCEPTED;
    }

    private int calculateMount(boolean isOld, int kms) {
        switch (kms) {
            case 2:
                if (isOld) return  1500;
                else return  1300;
            case 5:
                if (isOld) return  2300;
                else return  2000;
            case 10:
                if (isOld) return  2800;
                else return  0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "number=" + number +
                ", competitor=" + competitor +
                ", mount=" + mount +
                ", status=" + status +
                '}';
    }
}
