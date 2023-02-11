package dao;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.FuncAdd;
import modelo.FuncRmv;

public class FuncAddDAO {
   private Connection connection;
   String id_produto;
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

    public void remover(FuncRmv r) { 
            String sql = "DELETE FROM produto WHERE id_produto = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, r.getId_produto());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto removido.");
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e);
                throw new RuntimeException(e);
            }
        }
    
    public void pedido(FuncAdd p) {
        String sql = "insert into pedido(nome_produto, ano_produto, valor_produto)values (?, ?, ?)";
        try {                
                
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, p.getNome_produto());
                stmt.setString(2, p.getAno_produto());
                stmt.setString(3, p.getValor_produto());

                stmt.execute();
                JOptionPane.showMessageDialog(null, "Produto adquirido! Acesse sua lista de pedidos para revê-lo.");
                stmt.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
    
       
