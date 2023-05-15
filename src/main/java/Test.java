import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;

public class Test {

    // 폰트
    public static final String consolas = "fonts\\consola.ttf";
    // pdf 저장될 폴더 경로
    public static final String basePath = "C:\\workspace\\";

    public void createItinerary() throws FileNotFoundException {
        String path = "C:\\workspace\\testItinerary.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        // header 세팅 시작
        float headerCol[] = {200f, 180f, 180f};
        Table header = new Table(headerCol);
        Style headerStyle = new Style().setBorder(Border.NO_BORDER).setFontSize(9);
        header.addCell(new Cell(3,0)
                .add("LOGO SPACE")); // 로고자리
        header.addCell(new Cell(0,2)
                .add("123, Daerung Post Tower 5 , 68, Digital-ro 9-gil, Geumcheon-gu, Seoul, Republic of Korea")
                .addStyle(headerStyle));
        header.addCell(new Cell()
                .add("TEL: 82 2 6925 7487")
                .addStyle(headerStyle));
        header.addCell(new Cell()
                .add("FAX: 82 70 4070 7486")
                .addStyle(headerStyle));
        header.addCell(new Cell()
                .add("E-mail: korea@nntdmc.com")
                .addStyle(headerStyle));
        header.addCell(new Cell()
                .add("Website: http://nntdmc.com")
                .addStyle(headerStyle));
        // header 세팅 끝

        // day&night 세팅 시작
        float dayNightCol[] = {500};
        Table dayNight = new Table(dayNightCol);




        document.add(header);

        document.close();
    }

}
