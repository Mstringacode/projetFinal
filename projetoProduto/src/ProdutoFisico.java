public class ProdutoFisico extends Produto {
    private double peso;
    private double altura;
    private double largura;
    private double profundidade;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public ProdutoFisico(int codProduto, String nome, String descricao, double preco, int quantidade, double peso, double largura, double altura, double profundidade ) {
      super(codProduto, nome, descricao, preco, quantidade);
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
    @Override
    public void imprimirProduto(){
        super.imprimirProduto();
        System.out.println("Peso:" + peso);
        System.out.println("Altura:" + altura);
        System.out.println("largura:" + largura);
        System.out.println("Profundidade:" + profundidade);

    }
}
