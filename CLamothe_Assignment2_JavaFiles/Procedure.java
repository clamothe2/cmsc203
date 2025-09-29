package assignment2;

public class Procedure {
    private String name;
    private String date;
    private String practitioner;
    private double charge;

    public Procedure() {}

    public Procedure(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Procedure(String name, String date, String practitioner, double charge) {
        this.name = name;
        this.date = date;
        this.practitioner = practitioner;
        this.charge = charge;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getPractitioner() { return practitioner; }
    public void setPractitioner(String practitioner) { this.practitioner = practitioner; }
    public double getCharge() { return charge; }
    public void setCharge(double charge) { this.charge = charge; }

    public String toString() {
        return "Procedure: " + name + "\n" +
               "Date: " + date + "\n" +
               "Practitioner: " + practitioner + "\n" +
               String.format("Charge: $%,.2f", charge);
    }
}