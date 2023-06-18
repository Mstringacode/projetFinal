import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Loja {
    private Scanner sc = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(){
        Produto produto;
        int codProduto = 0;
        System.out.println("Cadastrando Produto:");
        System.out.println("----------------------------");
        System.out.println("Nome:");
        String nome = sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Preço:");
        double preco = sc.nextDouble();
        while (true){
            System.out.println("Código do Produto:");
            codProduto = sc.nextInt();
            try{
                retornaProduto(codProduto);
                System.out.println("Código já cadastrado");
            }catch (ProdutoNaoEncontradoException exception){
                break;
            }

        }

        System.out.println("Quatidade de produto:");
        int quantidade = sc.nextInt();
        System.out.println("1 para Produto Fisico ou 2 para Produto Digital:");
        int tipo = sc.nextInt();
        while (tipo !=1 && tipo !=2 ){
            System.out.println(" 1 para Produto Fisico ou 2 para Produto Digital:");
            tipo = sc.nextInt();
        }
        if (tipo == 1) {
            System.out.println("Peso:");
            double peso = sc.nextDouble();
            System.out.println("Altura:");
            double altura = sc.nextDouble();
            System.out.println("Largura:");
            double largura = sc.nextDouble();
            System.out.println("Profundidade:");
            double profundidade = sc.nextDouble();
            produto = new ProdutoFisico(codProduto, nome,  descricao,  preco,  quantidade,  peso,  largura,  altura,  profundidade );
        }
        else {
            System.out.println("Tamanho:");
            double tamanho = sc.nextDouble();
            System.out.println("Formato:");
            String formato = sc.next();
            produto = new ProdutoDigital(codProduto, nome,  descricao,  preco,  quantidade, tamanho, formato);
        }
        produtos.add(produto);
    }

        public void exibirRelatorio(){
            System.out.println("Relatorios dos produtos: ");
                for (Produto produto:produtos){
                    produto.imprimirProduto();
                }
        }

        public void exibirInfoProduto(int codProduto) throws ProdutoNaoEncontradoException{
            for (Produto produto : produtos){
                if (codProduto == produto.getCodProduto()){
                    produto.imprimirProduto();
                    return;
                }
            }
            throw new ProdutoNaoEncontradoException();
        }
        public Produto retornaProduto(int codProduto) throws ProdutoNaoEncontradoException{
            for (Produto produto:produtos){
                if(codProduto == produto.getCodProduto()){
                    return produto;
                }
            }
            throw new ProdutoNaoEncontradoException();

        }
        public void processarCompra(Carrinho carrinho){
            for (Produto produto : carrinho.retornaLista()){
               try {
                   produto.reduzirEstoque();
                   System.out.println("Produto Comprado " + produto.getCodProduto());
               }catch (EstoqueInsuficienteEXception ex){
                   System.out.println("Produto não disponivel em estoque " + produto.getCodProduto());
               }

            }
            System.out.println("Compra finalizada");
            carrinho.esvaziarLista();
        }





}
