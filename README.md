Ol� Criei o projeto que voc�s pediram, mas n�o consegui utiliza o Vue.js.
Na parte web fico implementado somente a listagem do produto com o create que n�o est� funcionando.
Mas fazendo os testes com o JUNIT o crud est� funcionando corretamente, tanto na parte do fabricante quanto na
parte do produto.

Para o projeto funciona e preciso importar utilizando projeto maven e depois quando o projeto estive criado, ir em
properties->project facet, e marca as op��es Dynamic Web Module version 3.0, Java 1.7 ou maior, JAVASCRIPT version 1.0
JAX-RS(Rest Web Services) version 2.0, JPA version 2.1.
Depois ir em na pasta META-INF no arquivo persistence.xml para configurar o banco de dados e preciso criar o banco manualmente l� no MYSQL.
Logo ap�s fazer as configura��es da base de dados ir no pacote com.hepta.mercado.test na class HibernateClass.java e 
executar o metodo testeUpdate para fazer as cria��es das tabelas na base de dados.

