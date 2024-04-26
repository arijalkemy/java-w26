package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // sino estan por dafualt no las regresa
public class ResponsePromoNoCountDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_coun")
    private int promoProductsCoun;

    @JsonProperty("promo_no_products_coun")
    private int promoNoProductsCoun;

    @JsonProperty("no_has_promo")
    private boolean noHasPromo;

    public ResponsePromoNoCountDTO(int userId, String userName, int promoProductsCoun) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCoun = promoProductsCoun;
    }

    public ResponsePromoNoCountDTO(int userId, String userName, int promoNoProductsCoun, boolean noHasPromo) {
        this.userId = userId;
        this.userName = userName;
        this.promoNoProductsCoun = promoNoProductsCoun;
        this.noHasPromo = noHasPromo;
    }

}