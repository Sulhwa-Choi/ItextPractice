import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Practice {

    public static final String consolas = "fonts\\consola.ttf";

    public void create() throws MalformedURLException, FileNotFoundException {

        // 이미지 주소
        String imgSrc = "images\\tree.png";
        ImageData data = ImageDataFactory.create(imgSrc);
        Image image1 = new Image(data);

        String path = "C:\\workspace\\FirstPdf.pdf";
        String paraText = "pdf is already open222";
        Paragraph paragraph1 = new Paragraph(paraText);
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(paragraph1);
        document.add(image1);

        document.close();
    }

    public void addList() throws FileNotFoundException {

        List list1 = new List();
        list1.add("Java");
        list1.add("Android");
        list1.add("Python");
        list1.add("C");

        String path = "C:\\workspace\\FirstPdf.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        document.add(list1);
        document.close();


    }

    public void font() throws IOException {

        String path = "C:\\workspace\\font.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont boldFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

        Text text1 = new Text("You are Nice").setFont(font);
        Text text2 = new Text("Eres hermosa").setFont(boldFont);

        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(text2);

        document.add(paragraph);
        document.close();
    }

    public void fontFromDirectory() throws IOException {

        String path = "C:\\workspace\\font.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(consolas, true);
        PdfFont boldFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

        Text text1 = new Text("You are Nice").setFont(font);
        Text pause = new Text("\n");
        Text text2 = new Text("Eres hermosa").setFont(boldFont);

        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(pause)
                .add(text2);

        document.add(paragraph);
        document.close();
    }

    public void font3() throws IOException {

        String path = "C:\\workspace\\font3.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

        Text text1 = new Text("Normal").setFont(font);
        Text text2 = new Text("\nsetBold").setFont(font).setBold();
        Text text3 = new Text("\nsetItalic").setFont(font).setItalic();
        Text text4 = new Text("\nsetUnderline").setFont(font).setUnderline();
        Text text5 = new Text("\nsetBold and setItalic").setFont(font).setBold().setItalic();
        Text text6 = new Text("\nsetFontColor Blue").setFont(font).setFontColor(Color.BLUE);
        Text text7 = new Text("\nsetBold and setFontColor Green").setFont(font).setBold().setFontColor(Color.GREEN);

        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(text2)
                .add(text3)
                .add(text4)
                .add(text5)
                .add(text6)
                .add(text7);
        document.add(paragraph);

        document.close();
    }

    public void setStyle() throws FileNotFoundException {
        String path = "C:\\workspace\\setStyle.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Style author = new Style();
        author.setFontColor(Color.BLUE)
                .setFontSize(40f)
                .setItalic();

        Paragraph paragraph1 = new Paragraph();
        paragraph1.add("hello, how are you?").addStyle(author);

        document.add(paragraph1);
        document.close();
    }



    public void table() throws FileNotFoundException {
        String path = "C:\\workspace\\table.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float columnWidth[] = {200f, 50f, 100f};
        Table table = new Table(columnWidth);

        Cell cell_11 = new Cell();
        cell_11.add("Item");
        table.addCell(cell_11);

        table.addCell(new Cell().add("Quantity"));
        table.addCell(new Cell().add("Available"));

        table.addCell(new Cell().add("Mango"));
        table.addCell(new Cell().add("2 kg"));
        table.addCell(new Cell().add("Yes"));

        table.addCell(new Cell().add("Orange"));
        table.addCell(new Cell().add("5 kg"));
        table.addCell(new Cell().add("No"));

        table.addCell(new Cell().add("Banana")); // 3개의 컬럼인데 이렇게 하나 하면 warning 뜸

        document.add(table);
        document.close();
    }



    public void table2() throws FileNotFoundException {
        String path = "C:\\workspace\\table2.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        float columnWidth[] = {200f, 50f, 100f};
        Table table = new Table(columnWidth);

        String[] tableHeader = {"Item","Color","Size"};
        String[][] itemArray = {
                {"Box","Red","Big"},
                {"Stick","Black","Long"},
                {"Mouse","blue","small"}
        };

        for (int x = 0; x<3; x++) {
            table.addCell(new Cell().add(tableHeader[x]).setBackgroundColor(Color.LIGHT_GRAY));
        }
/*
        table.addCell(new Cell().add(tableHeader[0]));
        table.addCell(new Cell().add(tableHeader[1]));
        table.addCell(new Cell().add(tableHeader[2]));
*/
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0 ; j < 3; j++) {
                table.addCell(new Cell().add(itemArray[i][j]));
            }
        }


        document.add(table);
        document.close();
    }

    public void table3() throws FileNotFoundException {
        String path = "C:\\workspace\\table2.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        float columnWidth[] = {200f, 50f, 100f};
        Table table = new Table(columnWidth);

        Border border1 = new GrooveBorder(new DeviceRgb(200,7,4),3);
        table.addCell(new Cell().add("Item").setBorder(border1));
        table.addCell(new Cell().add("Color").setBorder(new DoubleBorder(new DeviceRgb(130,70,45),5f)));
        table.addCell(new Cell().add("Size"));



        //String[] tableHeader = {"Item","Color","Size"};
        String[][] itemArray = {
                {"Box","Red","Big"},
                {"Stick","Black","Long"},
                {"Mouse","blue","small"}
        };

        //for (int x = 0; x<3; x++) {
        //    table.addCell(new Cell().add(tableHeader[x]).setBackgroundColor(Color.LIGHT_GRAY));
        //}
/*
        table.addCell(new Cell().add(tableHeader[0]));
        table.addCell(new Cell().add(tableHeader[1]));
        table.addCell(new Cell().add(tableHeader[2]));
*/
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0 ; j < 3; j++) {
                table.addCell(new Cell().add(itemArray[i][j]));
            }
        }


        document.add(table);
        document.close();
    }

    public void tableWithImage() throws FileNotFoundException, MalformedURLException {
        String path = "C:\\workspace\\tableWithImage.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float columnWidth[] = {200f, 50f, 100f};
        Table table = new Table(columnWidth);

        String imgPath = "images\\tree.png";
        ImageData imageData = ImageDataFactory.create(imgPath);
        Image image = new Image(imageData);

        Cell cell_11 = new Cell();
        cell_11.add("Item");
        table.addCell(cell_11);

        table.addCell(new Cell().add("Quantity"));
        table.addCell(new Cell().add("Available"));

        table.addCell(new Cell().add("Mango"));
        table.addCell(new Cell().add("2 kg"));
        table.addCell(new Cell().add("Yes"));

        table.addCell(new Cell().add(image));
        table.addCell(new Cell().add("5 kg"));
        table.addCell(new Cell().add("No"));

        document.add(table);
        document.close();
    }

    public void tableAddList() throws FileNotFoundException, MalformedURLException {
        String path = "C:\\workspace\\tableAddList.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        List list = new List();
        list.add("Apple").add("Banana").add("Orange");

        float columnWidth[] = {200f, 50f, 100f};
        Table table = new Table(columnWidth);

        table.addCell(new Cell().add("Item"));
        table.addCell(new Cell().add("Color"));
        table.addCell(new Cell().add("Size"));

        table.addCell(new Cell().add(list));
        table.addCell(new Cell().add("Gray"));
        table.addCell(new Cell().add("Long"));

        table.addCell(new Cell().add("Ball"));
        table.addCell(new Cell().add("Red"));
        table.addCell(new Cell().add("Small"));

        document.add(table);
        document.close();
    }

    public void span() throws FileNotFoundException {
        String path = "C:\\workspace\\span.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float columnWidth[] = {100f, 100f, 100f}; // 3개 컬럼생성
        Table table = new Table(columnWidth);

        table.addCell(new Cell().add("One"));
        table.addCell(new Cell().add("Two"));
        table.addCell(new Cell(2,0).add("Three"));
        table.addCell(new Cell().add("Four"));
        table.addCell(new Cell().add("Five"));
        table.addCell(new Cell(0,2).add("Six"));
        table.addCell(new Cell().add("Seven"));

        document.add(table);

        document.close();
    }

    // row span, col span 확장으로 알아보자
    public void rowSpanAndColSpan() throws FileNotFoundException {
        String path = "C:\\workspace\\rowSpanAndColSpan.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float columnWidth[] = {100f, 100f, 100f, 100f, 100f, 100f}; // 6개 컬럼생성
        Table table = new Table(columnWidth);

        table.addCell(new Cell().add("Sarthi Technology"));
        table.addCell(new Cell(2,0).add("Android Battery Manager"));
        table.addCell(new Cell(3,0).add("Android Wifi P2P"));
        table.addCell(new Cell(3,0).add("Android Bluetooth"));
        table.addCell(new Cell(0,2).add("Android Sensor Programming"));
        table.addCell(new Cell().add("Something Library"));
        table.addCell(new Cell().add("Android PDF Document"));
        table.addCell(new Cell().add("User Location"));
        table.addCell(new Cell().add("Some Android Chart"));
        table.addCell(new Cell().add("Graph View"));
        table.addCell(new Cell().add("Text 7 Java"));
        table.addCell(new Cell().add("Text 7 Android"));

        document.add(table);

        document.close();
    }

    public void changeListSymbol() throws FileNotFoundException {
        String path = "C:\\workspace\\changeListSymbol.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        List list = new List();
        Text text = new Text("\u007E"); // 여기에 해당하는 심볼 코드(?) 작성하면 됨. #21 Change List Symbol에 올린 엑셀파일 참고

        list.setListSymbol(text);

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Cherry");
        list.add("Orange");

        document.add(list);

        document.close();

    }


    public void changeListSymbol2() throws FileNotFoundException {
        String path = "C:\\workspace\\changeListSymbol.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        List list = new List();
        Text text = new Text("\u007E"); // 여기에 해당하는 심볼 코드(?) 작성하면 됨. #21 Change List Symbol에 올린 엑셀파일 참고

        // 특정 글꼴을 다운 받아 그 글꼴을 font로 찾는다.
        // 예를들어 해당 폰트로 a 를 쳤을 때 글꼴 모양이 까만원인 경우 text에 a를 넣으면 list의 symbol이 까만원으로 바뀜


        list.setListSymbol(text);

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Cherry");
        list.add("Orange");

        document.add(list);

        document.close();

    }

    public static final String IMG = "src/main/resources/img/tree.png";
    public void imageAsListIcon() throws FileNotFoundException, MalformedURLException {
        String path = "C:\\workspace\\imageAsListIcon.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        ImageData imageData = ImageDataFactory.create(IMG);
        imageData.setHeight(15f);
        imageData.setWidth(15f);

        List list = new List();
        list.setListSymbol(new Image(imageData));

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Cherry");
        list.add("Orange");

        document.add(list);
        document.close();
    }

    public void setPageSize() throws FileNotFoundException {
        String path = "C:\\workspace\\setPageSize.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // 직접 지정
//        Rectangle myPageSize = new Rectangle(700,1400);
//        Document document = new Document(pdfDocument, new PageSize(myPageSize));

        // 디폴트로 지정
        Document document = new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A5.rotate());


        Paragraph paragraph = new Paragraph("Hello");

        document.add(paragraph);

        document.close();
    }

    public void createInvoice() throws FileNotFoundException {
        String path = "C:\\workspace\\createInvoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        float col = 280f;
        float columnWidth[] = {col,col};
        Table table = new Table(columnWidth);

        table.setBackgroundColor(new DeviceRgb(63, 169, 219))
                        .setFontColor(Color.WHITE);
        table.addCell(new Cell().add("INVOICE")
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setFontSize(30f)
                .setBorder(Border.NO_BORDER));

        table.addCell(new Cell().add("Sarthi Technology \n #3546 \n 987654323").setTextAlignment(TextAlignment.CENTER)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setMarginRight(10f)
                .setBorder(Border.NO_BORDER));


        float colWidth[] = {80,300,100,80};
        Table customerInfoTable = new Table(colWidth);

        customerInfoTable.addCell(new Cell(0,4)
                .add("Customer Information")
                .setBold()
                .setBorder(Border.NO_BORDER));

        customerInfoTable.addCell(new Cell().add("Name").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Mia Choi").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Invoice No.").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("2345").setBorder(Border.NO_BORDER));

        customerInfoTable.addCell(new Cell().add("Mo. No.").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("9876543210").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Date").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("2023.04.12").setBorder(Border.NO_BORDER));


        float itemInfoColWidth[] = {140,140,140,140};
        Table itemInfoTable = new Table(itemInfoColWidth);

        itemInfoTable.addCell(new Cell()
                .add("Service")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Hrs.")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Unit Price (INR)")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Amount")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontColor(Color.WHITE));;

        itemInfoTable.addCell(new Cell().add("App Creation"));
        itemInfoTable.addCell(new Cell().add("20"));
        itemInfoTable.addCell(new Cell().add("200")
                .setTextAlignment(TextAlignment.RIGHT));
        itemInfoTable.addCell(new Cell().add(""+20*200)
                .setTextAlignment(TextAlignment.RIGHT));

        itemInfoTable.addCell(new Cell().add("Website Design"));
        itemInfoTable.addCell(new Cell().add("15"));
        itemInfoTable.addCell(new Cell().add("150")
                .setTextAlignment(TextAlignment.RIGHT));
        itemInfoTable.addCell(new Cell().add(""+15*150)
                .setTextAlignment(TextAlignment.RIGHT));

        itemInfoTable.addCell(new Cell()
                .add("")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setBorder(Border.NO_BORDER));
        itemInfoTable.addCell(new Cell()
                .add("")
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setBorder(Border.NO_BORDER));
        itemInfoTable.addCell(new Cell()
                .add("Total Amount")
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontColor(Color.WHITE)
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setBorder(Border.NO_BORDER));
        itemInfoTable.addCell(new Cell()
                .add("6250")
                .setTextAlignment(TextAlignment.RIGHT)
                .setFontColor(Color.WHITE)
                .setBackgroundColor(new DeviceRgb(63,169,219))
                .setBorder(Border.NO_BORDER));

        document.add(table);
        document.add(new Paragraph("\n")); // 위 아래 테이블 사이를 띄우기 위함
        document.add(customerInfoTable);
        document.add(new Paragraph("\n")); // 위 아래 테이블 사이를 띄우기 위함
        document.add(itemInfoTable);
        document.add(new Paragraph("\n(Authorised Signatory)").setTextAlignment(TextAlignment.RIGHT)); // 위 아래 테이블 사이를 띄우기 위함

        document.close();
    }

    public void setWaterMark() throws FileNotFoundException, MalformedURLException {
        String path = "C:\\workspace\\setWaterMark.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        String imgPath = "src/main/resources/img/nirvana.jpg";
        ImageData imageData = ImageDataFactory.create(imgPath);
        Image image = new Image(imageData);
        // 워터마크용 이미지 크기가 가로 640ox, 세로320px 이라고 할 때
        //image.setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/2-320,pdfDocument.getDefaultPageSize().getHeight()/2-160);
        image.setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/2-100,pdfDocument.getDefaultPageSize().getHeight()/2-100);
        image.setOpacity(0.3f);

        Paragraph paragraph = new Paragraph();
        paragraph.add("dummyGYONGBOK PALACE: Built in 1395, Gyeongbokgung Palace is also commonly referred to as the “Northern Palace” because it is located more toward the north, compared to the neighboring palaces of Changdeokgung (Eastern Palace) and Gyeongheegung (Western Palace). Gyeongbokgung Palace is arguably the most beautiful and remains the grandest of all the five palaces.\n" +
                "\n" +
                "\n" +
                "\n" +
                "•11:30-12:30 Visit BUKCHON HANOK VILLAGE \n" +
                "BUKCHON HANOK VILLAGE:Surrounded by Gyeongbokgung Palace, Changdeokgung Palace and Jongmyo Shrine, Bukchon Hanok Village is home to hundreds of traditional houses called 'hanok' that date back to the Joseon Dynasty. The name, 'Bukchon,' which literally translates to 'northern village,' came about as the neighborhoods that the village covers lie to the north of the two significant Seoul landmarks, Cheonggyecheon Stream and Jongno. Today, many of these hanoks operate as cultural centers, guesthouses, restaurants and tea houses, providing an opportunity to experience, learn and immerse in Korean traditional culture.\n" +
                "\nGYONGBOK PALACE: Built in 1395, Gyeongbokgung Palace is also commonly referred to as the “Northern Palace” because it is located more toward the north, compared to the neighboring palaces of Changdeokgung (Eastern Palace) and Gyeongheegung (Western Palace). Gyeongbokgung Palace is arguably the most beautiful and remains the grandest of all the five palaces.\n" +
                "\n" +
                "\n" +
                "\n" +
                "•11:30-12:30 Visit BUKCHON HANOK VILLAGE \n" +
                "BUKCHON HANOK VILLAGE:Surrounded by Gyeongbokgung Palace, Changdeokgung Palace and Jongmyo Shrine, Bukchon Hanok Village is home to hundreds of traditional houses called 'hanok' that date back to the Joseon Dynasty. The name, 'Bukchon,' which literally translates to 'northern village,' came about as the neighborhoods that the village covers lie to the north of the two significant Seoul landmarks, Cheonggyecheon Stream and Jongno. Today, many of these hanoks operate as cultural centers, guesthouses, restaurants and tea houses, providing an opportunity to experience, learn and immerse in Korean traditional culture.\n" +
                "\n");

        document.add(image);
        document.add(paragraph);

        document.close();
    }
}
