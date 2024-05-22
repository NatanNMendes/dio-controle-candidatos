package candidatura;

public class App {
    public static void main(String[] args) {
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "José"};
        double salarioBase = 2000.0;
        ProcessoSeletivo processo = new ProcessoSeletivo(candidatos, salarioBase);
        
        System.out.println("Iniciando processo seletivo.");
        
        System.out.println("Iniciando processo de seleção de candidatos.");
        processo.selecaoCandidatos();
        
        System.out.println("Imprimindo candidatos selecionados.");
        processo.imprimirSelecionados();
        
        System.out.println("Contatando candidatos selecionados.");
        processo.contatarSelecionados();
        
        System.out.println("Fim do processo seletivo.");
    }
}
