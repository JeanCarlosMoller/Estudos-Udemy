import java.io.File;

public class RenameFileExample {
    public static void main(String[] args) {
        String filePath = "C:/Users/jeanc/OneDrive/Área de Trabalho/os_pdfs/spExtratoCartao.pdf"; // Substitua pelo caminho do seu arquivo
        String novoNome = "teste.pdf"; // Substitua pelo novo nome desejado

        File arquivoAntigo = new File(filePath);
        File arquivoNovo = new File(arquivoAntigo.getParent(), novoNome);

        if (arquivoAntigo.exists()) {
            if (arquivoAntigo.renameTo(arquivoNovo)) {
                System.out.println("Arquivo renomeado com sucesso para: " + arquivoNovo.getName());
            } else {
                System.out.println("Não foi possível renomear o arquivo.");
            }
        } else {
            System.out.println("O arquivo antigo não existe.");
        }
    }
}





