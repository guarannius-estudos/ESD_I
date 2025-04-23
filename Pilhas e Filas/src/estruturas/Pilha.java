package estruturas;

public class Pilha {
    private final String[] elementos;
    private final int capacidade;
    private int topo;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        elementos = new String[capacidade];
        topo = -1;
    }

    public void empilhar(String item) {
        if(topo < capacidade - 1) {
        	topo++;
            elementos[topo] = item;
        } else {
            System.out.println("Pilha cheia.");
        }
    }

    public String desempilhar() {
        if(!estaVazia()) {
            return elementos[topo--];
        }
        
        return null;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public String topo() {
        if(!estaVazia()) {
            return elementos[topo];
        }
        
        return null;
    }
    
    public int getCapacidade() {
    	return capacidade;
    }
}
