/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.padroesdeprojeto.builder;

import java.text.ParseException;
import java.util.ArrayList;
import modelo.Endereco;
import modelo.Servico;
import modelo.Solicitacao;

public class DiretorSolicitacao {
   
    public Solicitacao builder(String disp_cli_ini, String disp_cli_fim,
            String observacao, String dataSolicitacao, ArrayList<Servico> servicos, Endereco endereco) throws ParseException{
            Solicitacao solicitacao = new Solicitacao();
            
            BuilderSolicitacao builder = new BuilderSolicitacao(disp_cli_ini, disp_cli_fim,
            observacao, dataSolicitacao,  servicos, solicitacao,endereco);
        
            builder.geraProtocolo();
            builder.geraDataSolicitacao();
            builder.geraDisponibilidades();
            builder.adicionaServicos();
            builder.geraEndereco();
            return solicitacao;
    }
}
