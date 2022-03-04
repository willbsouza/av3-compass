## Avaliação 3 - Compass.UOL

### API REST com Spring Boot

### Documentação com Swagger pode ser acessada pelo endpoint: /swagger-ui.html

#### Entidade State com os atributos:
<ul>
<li>id : Long</li>
<li>nome : String </li>
<li>regiao : Enum</li>
<li>populacao : Integer</li>
<li>capital : String</li>
<li>area : Double</li>
<li>dataDeFundacao : LocalDate</li>
<li>tempoDeFundacao : Integer</li>
</ul>

Endpoints: 

<ul>
<li>POST - /api/states</li>
<li>GET - /api/states</li>
<li>GET - /api/states/{id}</li>
<li>PUT - /api/states/{id}</li>
<li>DELETE - /api/states/{id}</li> 
</ul>

### Endpoints com filtros (Recebem 1 parâmetro):
<ul>
<li>GET - /api/states/regiao?nome=?</li>
<li>GET - /api/states/area?valor=?</li>
<li>GET - /api/states/populacao?valor=?</li>
</ul>

#### H2 Database;
#### Arquivo data.sql inicialmente populado com 8 inserts;
#### Tratamento de exceções com Handler;
#### O atributo região só aceita os valores: Norte, Nordeste, Sul, Sudeste e Centro-Oeste;
#### Validação do tempo de fundação e data de fundacao do estado;
#### Os EndPoints /api/states/area?valor=? e /api/states/populacao?valor=?, retornam os estados com valores maiores ou igual ao parâmetro informado em ordem decrescente;
