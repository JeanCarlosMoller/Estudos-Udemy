import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;

public class PDFArqExt {
    public static void main(String[] args) {
        try {
            String filePath = "C:/Users/jeanc/OneDrive/Área de Trabalho/os_pdfs/spExtratoCartao.pdf";
            String newName;

            PdfReader pdfReader = new PdfReader(filePath);

            String extractedText = PdfTextExtractor.getTextFromPage(pdfReader, 1); // Extrair texto da primeira página
            pdfReader.close();

            // Extrair alguma informação do texto, por exemplo, o primeiro nome
            String firstName = extractedText.split("Período das Informações:")[0];

            File originalFile = new File(filePath);
            String originalString = firstName;

            String modifiedString = originalString.substring(46);

            String newFileName = modifiedString + ".pdf";

            File arquivoAntigo = new File(filePath);
            File arquivoNovo = new File(arquivoAntigo.getParent(), newFileName);

            File renamedFile = new File(originalFile.getParent(), newFileName);
            originalFile.renameTo(renamedFile);

            System.out.println("Arquivo renomeado com sucesso para: " + renamedFile.getName());




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}