package com.loja.database;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DB {

    private static Connection conn = null;

//metodo para conectar no banco
    public static Connection getConnection(){
        if(conn == null){ //se a conexão não estiver instanciada
            try{
                Properties props = loadProperties(); //então, carregam-se as propriedades do banco
                String url = props.getProperty("dburl"); //pegando a url do banco
                conn = DriverManager.getConnection(url, props); //conectando no banco
            }catch(SQLException e){
                throw new DbException(e.getMessage()); //lançando a exceção personalizada
            }
        }
        return conn;
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
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
