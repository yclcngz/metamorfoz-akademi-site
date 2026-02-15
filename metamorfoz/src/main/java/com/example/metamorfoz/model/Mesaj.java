package com.example.metamorfoz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Bu sınıfın bir veritabanı tablosu olduğunu belirtir
public class Mesaj {

    @Id // Her mesajın benzersiz bir kimliği (ID) olacak
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artsın (1, 2, 3...)
    private Long id;

    private String adSoyad;
    private String email;
    private String icerik; // Mesajın kendisi

    // Getter ve Setter Metotları (Sağ tık > Generate > Getter and Setter ile de yapabilirsin)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getIcerik() { return icerik; }
    public void setIcerik(String icerik) { this.icerik = icerik; }
}
