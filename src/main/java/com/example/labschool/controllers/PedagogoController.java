package com.example.labschool.controllers;

import com.example.labschool.dtos.PedagogoDto;
import com.example.labschool.models.PedagogoModel;
import com.example.labschool.repositories.PedagogoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class PedagogoController {

    @Autowired
    PedagogoRepository pedagogoRepository;

    @PostMapping("pedagogos")
    public ResponseEntity<PedagogoModel> savePedagogo(@RequestBody @Valid PedagogoDto pedagogoDto ) {
        var pedagogoModel = new PedagogoModel();

        BeanUtils.copyProperties(pedagogoDto, pedagogoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedagogoRepository.save(pedagogoModel));
    }

    @GetMapping("pedagogos")
    public ResponseEntity<List<PedagogoDto>> getAllPedagogos (){
        return ResponseEntity.status(HttpStatus.OK).body(pedagogoRepository.findAll()
                .stream()
                .map(PedagogoDto::new)
                .toList()
        );
    }

    @GetMapping("pedagogos/{id}")
    public ResponseEntity<Object> getOnePedagogo (@PathVariable(value = "id") UUID id){

        Optional<PedagogoModel> pedagogoO = pedagogoRepository.findById(id);

        if(pedagogoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not found");
        }
        Optional<PedagogoDto> pedagogoDto = pedagogoO.map(PedagogoDto::new);

        return ResponseEntity.status(HttpStatus.OK).body(pedagogoDto.get());
    }

    @PutMapping("pedagogos/{id}")
    public ResponseEntity<Object> updatePedagogo(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid PedagogoDto pedagogoDto ){

        Optional<PedagogoModel> pedagogoO = pedagogoRepository.findById(id);

        if(pedagogoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not found");
        }

        var pedagogoModel = pedagogoO.get();
        BeanUtils.copyProperties(pedagogoDto, pedagogoModel);

        return ResponseEntity.status(HttpStatus.OK).body(pedagogoRepository.save(pedagogoModel));
    }

    @DeleteMapping("pedagogos/{id}")
    public ResponseEntity<Object> deletePedagogo (@PathVariable UUID id){

        Optional<PedagogoModel> pedagogoO = pedagogoRepository.findById(id);
        if(pedagogoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not found");
        }

        pedagogoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pedagogo deleted successfully.");
    }
}
