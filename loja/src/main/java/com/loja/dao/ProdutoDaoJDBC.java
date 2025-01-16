package com.loja.dao;

import java.util.List;

import com.loja.entities.dto.ItemDto;

public class ProdutoDaoJDBC implements ProdutoDao{

    public void criarTabela(){
        String query = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY
                )
                """;
    }

    @Override
    public void adicionarProduto(ProdutoDto item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarProduto'");
    }

    @Override
    public void removerItem(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerItem'");
    }

    @Override
    public void atualizarItem(ProdutoDto item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarItem'");
    }

    @Override
    public List<ItemDto> listarItens() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarItens'");
    }

}
