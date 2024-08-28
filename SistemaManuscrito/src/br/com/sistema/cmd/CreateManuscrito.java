package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


public class CreateManuscrito {

	public static void main(String[] args) {
		try {
			//Importa a classe de conexão com banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			//Importa a classe de transição de dados no sql
			Manuscrito manuscrito = new Manuscrito();
			
			//Envia o dado para a classe Manuscrito()
			
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o Titulo do Manuscrito"));
			
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do Autor"));
			
			//Criar o SQl para inserir dados no banco
			String sql = "Insert into manuscrito (titulo, autor) " + "values (?,?)";
			
			//Criando um comando para passar o SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			
			//execução do comando SQL
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Manuscrito inserido com sucesso!");
			cmd.close();
			
				
				
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
