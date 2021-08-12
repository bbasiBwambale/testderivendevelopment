package Exceptions.Domains;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(Long id) {

        super(String.format("Vehicle with Vin %d not found", id));
    }
}
