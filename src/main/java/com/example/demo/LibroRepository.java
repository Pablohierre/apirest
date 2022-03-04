/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demo;


import java.awt.print.Pageable;
import java.util.List;
import models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author hierr
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {

    public Libro findAllById(Long id);
    public List<Libro> findAllByCategoria(String categoria);
    public List<Libro> findAllByAutor(String autor);
    
    @Query("select l from Libro l where l.id =?1")
    Libro sacarPorId(Long id, Pageable pageable);
    
    @Modifying
    @Query("UPDATE Libro l SET disponible=True WHERE l.id=?1")
    void actualizarEstadoTrue(Long id);
    
    @Modifying
    @Query("UPDATE Libro l SET disponible=False WHERE l.id=?1")
    void actualizarEstadoFalse(Long id);
    
    //Query query = session.createQuery("UPDATE Student stud SET name = :newName WHERE name = :oldName");
}
