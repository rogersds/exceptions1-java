# Projeto de Sistema de Reservas de Quartos

Este projeto simula um sistema de reservas de quartos de hotel, onde o usuário pode fazer uma reserva e atualizar as datas de check-in e check-out. O código foi desenvolvido em duas versões, com melhorias progressivas de tratamento de erros e lógica de negócio.

## Estrutura do Projeto

O projeto é dividido em dois pacotes principais:

- **application:** Contém o programa principal (`Program.java`), que interage com o usuário e gerencia o fluxo do programa.
- **model.entities:** Contém a classe `Reservation`, que representa uma reserva de quarto.
- **model.exceptions:** Contém a classe `DomainException`, usada para tratar exceções de domínio.

## Versão 1

### Descrição

Na primeira versão, o sistema permite a criação de reservas e a atualização das datas de check-in e check-out. No entanto, a lógica de verificação das datas é simples, sem tratamentos adequados para erros, como datas inválidas ou inconsistências nas regras de negócio.

### Funcionalidades

- Criação de reservas com número do quarto, data de check-in e data de check-out.
- Atualização das datas de check-in e check-out.
- Cálculo da duração da estadia em dias.
- Conversão de datas para o formato `dd/MM/yyyy` utilizando `SimpleDateFormat`.

### Limitações

- **Sem validações:** Não há verificação se a data de check-out é anterior à data de check-in.
- **Sem tratamento de exceções:** Não há tratamento para formatos de datas inválidos ou outros erros de domínio.
- **Código mais suscetível a erros:** O código não possui um mecanismo robusto para lidar com situações inesperadas.

## Versão 2

### Descrição

Na segunda versão, foram implementadas melhorias significativas em termos de validação de dados e tratamento de exceções, tornando o código mais robusto e seguro para evitar inconsistências.

### Melhorias Implementadas

1. **Validação de Datas no Construtor:**
   - Ao criar uma reserva, o sistema agora valida se a data de check-out é posterior à data de check-in. Caso contrário, uma exceção do tipo `DomainException` é lançada com uma mensagem adequada.

2. **Tratamento de Exceções:**
   - Adicionada uma estrutura de tratamento de exceções no programa principal (`Program.java`), para capturar e tratar erros de parsing de datas (`ParseException`), erros de domínio (`DomainException`) e outros erros inesperados (`RuntimeException`).

3. **Validação de Datas Futuras na Atualização de Reserva:**
   - Ao atualizar as datas de check-in e check-out, o sistema valida se ambas as datas são futuras e se a data de check-out é posterior à data de check-in, lançando uma `DomainException` caso essas condições não sejam atendidas.

4. **Melhoria na Representação da Reserva:**
   - O método `toString()` foi aprimorado para fornecer uma descrição mais clara da reserva, incluindo o número do quarto, as datas formatadas de check-in e check-out, e a duração da estadia em noites.

### Exemplo de Saída

```text
Room 101, check-in: 01/09/2024, check-out: 05/09/2024, 4 nights
