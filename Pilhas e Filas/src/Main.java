import impressao.Impressora;
import texto.Editor;

public class Main {
    public static void main(String[] args) {
    	
    	Editor editor = new Editor(10);

        editor.inserir("Estrutura");
        editor.mostrarTexto();
        editor.inserir(" de");
        editor.mostrarTexto();
        editor.desfazer();
        editor.mostrarTexto();
        editor.refazer();
        editor.mostrarTexto();
        editor.inserir(" Dados.");
        editor.mostrarTexto();
        editor.desfazer();
        editor.desfazer();
        editor.desfazer();
        editor.mostrarTexto();
    	
        
        Impressora impressora = new Impressora(5);

        impressora.adicionar("Trabalho1.pdf", 120);
        impressora.adicionar("Trabalho2.pdf", 85);
        impressora.mostrarFila();
        impressora.imprimir();
        impressora.mostrarFila();
        impressora.adicionar("Trabalho3.pdf", 300);
        impressora.mostrarFila();
        impressora.imprimir();
        impressora.imprimir();
        impressora.mostrarFila();
    }
}
