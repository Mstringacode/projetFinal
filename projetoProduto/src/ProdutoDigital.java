public class ProdutoDigital extends Produto {
    private String formato;
    private double tamanhoMB;


    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamanhoMB() {
        return tamanhoMB;
    }

    public void setTamanhoMB(double tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }


    public ProdutoDigital(int codProduto, String nome, String descricao, double preco, int quantidade, double tamanhoMB, String formato) {
        super(codProduto, nome, descricao, preco, quantidade);
        this.formato = formato;
        this.tamanhoMB = tamanhoMB;
    }

    @Override
    public void imprimirProduto(){
        super.imprimirProduto();
        System.out.println("Tamanho:" + tamanhoMB);
        System.out.println("Formato:" + formato);
    }

}
