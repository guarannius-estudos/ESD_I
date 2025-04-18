package estruturas;

public class Lista {

    public No inicio;
    public int quantidadeNos = 0;

    public Lista() {
        this.inicio = null;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);

        if(inicio == null) {
            inicio = no;
            quantidadeNos++;
            return;
        }

        inicio.anterior = no;
        no.proximo = inicio;
        inicio = no;
        quantidadeNos++;
    }

    public void adicionarAoFinal(int valor) {
        No no = new No(valor);

        if(inicio == null) {
            inicio = no;
            quantidadeNos++;
            return;
        }

        No noAux = inicio;

        while(noAux.proximo != null) {
            noAux = noAux.proximo;
        }

        noAux.proximo = no;
        no.anterior = noAux;
        quantidadeNos++;
        System.out.println("Quantidade:" + quantidadeNos);
    }

    public void adicionarAposValor(int valor, int apos) {
        No no = new No(valor);

        if(inicio == null) {
            inicio = no;
            quantidadeNos++;
            return;
        }

        No noAux = inicio;

        while(noAux.dado != apos) {
            noAux = noAux.proximo;
        }

        no.proximo = noAux.proximo;
        no.proximo.anterior = no;
        noAux.proximo = no;
        no.anterior = noAux;
        quantidadeNos++;
        System.out.println("Quantidade:" + quantidadeNos);
    }

    public void mostrarNos() {
        Iterador iterador = getIterador();

        while(iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void mostrarNumeroDeNos() {
        System.out.println("Número de Nós na lista: " + quantidadeNos);
    }

    public void mostrarTamanhoDaLista() {
        int tamanho = 0;
        No noAux = inicio;

        while(noAux != null) {
            tamanho++;
            noAux = noAux.proximo;
        }

        System.out.println("Tamanho da lista é de " + tamanho + " elementos.");
    }

    public void remover(int valor) {
        No noAux = inicio;
        
        while(noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if(noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        noAux.anterior.proximo = noAux.proximo;
        noAux.proximo.anterior = noAux.anterior;
        quantidadeNos--;
        System.out.println("Quantidade:" + quantidadeNos);
    }

    public Iterador getIterador() {
        return new Iterador(this, inicio);
    }
}
