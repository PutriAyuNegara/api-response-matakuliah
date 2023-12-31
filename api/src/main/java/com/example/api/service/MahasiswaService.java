package com.example.api.service;

import com.example.api.enums.Gender;
import com.example.api.enums.Prodi;
import com.example.api.model.Mahasiswa;
import com.example.api.repository.MahasiswaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> getAllDataMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Optional<Mahasiswa> getMahasiswaByNIM(String nimMahasiswa){
        return mahasiswaRepository.findById(nimMahasiswa);
    }

    public Mahasiswa saveDataMahasiswa(Mahasiswa mahasiswa){
        mahasiswa.setNimMahasiswa(mahasiswa.getNimMahasiswa());
        mahasiswa.setNamaMahasiswa(mahasiswa.getNamaMahasiswa());

        if (mahasiswa.getGenderMahasiswa().equals("L")) {
            mahasiswa.setGenderMahasiswa(Gender.L);
        } else if (mahasiswa.getGenderMahasiswa().equals("P")) {
            mahasiswa.setGenderMahasiswa(Gender.P);
        } else {
            mahasiswa.getGenderMahasiswa().equals("Gender Tidak Tersedia");
        }

        if (mahasiswa.getProdiMahasiswa().equals("TI")) {
            mahasiswa.setProdiMahasiswa(Prodi.TI);
        } else if (mahasiswa.getProdiMahasiswa().equals("TE")) {
            mahasiswa.setProdiMahasiswa(Prodi.TE);
        } else if (mahasiswa.getProdiMahasiswa().equals("SI")) {
            mahasiswa.setProdiMahasiswa(Prodi.SI);
        } else {
            mahasiswa.getProdiMahasiswa().equals("Prodi Tidak Sesuai");
        }
        mahasiswa.setAlamatMahasiswa(mahasiswa.getAlamatMahasiswa());
        return mahasiswaRepository.save(mahasiswa);
    }

    public void deleteDataMahasiswaByNim(String nimMahasiswa){
        mahasiswaRepository.deleteById(nimMahasiswa);
    }

}
