package com.example.metamorfoz.controller;

// DİKKAT: Import satırları "metamorfoz" paketine göre ayarlandı
import com.example.metamorfoz.model.IletisimFormu;
import com.example.metamorfoz.model.Mesaj;
import com.example.metamorfoz.repository.MesajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private MesajRepository mesajRepository;

    @GetMapping("/")
    public String anaSayfa(Model model) {
        model.addAttribute("ogretmenAdi", "Yücel Cengiz");
        model.addAttribute("brans", "Matematik & Geometri");
        model.addAttribute("slogan", "Matematiği Ezberleme, Mantığını Kavra!");
        return "index";
    }

    // HATA BURADAYDI: Bu metod çalışmadığı için "formData" html'e gitmiyordu.
    @GetMapping("/iletisim")
    public String iletisimSayfasi(Model model) {
        // HTML'deki th:object="${formData}" kısmı burayı bekliyor!
        model.addAttribute("formData", new IletisimFormu());
        return "iletisim";
    }

    @PostMapping("/iletisim-gonder")
    public String formuIsle(@ModelAttribute IletisimFormu formData, Model model) {
        Mesaj yeniMesaj = new Mesaj();
        yeniMesaj.setAdSoyad(formData.getAdSoyad());
        yeniMesaj.setEmail(formData.getEmail());
        yeniMesaj.setIcerik(formData.getMesaj());

        mesajRepository.save(yeniMesaj);

        model.addAttribute("mesaj", "Mesajınız başarıyla veritabanına kaydedildi!");
        // Kayıttan sonra formu sıfırlamak için boş bir nesne daha gönderiyoruz
        model.addAttribute("formData", new IletisimFormu());
        return "iletisim";
    }

    @GetMapping("/panel")
    public String panelSayfasi(Model model) {
        // 1. Veritabanındaki HER ŞEYİ getir (findAll)
        // 2. Bunları "mesajlar" ismiyle pakete koy
        model.addAttribute("mesajlar", mesajRepository.findAll());

        return "panel"; // panel.html sayfasına git
    }

    @GetMapping("/mesaj-sil/{id}")
    public String mesajSil(@PathVariable Long id) {

        // 1. Verilen ID'ye sahip mesajı veritabanından sil
        mesajRepository.deleteById(id);

        // 2. İşlem bitince tekrar panel sayfasına yönlendir (Sayfayı yenile)
        return "redirect:/panel";
    }
    @GetMapping("/login")
    public String loginSayfasi() {
        return "login"; // login.html'e git
    }

}