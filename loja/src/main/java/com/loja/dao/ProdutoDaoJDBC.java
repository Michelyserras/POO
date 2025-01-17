package com.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.loja.database.DB;
import com.loja.entities.Produto;
@Repository
public class ProdutoDaoJDBC implements ProdutoDao{

    public ProdutoDaoJDBC(){
        criarTabela();
    }

     public void criarTabela() {
        String query = """
            CREATE TABLE IF NOT EXISTS produtos (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                produto_id BIGINT NOT NULL,
                quantidade INT NOT NULL,
                preco_total DOUBLE NOT NULL
            )
        """;
        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.execute();
            System.out.println("Tabela criada ou já existente.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public void adicionarProduto(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarProduto'");
    }

    @Override
    public void removerProduto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerproduto'");
    }

    @Override
    public void atualizarProduto(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarproduto'");
    }

    @Override
    public List<Produto> listarProdutos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarItens'");
    }

}
