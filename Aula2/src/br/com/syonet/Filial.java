package br.com.syonet;

import java.util.List;
        
    public class Filial {
        String nome;
        String endereco;
        String cidade;
        String codigoPostal;
        List<Integer> visitasMensais;
        int visitasAnuais;
        String geolocalizacao;
    
        // Construtor padrão (sem parâmetros)
        public Filial() {
        }
        public double getMediaMensalVisitas() {
            if (visitasMensais != null && !visitasMensais.isEmpty()) {
                return visitasAnuais / (double) visitasMensais.size();
            }
            return 0;
        }
    }

