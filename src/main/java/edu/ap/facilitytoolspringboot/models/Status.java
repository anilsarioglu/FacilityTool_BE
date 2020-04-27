package edu.ap.facilitytoolspringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    IN_BEHANDELING, GOED_GEKEURD, GEANNULEERD, BEËINDIGD, IN_UITVOERING, VOLTOOID, GEARCHIVEERD, IN_WACHT

    // IB("In behandeling"), GK("Goed gekeurd"), GEAN("Geannuleerd"),
    // B("Beëindigd"), IU("In uitvoering"), V("Voltooid"),
    // GEAR("Gearchiveerd"), IW("In wacht");

    // private String info;

    // Status(String info) {
    // this.info = info;
    // }

    // @JsonValue
    // public String getInfo() {
    // return info;
    // }

}