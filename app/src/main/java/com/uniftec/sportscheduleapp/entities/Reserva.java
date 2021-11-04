package com.uniftec.sportscheduleapp.entities;

import java.io.Serializable;

public class Reserva implements Serializable {

    private Integer codReserva;
    private Double valorTotal;
    private String detalhes;

    Quadra quadra;
}
