package candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    private String[] candidatos;
    private double salarioBase;
    private int candidatosSelecionados;
    private int candidatosAtual;
    private ArrayList<String> selecionados;

    public ProcessoSeletivo(String[] candidatos, double salarioBase) {
        this.candidatos = candidatos;
        this.salarioBase = salarioBase;
        this.candidatosSelecionados = 0;
        this.candidatosAtual = 0;
        this.selecionados = new ArrayList<>();
    }
    
    public String[] getCandidatos() {
        return candidatos;
    }
    
    public void setCandidatos(String[] candidatos) {
        this.candidatos = candidatos;
    }
    
    public int getCandidatosAtual() {
        return candidatosAtual;
    }
    
    public void setCandidatosAtual(int candidatosAtual) {
        this.candidatosAtual = candidatosAtual;
    }
    
    public int getCandidatosSelecionados() {
        return candidatosSelecionados;
    }
    
    public void setCandidatosSelecionados(int candidatosSelecionados) {
        this.candidatosSelecionados = candidatosSelecionados;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    public ArrayList<String> getSelecionados() {
        return selecionados;
    }
    
    public void setSelecionados(ArrayList<String> selecionados) {
        this.selecionados = selecionados;
    }
    
    public double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    
    public boolean atender() {
        return new Random().nextInt(3) == 1;
    }
    
    public void selecaoCandidatos() {
    	
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou o salário de " + salarioPretendido);
            analisarCandidato(candidato, salarioPretendido);
            candidatosAtual++;
        }
    }

    public void analisarCandidato(String candidato, double salarioPretendido) {
        if (salarioBase >= salarioPretendido) {
            System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
            candidatosSelecionados++;
            selecionados.add(candidato);
        } else {
            System.out.println("O candidato " + candidato + " não foi selecionado para a vaga");
        }
    }

    public void imprimirSelecionados() {
        System.out.println("Candidatos selecionados:");
        for (String selecionado : selecionados) {
            System.out.println("O candidato selecionado foi " + selecionado);
        }
    }
    
    public void contatarSelecionados() {
        for (String selecionado : selecionados) {
            entrandoContato(selecionado);
        }
    }
    
    public void atenderLigacao(boolean atendeu, String selecionado, int tentativasRealizadas) {
        if (atendeu) {
            System.out.println("Conseguimos contato com " + selecionado + " na " + tentativasRealizadas + "ª tentativa");
        } else {
            System.out.println("Não conseguimos contato com " + selecionado + ", número máximo de tentativas " + tentativasRealizadas + " realizadas");
        }
    }
    
    public void entrandoContato(String selecionado) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");
            }
            
        } while (continuarTentando && tentativasRealizadas < 3);
        
        atenderLigacao(atendeu, selecionado, tentativasRealizadas);
    }
}

