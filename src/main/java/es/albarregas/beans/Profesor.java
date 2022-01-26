package es.albarregas.beans;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "profesoresComp")
public class Profesor implements Serializable{

    @EmbeddedId
    private Codigo codigo;
        
    @Column(name = "nombre", length = 20, nullable = true)
    private String nombre;
    @Column(name = "ape1", length = 15, nullable = true)
    private String ape1;
    
    @Column(name = "ape2", length = 15, nullable = false)
    private String ape2;
    
    @Column(name = "escala",
     columnDefinition = "set('s','t') default 's'",
     insertable = false)
     private String escala;
    
    
    @Column(name = "fecha",
    columnDefinition = "datetime default now()",
     insertable = false) 
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;
    @Transient
    private String fechaFormateada;
    // Constructor implicito
    
    
    
    
    public Profesor() {
       
    }

    // Constructor explicito

    public Profesor(Codigo codigo, String nombre, String ape1, String ape2, String escala, Calendar fecha, String fechaFormateada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.escala = escala;
        this.fecha = fecha;
        
    }
   

    /*  Existe la posibilidad de que cada atributo no tenga getters o setters pero entoces hay que especificar el atributo access="field"
        en el fichero de mapeo <property name="nombre_atributo" access="field" />
    */
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }
    
      public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
        setFechaFormateada();
        
    }

    public String getFechaFormateada() {
        setFechaFormateada();
        return fechaFormateada;
    }

    public void setFechaFormateada() {
       
       this.fechaFormateada =  fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR)  ;
    }

    @Override
    public String toString() {
        return "Profesor{" + "codigo=" + codigo + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", escala=" + escala + ", fecha=" + fecha + ", fechaFormateada=" + fechaFormateada + '}';
    }
    
}
