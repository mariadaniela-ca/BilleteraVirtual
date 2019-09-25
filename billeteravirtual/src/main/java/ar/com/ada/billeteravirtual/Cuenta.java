package ar.com.ada.billeteravirtual;

import java.util.*;
import javax.persistence.*;


/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroCuenta_id;

    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();


    private String moneda;

    private double saldo;

    private double saldoDisponible;

    //private String movimiento2;
    
    public Cuenta(){
//jjj
    }


    public void setMoneda(String moneda){
        this.moneda = moneda;
    }

    public String getMonedad(){
        return moneda;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
 
    public double getSaldo(){
        return saldo;
    }
 
    public Billetera getBilletera(){
        return billetera;
    }

    public void setBilletera(Billetera billetera){
        this.billetera = billetera;

    }

    public List<Movimiento> getMovimientos(){
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos){
        this.movimientos = movimientos;
    }

    public void agregarMovimiento(Movimiento movimiento){

        movimiento.setCuenta(this);
        movimientos.add(movimiento);
        this.setSaldo(this.getSaldo()+ movimiento.getImporte());
        this.setSaldoDisponible(this.getSaldo());
        
    }

    public int getNroCuenta_id() {
        return nroCuenta_id;
    }

    public void setNroCuenta_id(int nroCuenta_id) {
        this.nroCuenta_id = nroCuenta_id;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

 
}