package com.example.metamorfoz.repository;

import com.example.metamorfoz.model.Mesaj;
import org.springframework.data.jpa.repository.JpaRepository;

// Bu sihirli satır sayesinde SQL yazmadan veritabanına kayıt yapabileceğiz!
public interface MesajRepository extends JpaRepository<Mesaj, Long> {
}
