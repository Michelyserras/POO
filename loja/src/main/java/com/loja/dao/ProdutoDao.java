package com.loja.dao;
import java.util.List;
import com.loja.entities.Produto;

public interface ProdutoDao {
    public void adicionarProduto(Produto produto);
    public void removerProduto(Long id);
    public void atualizarProduto(Produto Produto);
    public List<Produto> listarProdutos();
}
