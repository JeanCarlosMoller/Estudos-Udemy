import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoverArquivo {
    public static void main(String[] args) {
        String caminhoOrigem = "C:/Users/jeanc/OneDrive/Área de Trabalho/os_pdfs";
        String caminhoDestinoBase = "C:/Users/jeanc/OneDrive/Área de Trabalho/extrato";

        File pastaOrigem = new File(caminhoOrigem);
        File[] arquivos = pastaOrigem.listFiles();

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && arquivo.getName().toLowerCase().endsWith(".pdf")) {
                    String nomeArquivo = arquivo.getName();
                    String[] partesNome = nomeArquivo.split("_");

                    if (partesNome.length > 0) {
                        String codigo = partesNome[0];
                        File pastaDestino = new File(caminhoDestinoBase, codigo);

                        if (!pastaDestino.exists()) {
                            pastaDestino.mkdirs();
                        }

                        File destinoArquivo = new File(pastaDestino, nomeArquivo);
                        Path origemPath = arquivo.toPath();
                        Path destinoPath = destinoArquivo.toPath();

                        try {
                            Files.move(origemPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Arquivo " + nomeArquivo + " movido para a pasta de destino " + pastaDestino.getAbsolutePath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}