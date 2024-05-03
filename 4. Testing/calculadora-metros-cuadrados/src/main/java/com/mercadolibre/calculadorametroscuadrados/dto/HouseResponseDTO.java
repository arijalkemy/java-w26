package com.mercadolibre.calculadorametroscuadrados.dto;

public class HouseResponseDTO extends HouseDTO {
    private Integer squareFeet;
    private Integer price;
    private RoomDTO biggest;

    public HouseResponseDTO() {
    }

    public HouseResponseDTO(HouseDTO house) {
        this.setName(house.getName());
        this.setAddress(house.getAddress());
        this.setRooms(house.getRooms());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HouseResponseDTO that = (HouseResponseDTO) obj;

        boolean hasEqualsRooms = false;

        if (this.getRooms() != null && that.getRooms() != null && this.getRooms().size() == that.getRooms().size()) {

            hasEqualsRooms = this.getRooms().equals(that.getRooms());

        } else if (this.getRooms() == null && that.getRooms() == null) {
            hasEqualsRooms = true;
        }

        boolean hasEqualsBiggestRoom =
                this.getBiggest() != null &&
                        that.getBiggest() != null &&
                        this.getBiggest().equals(that.getBiggest());

        hasEqualsBiggestRoom = (this.getBiggest() == null && that.getBiggest() == null) || hasEqualsBiggestRoom;

        return squareFeet.equals(that.squareFeet)
                && price.equals(that.price)
                && hasEqualsBiggestRoom
                && hasEqualsRooms;
    }

    public Integer getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public RoomDTO getBiggest() {
        return biggest;
    }

    public void setBiggest(RoomDTO biggest) {
        this.biggest = biggest;
    }
}
