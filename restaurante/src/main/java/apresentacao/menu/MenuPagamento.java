package apresentacao.menu;
import serviços.TipoPagamento;
import utilitarios.Video;
import utilitarios.Teclado;
import modelos.Pedido;

public class MenuPagamento {

    private String resposta;

    
    public static TipoPagamento exibir(Pedido pedido) {

        if(pedido.calcularPagamento() == 0) {
            Video.mensagemErro("O pedido não possui itens. Adicione pratos antes de finalizar o pagamento.");
            return null;
        }
        
        String resposta = Teclado.readString("ReDeseja incluir taxa de serviço? s/n: ");
        if(Character.toLowerCase(resposta.charAt(0)) == 's') {
            pedido.setIncluiTaxaServico(true);
            Video.mensagemOk("Taxa de serviço será incluída no pedido.");
            Video.pausa();

        } else {
            pedido.setIncluiTaxaServico(false);
            Video.mensagemOk("Taxa de serviço não será incluída no pedido.");
            Video.pausa();
        }
       
        Video.limparTela();
        Video.mensagemInfo("Valor: $" + pedido.calcularPagamento());
        System.out.println("Selecione o método de pagamento\n:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Cartão de Débito");
        System.out.println("4 - Pix");
        int opcao = Teclado.readInt("\nEscolha uma opção: ");
        switch (opcao) {
            case 1:
                Video.mensagemOk("Pedido finalizado. Total a pagar: R$ " +  pedido.calcularPagamento()+ " via Dinheiro.");
                return TipoPagamento.DINHEIRO;
            
            case 2:
                Video.mensagemOk("Pedido finalizado. Total a pagar: R$ " +  pedido.calcularPagamento()+ " via Cartão de Credito.");
                return TipoPagamento.CARTAO_CREDITO;

            case 3:
                Video.mensagemOk("Pedido finalizado. Total a pagar: R$ " +  pedido.calcularPagamento()+ " via Cartão de Debito.");
                return TipoPagamento.CARTAO_DEBITO;
            
            case 4:
                Video.mensagemOk("Pedido finalizado. Total a pagar: R$ " +  pedido.calcularPagamento()+ " via Pix.");
               return TipoPagamento.PIX;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                return exibir(pedido);
        }
        
    }

}
