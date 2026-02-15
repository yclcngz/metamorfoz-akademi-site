package com.example.metamorfoz.model;

public class IletisimFormu {
    private String adSoyad;
    private String email;
    private String mesaj;

    // Getter ve Setter Metotları (Veriye erişmek ve değiştirmek için şart)
    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
}