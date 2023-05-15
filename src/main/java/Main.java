import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException {

        /**
         * 입력받아야하는 것
         * 1. in out 날짜
         * 2. 파일명 (중복되면 덮어쓰기됨)
         * 3.
         * */

        Practice practice = new Practice();
        //createPdf.create();
        //createPdf.addList();
        //createPdf.font();
        //createPdf.fontFromDirectory();
        //createPdf.font3();
        //createPdf.setStyle();
        //createPdf.table();
        //createPdf.table2();
        //createPdf.table3();
        //createPdf.tableWithImage();
        //createPdf.tableAddList();
        //createPdf.span();
        //createPdf.rowSpanAndColSpan();
        //createPdf.changeListSymbol();
        //createPdf.imageAsListIcon();
        //createPdf.setPageSize();
        //createPdf.createInvoice();
        //practice.setWaterMark();

        Test  test = new Test();
        test.createItinerary();


        System.out.println("Hello");
    }
}
