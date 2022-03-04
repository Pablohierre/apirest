/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


/**
 *
 * @author hierr
 */

@Data
@Entity
@Table(name="libros")
public class Libro implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String titulo;
   private String autor;
   private String categoria;
   private String isbn;
   private int edicion;
   private boolean disponible;
}
