package com.wintux.consum.Models;

import jakarta.persistence.*;

@Entity
@Table(name="wikicambios")
public class RegistroWikimedia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiDatosDeEvento;

    public String getWikiDatosDeEvento() {
        return wikiDatosDeEvento;
    }

    public void setWikiDatosDeEvento(String wikiDatosDeEvento) {
        this.wikiDatosDeEvento = wikiDatosDeEvento;
    }
}
