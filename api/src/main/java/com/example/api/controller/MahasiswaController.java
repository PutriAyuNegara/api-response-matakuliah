package com.example.api.controller;

import com.example.api.model.Mahasiswa;
import com.example.api.model.MataKuliah;
import com.example.api.service.MahasiswaService;
import com.example.api.service.MataKuliahService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mahasiswa")
@AllArgsConstructor
public class MahasiswaController {

    private final MahasiswaService mahasiswaService;

    private final MataKuliahService mataKuliahService;

    @GetMapping("/get-all")
    public List<Mahasiswa> getAllDataMahasiswa(){
        return mahasiswaService.getAllDataMahasiswa();
    }

    @GetMapping("/{nimMahasiswa}")
    public ResponseEntity<Mahasiswa> getDataMahasiswaByNim(@PathVariable String nimMahasiswa){
        return mahasiswaService.getMahasiswaByNIM(nimMahasiswa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save-data")
    public ResponseEntity<?> saveDataMahasiswa(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa mahasiswa1 = mahasiswaService.saveDataMahasiswa(mahasiswa);
        return ResponseEntity.ok("Data Berhasil Disimpan");
    }

    @DeleteMapping("/{nimMahasiswa}")
    public void deleteDataMahasiswaByNim(@PathVariable String nimMahasiswa){
        mahasiswaService.deleteDataMahasiswaByNim(nimMahasiswa);
    }

    @PostMapping("/{nimMahasiswa}/matakuliah")
    public ResponseEntity<MataKuliah> createMataKuliah(
            @PathVariable String nimMahasiswa,
            @RequestBody MataKuliah mataKuliah
    ){
        mataKuliahService.createMataKuliah(nimMahasiswa, mataKuliah);
        return new ResponseEntity<>(mataKuliah, HttpStatus.CREATED);
    }
}
