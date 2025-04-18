package estruturas;

public class Iterador {
    
    private Lista lista;
    private No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return atual.proximo != null;
    }

    public Boolean haAnterior() {
        return atual.anterior != null;
    }

    public void proximo() {
        atual = atual.proximo;
    }

    public void anterior() {
        atual = atual.anterior;
    }

    public void adicionarAposAtual(int valor) {
        if(atual == null) {
            return;
        }

        No noAux = new No(valor);
        noAux.proximo = atual.proximo;
        noAux.anterior = atual;
        atual.proximo = noAux;

        if(noAux.proximo != null) {
            noAux.proximo.anterior = noAux;
        }

        lista.quantidadeNos++;
    }

    public void adicionarAntesAtual(int valor) {
        if(atual == null) {
            return;
        }

        No noAux = new No(valor);

        if(atual.anterior == null) {
            lista.inicio.anterior = noAux;
            noAux.proximo = lista.inicio;
            lista.inicio = noAux;
        } else {
            noAux.proximo = atual;
            noAux.anterior = atual.anterior;
            atual.anterior.proximo = noAux;
            atual.anterior = noAux;
        }

        lista.quantidadeNos++;
    }

    public void removerAposAtual() {
        if(atual == null) {
            return;
        }

        atual.proximo = atual.proximo.proximo;
        atual.proximo.anterior = atual;
        lista.quantidadeNos--;
    }

    public void removerAntesAtual() {
        if(atual == null || atual.anterior == null) {
            return;
        }

        if(atual.anterior.anterior == null) {
            atual.anterior = null;
            lista.inicio = atual;
        } else {
            atual.anterior = atual.anterior.anterior;
            atual.anterior.proximo = atual;
        }

        lista.quantidadeNos--;
    }

    public void resetar() {
        atual = lista.inicio;
    }

    public int getDadoProximo() {
        return atual.proximo.dado;
    }

    public int getDadoAnterior() {
        return atual.anterior.dado;
    }

    public int getDado() {
        return atual.dado;
    }

    public No getAtual() {
        return atual;
    }

    public void display() {
        if(haAnterior()) {
            System.out.print("Anterior -> " + getDadoAnterior() + " | ");
        }

        System.out.print("No " + getDado());
        
        if(haProximo()) {
            System.out.println(" | Proximo -> " + getDadoProximo());
        }

        System.out.println("");
        proximo();
    }
}
