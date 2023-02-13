package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.FuncAdd;
import modelo.FuncRmv;
import modelo.HistVend;
import modelo.ProdAdd;

public class FuncAddDAO {

    private Connection connection;
    String id_produto;
    String nome_produto;
    String ano_produto;
    String id_pedido;
    String nome_pedido;
    String ano_pedido;
    String valor_pedido;
    String id_historico;
    String nome_historico;
    String ano_historico;
    String valor_historico;

    public FuncAddDAO() {
        //realiza a conexão com o banco de dados.
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(FuncAdd funcadd) {
        //código para adicionar produtos na loja via aba de funcionários.
        String sql = "INSERT INTO produto(nome_produto, ano_produto, valor_produto)VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcadd.getNome_produto());
            stmt.setString(2, funcadd.getAno_produto());
            stmt.setString(3, funcadd.getValor_produto());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void remover(FuncRmv r) {
        //código para remover produtos da loja via aba de funcionários.
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

    public void pedido(ProdAdd p) {

        //código para comprar produtos da loja via aba de cliente.
        String query = "insert into pedido(nome_pedido, ano_pedido, valor_pedido, status_pedido)values(?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, p.getNome_pedido());
            stmt.setString(2, p.getAno_pedido());
            stmt.setString(3, p.getValor_pedido());
            stmt.setString(4, "Processando");
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto adquirido! Acesse sua lista de pedidos para revê-lo.");
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removerp(FuncRmv rp) {
        //código para cancelar compras via aba de cliente.
        String sql = "DELETE FROM pedido WHERE id_produto = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, rp.getId_produto());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto removido.");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            throw new RuntimeException(e);
        }
    }

    public void historico(HistVend h) {
        String sql = "INSERT INTO historico(nome_historico, ano_historico, valor_historico)VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, h.getNome_historico());
            stmt.setString(2, h.getAno_historico());
            stmt.setString(3, h.getValor_historico());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
