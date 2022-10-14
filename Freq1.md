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
