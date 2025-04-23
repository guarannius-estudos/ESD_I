package estruturas;

public class Fila {
    private final String[] elementos;
    private final int capacidade;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        elementos = new String[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enfileirar(String item) {
        if(tamanho < capacidade) {
            elementos[fim] = item;
            fim++;

            if(fim == capacidade) {
                fim = 0;
            }

            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    public String desenfileirar() {
        if(!estaVazia()) {
            String item = elementos[inicio];
            inicio++;

            if(inicio == capacidade) {
                inicio = 0;
            }
            
            tamanho--;
            return item;
        }
        
        return null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void mostrarFila() {
        System.out.println("Fila de Impressão:");
        
        for(int i = 0; i < tamanho; i++) {
            int index = inicio + i;

            if(index == capacidade) {
            	index = 0;
            }

            System.out.println("-> " + elementos[index]);
        }
    }
}
