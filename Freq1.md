# Middleware
## Pontos chave:
Os sistemas distribuídos estão se tornando cada vez mais complexos à medida que estão envolvidos em atividades que abrangem um ecossistema de parceiros, fornecedores e clientes.

Uma forma de conseguir essa integração é através do uso de middleware. Nos últimos anos, houve um aumento no número de soluções de middleware disponíveis no mercado.
No entanto, devido a essa variedade de opções disponíveis, tornou-se vital para as empresas identificar primeiro que tipo de solução elas precisam antes de tomar uma decisão de compra.

## Vantagens do Middleware em Sistemas Distribuídos:
Middleware é uma camada intermediária de software que fica entre o aplicativo e a rede. Ele é usado em sistemas distribuídos para fornecer serviços comuns, como autenticação, autorização, compilação para melhor desempenho em arquiteturas específicas, tradução de entrada/saída e tratamento de erros.

Middleware oferece uma série de vantagens para sistemas distribuídos. O middleware pode ser modularizado a partir do aplicativo para que tenha melhor potencial de reutilização com outros aplicativos executados em diferentes plataformas.

Os desenvolvedores de aplicativos podem projetar Middleware para que seja de nível suficientemente alto para se tornar independente de ambientes de hardware específicos ou plataformas de sistema operacional, o que simplifica a portabilidade de aplicativos desenvolvidos em um tipo de plataforma para outra sem reescrever código ou sem recorrer a conjuntos de ferramentas de compatibilidade binária ineficientes e caros, como compiladores cruzados.

# Comunicação Sincrona e Assincrona

Na Comunicação Síncrona, os dados são enviados na forma de blocos ou quadros. Esta transmissão é do tipo full-duplex. Entre emissor e receptor, a sincronização é obrigatória. Na transmissão síncrona, não há lacuna entre os dados. É mais eficiente e mais confiável do que a transmissão assíncrona para transferir uma grande quantidade de dados.

Comunicação Assíncrona: Na Transmissão Assíncrona, os dados são enviados em forma de byte ou caractere. Esta transmissão é do tipo half-duplex. Nesta transmissão, os bits de início e os bits de parada são adicionados aos dados. Não requer sincronização.

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
