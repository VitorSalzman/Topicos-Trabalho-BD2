/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luizg
 */
@Entity
@Table(name="Prestador")
public class PrestadorP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(length = 20,name="cpf")
    private String cpf;
    @Column(name="horarioInicio")
    private Time horarioInicio;
    @Column(name="horarioInicio")
    private Time horarioFim;
    @Column(name="horarioFim")
    private int cargaHoraria;
    @Column(name="disponibilidade")
    private boolean disponibilidade;
    
    @OneToOne
    private AcessoP acesso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public AcessoP getAcesso() {
        return acesso;
    }

    public void setAcesso(AcessoP acesso) {
        this.acesso = acesso;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.horarioInicio);
        hash = 59 * hash + Objects.hashCode(this.horarioFim);
        hash = 59 * hash + this.cargaHoraria;
        hash = 59 * hash + (this.disponibilidade ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.acesso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrestadorP other = (PrestadorP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (this.disponibilidade != other.disponibilidade) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.horarioInicio, other.horarioInicio)) {
            return false;
        }
        if (!Objects.equals(this.horarioFim, other.horarioFim)) {
            return false;
        }
        if (!Objects.equals(this.acesso, other.acesso)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "PrestadorP{" + "id=" + id + ", cpf=" + cpf + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", cargaHoraria=" + cargaHoraria + ", disponibilidade=" + disponibilidade + '}';
    }

    
}