/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cidade;

/**
 *
 * @author afranio
 */
public class DaoCidade {
    Connection con = null;
    PreparedStatement pstm = null;
   public void salvarCidade(Cidade cidade) {
        con = new Conexao().conectaBanco();

        try {
            pstm = con.prepareStatement("INSERT INTO tb_cidade (nome, uf_id) VALUES (?,?)");
            pstm.setString(1, cidade.getNome());
            pstm.setInt(2, cidade.getEstado().getId());
           
            this.pstm.execute();

            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cidade no banco de dados.", e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar conexão." + e);
            }
        }

    }
        
        
        
}
