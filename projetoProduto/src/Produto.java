public abstract class  Produto {

    protected int codProduto;
    protected String nome;
    protected String descricao;
    protected double preco;
    protected int quantidade;

    public Produto(int codProduto, String nome, String descricao, double preco, int quantidade) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return  preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void  imprimirProduto(){
        System.out.println("Código:" + codProduto);
        System.out.println("Nome:" + nome);
        System.out.println("Descrição:" + descricao);
        System.out.println("Preço:" + preco);
        System.out.println("Quantidade:" + quantidade);
    }
    public void reduzirEstoque() throws EstoqueInsuficienteEXception{
        if (quantidade > 0){
            quantidade -= 1;
        }else {
            throw new EstoqueInsuficienteEXception();
        }
    }
}
