/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.dao.interfaces;

import modelo.Endereco;

/**
 * Interface dos métodos mais específicos fora do CRUD
 * Seguindo o padrão DAO.
 * 
 * Novos métodos de DAO para classe <nome>DAO devem ser
 * escritos aqui primeiro.
 * @author helle
 */
public interface IEnderecoDAO extends IGenericDAO<Endereco> {
    
    public int getClassCount();
}
