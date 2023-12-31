package com.example.api.model;

import com.example.api.enums.Gender;
import com.example.api.enums.Prodi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Mahasiswa {

    @Id
    @Column(length = 10)
    private String nimMahasiswa;
    private String namaMahasiswa;

    @Enumerated(EnumType.STRING)
    private Gender genderMahasiswa;

    @Enumerated(EnumType.STRING)
    private Prodi prodiMahasiswa;

    private String alamatMahasiswa;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mata_kuliah_id")
    private MataKuliah mataKuliah;

}
