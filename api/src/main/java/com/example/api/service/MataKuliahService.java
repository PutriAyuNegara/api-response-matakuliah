package com.example.api.service;

import com.example.api.model.Mahasiswa;
import com.example.api.model.MataKuliah;
import com.example.api.repository.MahasiswaRepository;
import com.example.api.repository.MataKuliahRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MataKuliahService {

    private final MataKuliahRepository mataKuliahRepository;

    private final MahasiswaRepository mahasiswaRepository;

    public MataKuliah createMataKuliah(String nimMahasiswa, MataKuliah mataKuliah){
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepository.findById(nimMahasiswa);
        if(optionalMahasiswa.isPresent()){
            Mahasiswa mahasiswa =optionalMahasiswa.get();
            mataKuliahRepository.save(mataKuliah);
            mahasiswa.setMataKuliah(mataKuliah);
            mahasiswaRepository.save(mahasiswa);
            return mataKuliah;
        } else {
            throw new RuntimeException("Data Mata Kuliah berhasil ditambahkan");
        }
    }
}
