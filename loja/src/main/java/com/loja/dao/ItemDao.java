package com.loja.dao;

import java.sql.SQLException;
import java.util.List;

import com.loja.entities.dto.ItemDto;

public interface ItemDao {
    public void adicionarItem(ItemDto item) throws SQLException;
    public void removerItem(Long id);
    public void atualizarItem(ItemDto item);
    public List<ItemDto> listarItens();

}
