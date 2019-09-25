package ar.com.ada.billeteravirtual;

import java.util.*;
import javax.persistence.*;


/**
 * Movimiento
 */
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimiento_id;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;


    private Date fechaMovimiento;

    //private Coordenada ubicacion;

    private Double importe;

    private String tipoDeOperacion;

    private String conceptoDeOperacion;

    private String detalle;

    private int estado;

    //private Usuario deUsuario;

    private int deUsuario_id;

    //private Usuario aUsuario;
    @Column(name = "aUsuario_id")
    private int aUsario_id;

   // private Cuenta cuentaDestino;

    private int cuentaDestino_id;

    //private Cuenta cuentaOrigen;

    private int cuentaOrigen_id;


    public Cuenta getCuenta(){
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public int getMovimiento_id() {
        return movimiento_id;
    }

    public void setMovimiento_id(int movimiento_id) {
        this.movimiento_id = movimiento_id;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    public String getConceptoDeOperacion() {
        return conceptoDeOperacion;
    }

    public void setConceptoDeOperacion(String conceptoDeOperacion) {
        this.conceptoDeOperacion = conceptoDeOperacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDeUsuario_id() {
        return deUsuario_id;
    }

    public void setDeUsuario_id(int deUsuario_id) {
        this.deUsuario_id = deUsuario_id;
    }

    public int getaUsario_id() {
        return aUsario_id;
    }

    public void setaUsario_id(int aUsario_id) {
        this.aUsario_id = aUsario_id;
    }

    public int getCuentaDestino_id() {
        return cuentaDestino_id;
    }

    public void setCuentaDestino_id(int cuentaDestino_id) {
        this.cuentaDestino_id = cuentaDestino_id;
    }

    public int getCuentaOrigen_id() {
        return cuentaOrigen_id;
    }

    public void setCuentaOrigen_id(int cuentaOrigen_id) {
        this.cuentaOrigen_id = cuentaOrigen_id;
    }




}