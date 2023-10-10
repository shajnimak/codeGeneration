package kz.shady.assignment.controller;

import kz.shady.assignment.service.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/code")
public class CodeController {
    @Autowired
    CodeGenerator generator;
    @GetMapping()
    public ResponseEntity<?> getNextCode(){
        return ResponseEntity.ok(generator.getNextCode());
    }
}
