import java.util.ArrayList;
import java.util.List;


public class Carrinho {

    private List<Produto> listCompra = new ArrayList<>();


    public void adicionarProduto(Produto produto) {
        listCompra.add(produto);
        System.out.println("Produto adicionado ao carrinho");
    }

    public void removerProduto( int codProduto) {
        Produto produtoEncontrado = null;
        for(Produto produto: listCompra) {
            if (codProduto == produto.getCodProduto()){
                produtoEncontrado = produto;
                System.out.println("Produto removido:" + produto.nome);
                break;
            }else {
                System.out.println("produto não encontrado");
            }
        }
        if (produtoEncontrado !=null){
            listCompra.remove(produtoEncontrado);
        }

    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Produto produto : listCompra) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }
    public List<Produto> retornaLista(){
        return listCompra;
    }
    public void esvaziarLista(){
        listCompra.clear();
    }


}