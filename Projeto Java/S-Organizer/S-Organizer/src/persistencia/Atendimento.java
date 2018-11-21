/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="Atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="horarioInicio")
    private Time horarioInicioAtendimento;
    @Column(name="horarioFim")
    private Time horarioFimAtendimento;
    @Column(name="dataAtendimento")
    private Date dataAtendimento;
    
    @OneToOne
    private Prestador prestador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getHorarioInicioAtendimento() {
        return horarioInicioAtendimento;
    }

    public void setHorarioInicioAtendimento(Time horarioInicioAtendimento) {
        this.horarioInicioAtendimento = horarioInicioAtendimento;
    }

    public Time getHorarioFimAtendimento() {
        return horarioFimAtendimento;
    }

    public void setHorarioFimAtendimento(Time horarioFimAtendimento) {
        this.horarioFimAtendimento = horarioFimAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.horarioInicioAtendimento);
        hash = 23 * hash + Objects.hashCode(this.horarioFimAtendimento);
        hash = 23 * hash + Objects.hashCode(this.dataAtendimento);
        hash = 23 * hash + Objects.hashCode(this.prestador);
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
        final Atendimento other = (Atendimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.horarioInicioAtendimento, other.horarioInicioAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.horarioFimAtendimento, other.horarioFimAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.dataAtendimento, other.dataAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.prestador, other.prestador)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", horarioInicioAtendimento=" + horarioInicioAtendimento + ", horarioFimAtendimento=" + horarioFimAtendimento + ", dataAtendimento=" + dataAtendimento + '}';
    }


}
