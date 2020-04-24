package edu.ap.facilitytoolspringboot.documenten;

public enum Status {
    IB("In behandeling"), GK("Goed gekeurd"), GEAN("Geannuleerd"), B("Beëindigd"), IU("In uitvoering"), V("Voltooid"),
    GEAR("Gearchiveerd"), IW("In wacht");

    private int btw;
    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}