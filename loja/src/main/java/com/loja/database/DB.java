package com.loja.database;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class DB {

    private static Connection conn = null;

//metodo para conectar no banco
    @Bean
    public static Connection getConnection(){
            try{

                Properties props = loadProperties(); //então, carregam-se as propriedades do banco
                String url = props.getProperty("url"); //pegando a url do banco
                conn =  DriverManager.getConnection(url, props); //conectando no banco
                return conn;
            }catch(SQLException e){
                throw new DbException(e.getMessage()); //lançando a exceção personalizada
            }
    }

//metodo para fechar a conexão do banco
    public static void closeConnection(){
        if(conn != null){ //testando se a conexão esta instanciada
            try{
                conn.close(); //se tiver, vou fechar utilizando o .close
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

//metodo para carregar as propriedades do banco
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("src/main/resources/application.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
