package impressao;

public class Documento {
    private final String nome;
    private final int tamanho;

    public Documento(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    @Override
    public String toString() {
        return nome + " - " + tamanho + "KB";
    }
}
