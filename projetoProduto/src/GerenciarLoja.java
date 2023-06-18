import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarLoja {
        private static Loja loja = new Loja();
        private static  Carrinho carrinho = new Carrinho();

       private static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
           GerenciarLoja gl = new GerenciarLoja();

            int opcao = 0;
            do{
                System.out.println("Menu Principal");
                System.out.println("1. Cadastrar Produto:");
                System.out.println("2. Emitir Relatorio:");
                System.out.println("3. Adicionar produto ao carrinho:");
                System.out.println("4. Remover produto do Carrinho:");
                System.out.println("5. Preço total:");
                System.out.println("6. Processar compra: ");
                System.out.println("7. Informações do produto escolhido:");
                System.out.println("8. Sair");
                System.out.println("Escolha sua opção: ");

                opcao = sc.nextInt();
                int codProduto = 0;
                switch (opcao){
                    case 1:
                        loja.cadastrarProduto();
                        break;
                    case 2:
                        loja.exibirRelatorio();
                        break;
                    case 3:
                        try {
                            System.out.println("Código do Produto:");
                            codProduto = sc.nextInt();
                            Produto produto = loja.retornaProduto(codProduto);
                            carrinho.adicionarProduto(produto);


                        }catch (ProdutoNaoEncontradoException ex){
                            System.out.println("Produto não encontrado " + codProduto);
                        }
                        break;
                    case 4:
                        System.out.println("Código do Produto:");
                        codProduto = sc.nextInt();
                        carrinho.removerProduto(codProduto);
                        break;
                    case 5:
                        double valorTotal=carrinho.calcularValorTotal();
                        System.out.println(valorTotal);
                        break;
                    case 6:
                        loja.processarCompra(carrinho);
                        break;
                    case 7:
                        try {
                            System.out.println("Código do Produto:");
                            codProduto = sc.nextInt();
                            loja.exibirInfoProduto(codProduto);
                        }catch (ProdutoNaoEncontradoException exception){
                            System.out.println("Produto com Id não encontrado " + codProduto);
                        }
                        break;
                    case 8:
                        System.out.println("Fim do programa");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }while(opcao!=9);
        }





}
