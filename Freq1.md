# Middleware
## Pontos chave:
Os sistemas distribuídos estão se tornando cada vez mais complexos à medida que estão envolvidos em atividades que abrangem um ecossistema de parceiros, fornecedores e clientes.

Uma forma de conseguir essa integração é através do uso de middleware. Nos últimos anos, houve um aumento no número de soluções de middleware disponíveis no mercado.
No entanto, devido a essa variedade de opções disponíveis, tornou-se vital para as empresas identificar primeiro que tipo de solução elas precisam antes de tomar uma decisão de compra.

# RMI (Remote Method Invocation) 
uma API que fornece
um mecanismo para criar aplicatções distribuídas em java.
O RMI permite que um objeto invoque métodos num objeto que
está a rodar noutra JVM.

O RMI fornece comunicação remota entre os aplicativos
usando dois objetos stub e skeleton.

Um objeto remoto é um objeto cujo método pode ser invocado
de outra JVM.

## Stub
O stub é um objeto, atua como um gateway para o lado do cliente.
Todas as solicitações de saída são roteadas por ele. Ele reside em
lado do cliente e representa o objeto remoto.
Quando o chamador invoca o método no objeto stub, ele faz o
seguintes tarefas:

Ele inicia uma conexão com a máquina virtual remota (JVM),
Ele escreve e transmite (marshals) os parâmetros para o controle remoto
Máquina Virtual (JVM),
Ele espera o resultado
Ele lê (unmarshals) o valor de retorno ou exceção e
Finalmente, retorna o valor para o chamador.

## Skeleton
É um objeto, atua como um gateway para o servidor
objeto lateral. Todas as solicitações recebidas são roteadas por ele.
Quando o esqueleto recebe o pedido de entrada, ele faz o
seguintes tarefas:

Ele lê o parâmetro para o método remoto
Ele invoca o método no objeto remoto real e
Ele grava e transmite (marshals) o resultado para o chamador.
