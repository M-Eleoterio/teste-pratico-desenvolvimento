package dao;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.FuncAdd;

public class FuncAddDAO {
   private Connection connection;
   Long id_produto;
   String nome_produto;
   String ano_produto;
   String valor_produto;
   public FuncAddDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(FuncAdd funcadd){
        String sql = "INSERT INTO produto(nome_produto, ano_produto, valor_produto)VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcadd.getNome_produto());
            stmt.setString(2, funcadd.getAno_produto());
            stmt.setString(3, funcadd.getValor_produto());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
        throw new RuntimeException(u);
        }
    }
}