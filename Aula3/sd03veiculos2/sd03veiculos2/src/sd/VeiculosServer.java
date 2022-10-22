package sd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class VeiculosServer {
    private int serverPort;

    private List<Registo> repositorio;

    public VeiculosServer(int p) {
		serverPort= p;
		repositorio = new LinkedList<Registo>();
	//repositorio= ; // INICIALIZE com LinkedList
    }



    public static void main(String[] args){
		System.err.println("SERVER...");
		if (args.length<1) {
			System.err.println("Missing parameter: port number");
			System.exit(1);
		}
		int p=0;
		try {
	    	p= Integer.parseInt( args[0] );
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(2);
		}


		VeiculosServer serv= new VeiculosServer(p);
		serv.servico();   // activa o servico
    }

    public void servico() {

	try {
		// inicializa o socket para receber ligacoes
		ServerSocket ss = new ServerSocket(serverPort);
	    while (true) {
		// espera uma ligacao
			Socket dataSocket =  ss.accept();

			try {
		    	Object objPedido= null;
		    	// le os dados do pedido, como um OBJECTO "objPedido"
				ObjectInputStream ois = new ObjectInputStream(dataSocket.getInputStream());
				objPedido = ois.readObject();

				ObjectOutputStream oos= new ObjectOutputStream(dataSocket.getOutputStream());
				// apreciar o objecto com o pedido recebido:
		    	if (objPedido==null)
					System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");

		    	if (objPedido instanceof PedidoDeConsulta) {
					PedidoDeConsulta pc= (PedidoDeConsulta) objPedido;

					Registo reg = null;

					for(Registo r: repositorio){
						if(r.getMatricula().equals(pc.getMatricula()))
							reg= r;
					}

					if (reg != null){
						oos.writeObject(reg);
					}else{
						oos.writeObject("NÃO ENCONTRADO");
					}
			// procurar o registo associado a matricula pretendida
			// pesquisar no servidor (List, mais tarde num ficheiro)


			// enviar objecto Cliente via socket
			// se encontra devolve o registo, se não, devolve um novo objecto ou string a representar que nao encontrou
		    if (objPedido instanceof PedidoDeRegisto) {
			PedidoDeRegisto pr= (PedidoDeRegisto) objPedido; // ...


			// ver se ja existia registo desta matricula
					// adicionar ao rep local (se nao e' uma repeticao)
			boolean presente = false;
			for (Registo r: repositorio){
				if(r.getMatricula().equals(presente)){
					presente = true;
					repositorio.remove(r);
				}
			}
			repositorio.add(pr.getRegisto());
			// responder ao cliente
			oos.writeObject("Adicionado");
			}
		    else
			System.out.println("PROBLEMA");

			}
		} catch (Exception exNoAtendimento) {
				exNoAtendimento.printStackTrace();
			}finally {
                    // fechar o socket de dados dedicado a este cliente:
                    try {
                    //    AQUI: fechar o socket de dados
						dataSocket.close();
                    }
                    catch (Exception e002) {
                    }
                }

	    }
		}  // ... ciclo de atendimento
	catch (IOException e) {
		throw new RuntimeException(e);
	}

	}

}
