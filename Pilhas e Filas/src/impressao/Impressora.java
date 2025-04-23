package impressao;

import estruturas.Fila;

public class Impressora {
    private final Fila fila;
    private final Documento[] documentos;
    private int inicio;
    private int fim;

    public Impressora(int capacidade) {
        fila = new Fila(capacidade);
        documentos = new Documento[capacidade];
        inicio = 0;
        fim = 0;
    }

    public void adicionar(String nome, int tamanho) {
        Documento doc = new Documento(nome, tamanho);
        fila.enfileirar(nome);
        documentos[fim] = doc;
        fim++;

        if(fim == documentos.length) {
        	fim = 0;
        }

        System.out.println("Documento adicionado: " + doc);
    }

    public void imprimir() {
        String nome = fila.desenfileirar();
        
        if(nome != null) {
            Documento doc = documentos[inicio];
            inicio++;

            if(inicio == documentos.length) {
            	inicio = 0;
            }
            
            System.out.println("Imprimindo: " + doc);
        } else {
            System.out.println("Nenhum documento na fila.");
        }
    }

    public void mostrarFila() {
        fila.mostrarFila();
    }
}
