package texto;

import estruturas.Pilha;

public class Editor {
    private String texto;
    private Pilha pilhaDesfazer;
    private Pilha pilhaRefazer;

    public Editor(int capacidade) {
        texto = "";
        pilhaDesfazer = new Pilha(capacidade);
        pilhaRefazer = new Pilha(capacidade);
    }

    public void inserir(String novoTexto) {
        pilhaDesfazer.empilhar(texto);
        texto += novoTexto;
        pilhaRefazer = new Pilha(pilhaRefazer.getCapacidade());
    }

    public void desfazer() {
        if(!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(texto);
            texto = pilhaDesfazer.desempilhar();
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if(!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(texto);
            texto = pilhaRefazer.desempilhar();
        } else {
            System.out.println("Nada para refazer.");
        }
    }
    
    public void mostrarTexto() {
    	if(!texto.equals("")) {
    		System.out.println(texto);
    	} else {
    		System.out.println("Texto vazio.");
    	}
    }
}
