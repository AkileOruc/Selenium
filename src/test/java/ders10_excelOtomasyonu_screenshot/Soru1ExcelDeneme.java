package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class Soru1ExcelDeneme {
    @Test
    public void test01() throws IOException {
// excel dosyasina ulasmak icin once
// excel dosyasi uzerinde sag tik copy path sonra PathFromContentRoot ile dosya yolunu kopyaladim ve bir string e atadim
        String dosyaYolum = "C:\\Users\\aydog\\IdeaProjects\\Selenium\\src\\test\\java\\ders10_excelOtomasyonu_screenshot\\deneme.xlsx";
        FileInputStream yeniFis = new FileInputStream(dosyaYolum);

//excel dosyasinin bir kopyasini kod ortamimizda olusturmak icin "Workbook" kullaniriz;

        Workbook workbook = WorkbookFactory.create(yeniFis);
// artik excelin bir kopyasina sahibiz birden fazla sayfa olabilecegi icin ayrintili gidelim "Sheet " ile

        Sheet sheet=workbook.getSheet("Sheet1");

        Row row=sheet.getRow(7);
        Cell cell= row.getCell(1);
        System.out.println(cell);
// ben 7. satir 1 inci sutun dedim ama o bana 8. satir 2. sutun daki bilgiyi verdi index ler 0 dan basladigi icin

    }
}