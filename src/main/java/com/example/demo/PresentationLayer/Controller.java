package com.example.demo.PresentationLayer;
import com.example.demo.BusinessLayer.DreamService;
import com.example.demo.dtos.DreamDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/dream")

public class Controller {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private  DreamService dreamService;
    @GetMapping
    Collection<DreamDto> dreams() {
        return dreamService.findAll();
    }

    @GetMapping("/dream/{id}")
    ResponseEntity<?> getDream(@PathVariable Long id) {
        logger.info("Entered: GET /competitions");
        return ResponseEntity.ok(dreamService.findAll());
    }

    @PostMapping
    public ResponseEntity<DreamDto> save(@Valid @RequestBody DreamDto dream) {//datele din form vine in param metoda
        logger.info("Entered: POST /competitions with params: " + dream.toString());
        //return ResponseEntity.ok(dreamService.save(dream));

        DreamDto result = dreamService.save(dream);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/dream/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DreamDto dreamDto) {
        logger.info("Entered: PUT /competitions with params: " + dreamDto.toString());
        dreamService.update(dreamDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
         logger.info("Entered: DELETE /competitions with params: " + id.toString());
        dreamService.delete(id);
    }
}
