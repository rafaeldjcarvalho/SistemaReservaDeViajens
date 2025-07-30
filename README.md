# SistemaReservaDeViajens
Um sistema que valida reservas, fazendo comunicação com sistemas extenos.
<h1 align="center" style="font-weight: bold;">Sistema para Reserva de Viajens 💻</h1>

<p align="center">
    <a href="#technologies">Tecnologias</a> • 
    <a href="#started">Começando</a> • 
    <a href="#routes">API Endpoints</a> •
    <a href="#colab">Collaborators</a> •
</p>

<p align="center">
    <b>Um sistema que valida reservas de viajens, simulando comunicação com outros sistemas. A ideia é criar uma Plataforma de Reservas de Viagens, onde o sistema principal depende de serviços externos antes de confirmar uma reserva.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Lista de todas as Tecnologias usadas:
- Java
- Spring
- Maven
- H2 Database

<h2 id="started">🚀 Começando</h2>

Aqui está a descrição detalhada para rodar o projeto localmente.

<h3>Pré-requisitos</h3>

Aqui está a lista de todos os pré-requisitos necessários para rodar o projeto.

- [Java JDK 17+](https://adoptium.net/pt-BR/temurin/releases?version=17)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- IDE (opcional):
    - Intellij
    - VSCode
    - Eclipse

<h3>Clonando projeto</h3>

Como clonar o projeto

```bash
git clone https://github.com/rafaeldjcarvalho/SistemaReservaDeViajens
```

<h3>Configurações básicas</h3>

Substitua as variáveis do application.properties do Serviço Booking:

```bash
app.flightAvailabilityAPI = "link do serviço"
app.paymentStatusAPI = "link do serviço"
server.port=8080
```

Adicione a variável do application.properties do Serviço FlightAvailability:

```bash
server.port=8081
```

Adicione a variável do application.properties do Serviço PaymentStatus:

```bash
server.port=8082
```

<h3>Rodar o projeto</h3>

- Via IDE(IntelliJ, VSCode, Eclipse):
    - Abra o projeto na IDE.
    - Vá até a pasta de cada serviço(BookingApplication, etc).
    - Execute as classes Application de cada serviço.
- Via terminal:
    - Dentro da pasta de cada serviço, execute:
    ```bash
    cd <Nome do serviço>
    mvn spring-boot:run
    ``` 
    - Exemplo:
    ```bash
    cd Booking
    mvn spring-boot:run
    ``` 

    Agora faça o mesmo com os outros serviços, trocando a pasta.


<h2 id="routes">📍 API Endpoints</h2>

Aqui está a lista das principais rotas da API e o que elas fazem.

- Fluxo Principal
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /Bookings</kbd>      | Recupera as reservas criadas.
| <kbd>POST /Bookings</kbd>     | Criar uma reserva, ver [request details](#post-booking-detail)


<h3 id="post-booking-detail">POST /Bookings</h3>

**REQUEST**
```json
{
  "customerId": "abc-123",
  "flightId": "FL123"
}
```

**RESPONSE**
```json
{
  "status": "CONFIRMED",
  "ticketCode": "BOOK-20250612-XY99"
}
```
Ou em caso de falha:
**RESPONSE**
```json
{
  "status": "REJECTED",
  "reason": "Flight not available"
}
```

- Serviços Externos

1. FlightAvailabilityService

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /flights/check-availability</kbd>     | Avaliar voo, ver [request details](#post-flight-detail)

<h3 id="post-flight-detail">POST /flights/check-availability</h3>

**REQUEST**
```json
{
  "flightId": "FL123"
}
```

**RESPONSE**
```json
{
  "status": "AVAILABLE" | "UNAVAILABLE",
  "availableSeats": 12
}
```
2. PaymentStatusService

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /payment/status</kbd>     | Status de pagamento, ver [request details](#post-payment-detail)

<h3 id="post-payment-detail">POST /payment/status</h3>

**REQUEST**
```json
{
  "customerId": "abc-123",
  "flightId": "FL123"
}
```

**RESPONSE**
```json
{
  "status": "PAID" | "PENDING" | "FAILED",
  "paymentDate": "2025-06-10T15:00:00"
}
```

Fluxo Resumido

```plaintext
Usuário → BookingService
              |
              |→ FlightAvailabilityService
              |     ↳ AVAILABLE
              |
              |→ PaymentStatusService
              |     ↳ PAID
              |
       ↳ Gera ticket, salva no banco
```

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/141766102?v=4" width="100px;" alt="Rafael Profile Picture"/><br>
        <sub>
          <b>Rafael de Jesus Carvalho</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
