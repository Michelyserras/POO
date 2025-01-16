package com.loja.dao;
import java.util.List;
import com.loja.entities.dto.ItemDto;

public interface ProdutoDao {
    public void adicionarProduto(ProdutoDto item);
    public void removerItem(Long id);
    public void atualizarItem(ProdutoDto item);
    public List<ItemDto> listarItens();
}
