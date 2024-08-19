package br.com.syonet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.text.DecimalFormat;

public class App {

public static void main(String[] args) {
    String caminhoArquivo = "/home/guilherme/Auladev/Aula2/arquivo_fornecido.csv";
    BufferedReader leitor = null;
    int linhaCount = 0;

    List<Filial> filiais = new ArrayList<>();

    try {
        FileReader leitorArquivo = new FileReader(caminhoArquivo);
        leitor = new BufferedReader(leitorArquivo);

        String linha = leitor.readLine(); 
while(linha != null){ 
     if (linhaCount == 0) {
    
        linhaCount++;
        linha = leitor.readLine();
        continue;     
}

String[] colunas = linha.split(",");

Filial listafilial = new Filial();
listafilial.nome = colunas[0];
listafilial.endereco = colunas[1];
listafilial.cidade = colunas[2];
listafilial.codigoPostal = colunas[3];
List<Integer> visitasMensais = new ArrayList<>();
                for (int i = 4; i < 16; i++) {
                    visitasMensais.add(Integer.parseInt(colunas[i]));
                }
                listafilial.visitasMensais = visitasMensais;

                try {
                    listafilial.visitasAnuais = Integer.parseInt(colunas[16]);
                } catch (NumberFormatException e) {
                    listafilial.visitasAnuais = 0;
                    System.out.println("Sem valor numérico " + colunas[16]);
                }
                listafilial.geolocalizacao = colunas[17];
                filiais.add(listafilial);

                linha = leitor.readLine(); 
                
            }
                Filial maiorMediaFilial = filiais.stream()
                .max(Comparator.comparingDouble(Filial::getMediaMensalVisitas))
                .orElse(null);
                if (maiorMediaFilial != null) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println("Maior média de visitas: " 
                        + maiorMediaFilial.nome + " com média de " 
                        + df.format(maiorMediaFilial.getMediaMensalVisitas()));
                            for (Filial filial : filiais) {
                                System.out.println(filial.nome + " - Média de Visitas: " + df.format(filial.getMediaMensalVisitas()));
                              }
                }
                        } catch (IOException e) {
                            System.out.println("Arquivo não encontrado");
                        }
                    }
                }

