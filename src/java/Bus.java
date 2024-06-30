
class Bus {
    private int busID;
    private String busLevel;
    private String busType;
    private String licensePlate;
    private String currentCity;
    private int totalSeats;
    private int availableSeat;
    private int driverID;
    private String destinationCity;

    public Bus(int busID, String busLevel, String busType, String licensePlate, String currentCity, int totalSeats,
               int availableSeat, int driverID, String destinationCity) {
        this.busID = busID;
        this.busLevel = busLevel;
        this.busType = busType;
        this.licensePlate = licensePlate;
        this.currentCity = currentCity;
        this.totalSeats = totalSeats;
        this.availableSeat = availableSeat;
        this.driverID = driverID;
        this.destinationCity = destinationCity;
    }

    // Getter and setter methods

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getBusLevel() {
        return busLevel;
    }

    public void setBusLevel(String busLevel) {
        this.busLevel = busLevel;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busID=" + busID +
                ", busLevel='" + busLevel + '\'' +
                ", busType='" + busType + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", currentCity='" + currentCity + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeat=" + availableSeat +
                ", driverID=" + driverID +
                ", destinationCity='" + destinationCity + '\'' +
                '}';
    }
}