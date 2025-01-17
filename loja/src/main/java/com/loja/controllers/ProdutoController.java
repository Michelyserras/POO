package com.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.entities.Produto;
import com.loja.services.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    public ProdutoService service;

   @PostMapping("/add")
   public ResponseEntity<String> postMethodName(@RequestBody Produto produto) {
       try{
              service.addProduto(produto.getNome(), produto.getPreco(), produto.getQuantidadeEstoque(), produto.getDescricao());
              return ResponseEntity.ok("Produto cadastrado com sucesso");
       }catch(Exception e){
              return ResponseEntity.badRequest().body("Erro ao cadastrar produto");
       }
   }
   
    
}
