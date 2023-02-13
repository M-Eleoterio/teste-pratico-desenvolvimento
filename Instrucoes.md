## Como rodar o programa </br>

PROGRAMAS NECESSÁRIOS: </br>
-NetBeans </br>
-MySQL </br>
</br>
 - Baixe os arquivos principais, recorte os arquivos "mysql-connector-java-5.1.47" e "Dump20230213" e cole-os em algum outro diretório. </br></br>
 - Importe os arquivos principais para o NetBeans, vá em "Bibliotecas" dentro do arquivo na IDE, clique com o botão direito, "adicionar JAR/PASTA" e adicione o "mysql-connector-java-5.1.47" </br></br>
 - Dentro dos arquivos "ConnectionFactory", "FuncAdicionar", "Histórico", "HistoricoFunc", "Pedidos" e "Produtos" vão ter uma linha de código escrito 'con = DriverManager.getConnection("jdbc:mysql://localhost/beto_celulares", "root", "");'.
 Vá no espaço vazio (logo após "root") e coloque a senha do seu banco de dados MySQL. </br></br>
 - Abra o MySQL. </br></br>
 - Vá na aba Server e importe o Dump como self-contained.
