COMO RODAR O PROGRAMA </br>
PROGRAMAS NECESSÁRIOS: </br>
-NetBeans </br>
-MySQL </br>
</br>
1 - Baixe os arquivos principais, recorte os arquivos "mysql-connector-java-5.1.47" e "Dump20230213" e cole-os em algum outro diretório. </br></br>
2 - Importe os arquivos principais para o NetBeans, vá em "Bibliotecas" dentro do arquivo na IDE, clique com o botão direito, "adicionar JAR/PASTA" e adicione o "mysql-connector-java-5.1.47" </br></br>
3 - Dentro dos arquivos "ConnectionFactory", "FuncAdicionar", "Histórico", "HistoricoFunc", "Pedidos" e "Produtos" vão ter uma linha de código escrito 'con = DriverManager.getConnection("jdbc:mysql://localhost/beto_celulares", "root", "");'.
 Vá no espaço vazio (logo após "root") e coloque a senha do seu banco de dados MySQL. </br></br>
4 - Abra o MySQL. </br></br>
5 - Vá na aba Server e importe o Dump como self-contained.
