package com.loja.dao;

import java.sql.SQLException;
import java.util.List;

import com.loja.dao.dto.ItemDto;

public interface ItemDao {
    public void adicionarItem(ItemDto item) throws SQLException;
    public void removerItem(ItemDto item);
    public void atualizarItem(ItemDto item);
    public List<ItemDto> listarItens();

}
