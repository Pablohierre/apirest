/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.demo;

import java.awt.print.Pageable;
import java.util.List;
import models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hierr
 */
@RestController
@RequestMapping("/")
public class LibroController {
    @Autowired
    LibroRepository libRep;
    
    @GetMapping("/books")
    public List<models.Libro> showBooks(){
        System.out.println("ENTRA");
     return libRep.findAll();
    }
    
    @GetMapping("/books/{id}")
    public Libro findBook(@PathVariable Long id){
        return libRep.findAllById(id);
    }
    
    @GetMapping("/books/category={categoria}")
    public List<Libro> showByCategory(@PathVariable String categoria) {

        return libRep.findAllByCategoria(categoria);
    }
    
    @GetMapping("/books/author={autor}")
    public List<Libro> showByAuthor(@PathVariable String autor) {

        return libRep.findAllByAutor(autor);
    }
      
    
    @PostMapping("/books/{id}/available/true")
    public String updateSatusTrue (@PathVariable Long id) {
        System.out.println("Cambiar el estado a true");
        libRep.actualizarEstadoTrue(id);
         return "redirect:/books/"+id;
    }
    
    @RequestMapping(value="/books/{id}/available/false", method=RequestMethod.POST)
    public void updateSatusFalse(@PathVariable Long id) {
        System.out.println("Cambiar el estado a false");
        Pageable pageable = null;
        
       // Libro l =libRep.sacarPorId(id, pageable);
        //System.out.println("El libro es "+l.getTitulo());
        
        libRep.actualizarEstadoFalse(id);
    }
    
    
    }


/*
@Controller
public class LibroController {
    
    @Autowired
    LibroRepository libRep;
    
    @GetMapping("/")
    public String mostrarLibros(){
     String todos=libRep.findAll().toString();
     
     return todos;
    }
    
*/