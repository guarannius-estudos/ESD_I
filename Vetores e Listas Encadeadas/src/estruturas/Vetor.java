package estruturas;

public class Vetor {

    public Integer[] elementos;
    private int tamanho;
    private int capacidade;

    public Vetor(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public void adicionar(Integer valor) {
        if(capacidade == tamanho) {
            aumentarCapacidade();
        }

        elementos[tamanho] = valor;
        tamanho++;
    }

    public void adicionarAoInicio(Integer valor) {
        tamanho++;
        
        for(int i = tamanho; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }

        elementos[0] = valor;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = capacidade + (capacidade / 2);
        Integer[] novosElementos = new Integer[novaCapacidade];

        for(int i = 0; i < tamanho; i++) {
            novosElementos[i] = elementos[i];
        }

        elementos = novosElementos;
        capacidade = novaCapacidade;
    }

    public void mostrarElementos() {
        System.out.println("-----");
        System.out.println("Elementos no vetor");

        for(int i = 0; i < tamanho; i++) {
            System.out.println(elementos[i]);
        }

        System.out.println("-----");
    }

    public void contem(Integer valor) {
        for(int i = 0; i < tamanho; i++) {
            if(elementos[i] == valor) {
                System.out.println("Valor encontrado");
                return;
            }
        }

        System.out.println("Valor não encontrado");
    }

    public void remover(int posicao) {
        if(posicao > tamanho) {
            System.out.println("Posição informada é inválida");
            return;
        }

        for(int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamanho - 1] = null;
        tamanho--;
    }

    public void removerPorValor(Integer valor) {
        for(int i = 0; i < tamanho; i++) {
            if(elementos[i] == valor) {
                remover(i);
                System.out.println("Item removido");
                return;
            }
        }

        System.out.println("Item não encontrado");
    }

    public void pesquisaBinaria(int valor) {
        int baixo = 0;
        int alto = tamanho - 1;
        int chute = 0;

        while(baixo <= alto) {
            int meio = (baixo + alto) / 2;
            chute = elementos[meio];
            
            if(chute == valor) {
                System.out.println("Achou!");
                break;
            } else if(chute > valor) {
                alto = meio - 1;
            } else {
                baixo = meio + 1;
            }
        }

        if(chute != valor) {
            System.out.println("Não achou!");
        }
    }
}
