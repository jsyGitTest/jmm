package com.example.jm.jmm.util.freemakertopdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.List;

public class PdfUtils {

    public static void main(String[] args) throws Exception{
        getPdf(null);
    }

    public  static void getPdf(List<Content> contentList) throws Exception{
        FileOutputStream fos = new FileOutputStream("/project/generatePdf.pdf");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
        document.setPageSize(PageSize.A4);
        Rectangle rectangle = new Rectangle(45, 45, 559, 788);
        rectangle.setBorderColor(BaseColor.BLUE);
        writer.setBoxSize("rectangle", rectangle);

        document.open();

        //加入图片
        Image imageLogo = Image.getInstance("/project/pic/se.gif");
        imageLogo.setAlignment(Element.ALIGN_CENTER);
        imageLogo.scaleToFit(170,170);
        document.add(imageLogo);

        if(contentList.size() >0){


            for (int i = 0; i < contentList.size(); i++) {
                if(contentList.get(i).getPicsList().size()==0){
                    continue;
                }
                Paragraph elements = new Paragraph(contentList.get(i).getContent(), getPdfChineseFont());
                document.add(elements);

                List<Pics> picsList = contentList.get(i).getPicsList();
                if(picsList.size()>0){
                    for (int j = 0; j < picsList.size(); j++) {
                        String url = picsList.get(j).getUrl();//加入图片
                        Image imageLogo1 = Image.getInstance(url);
                        imageLogo1.scaleToFit(170,170);
                        document.add(imageLogo1);
                    }
                }
                document.newPage();

            }

        }

        document.close();
    }



    /**
     * @Description: 获取带颜色和大小的字体,
     * @Param: [font, content, baseColor, fontSize]
     * @Return: com.itextpdf.text.Phrase
     * @Author: Jiangsy
     * @Date: 2019/9/18
     **/
    private static Phrase getColorFont(int fontStyle,String content,BaseColor baseColor,float fontSize) throws Exception{
        FontSelector selector = new FontSelector();
        BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese,fontSize,fontStyle);
        font.setColor(baseColor);
        selector.addFont(font);
        Phrase ph = selector.process(content);
        Paragraph p = new Paragraph(ph);
        return p;
    }

    /**
     * @Description:  获取带背景色的单元格
     * @Param: [baseColor]
     * @Return: com.itextpdf.text.pdf.PdfPCell
     * @Author: Jiangsy
     * @Date: 2019/9/20
     **/
    private static PdfPCell getCellByBackgroudColor(BaseColor baseColor){
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBackgroundColor(baseColor);
        return pdfPCell;
    }

    /**
     * @MethodName: 一级大标题
     * @Param: [title]
     * @Return: com.itextpdf.text.Paragraph
     * @Author: Jiangsy
     * @Date: 2019/8/30
     **/
    private static Paragraph getFirstTile(String title) throws Exception{
        //添加中文字体
        BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font firsetTitleFont = new Font(bfChinese,22,Font.NORMAL); //一级标题
        Paragraph p1 = new Paragraph(title,firsetTitleFont);
        p1.setAlignment(Element.ALIGN_CENTER);
        return p1;
    }

    /**
     * @MethodName: 层级列表主标题
     * @Param: [document]
     * @Return: void
     * @Author: Jiangsy
     * @Date: 2019/8/30
     **/
    private static void addCjFirstTitle(Document document,String title) throws Exception{
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(510f);
        table.setLockedWidth(true);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(new BaseColor(251,114,66));
        cell.setMinimumHeight(25); // 设置单元格高度
        cell.addElement(getBlueBg(title));
        cell.disableBorderSide(15);
        cell.setPaddingBottom(10f);
        cell.setPaddingLeft(5f);
        table.addCell(cell);
        table.setHorizontalAlignment(1);
        document.add(table);
    }

    /**
     * @MethodName: 白色字体
     * @Param: [warn]
     * @Return: com.itextpdf.text.Paragraph
     * @Author: Jiangsy
     * @Date: 2019/8/30
     **/
    private static Paragraph getBlueBg( String warn) throws Exception {
        FontSelector selector = new FontSelector();
        BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fff = new Font(bfChinese,14,Font.NORMAL);
        selector.addFont(fff);
        fff.setColor(BaseColor.WHITE);
        Phrase ph = selector.process(warn);
        Paragraph p = new Paragraph(ph);
        return p;
    }



    /**
     * @MethodName: 获取中文字体
     * @Param: []
     * @Return: com.itextpdf.text.Font
     * @Author: Jiangsy
     * @Date: 2019/7/25
     **/
    public static Font getPdfChineseFont() throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
                BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 10, Font.NORMAL);
        return fontChinese;
    }

    private static void addRainbow(Document document) throws Exception{
        PdfPTable table0 = new PdfPTable(new float[]{80,430});
        table0.setTotalWidth(510f);
        table0.setLockedWidth(true);
        table0.setSpacingBefore(10f);

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(510f);
        table.setLockedWidth(true);


        PdfPTable table2 = new PdfPTable(new float[]{30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30});
        table2.addCell(getPdfBgColorCell(new BaseColor(103,204,104)));
        table2.addCell(getPdfBgColorCell(new BaseColor(113,204,94)));
        table2.addCell(getPdfBgColorCell(new BaseColor(129,204,84)));
        table2.addCell(getPdfBgColorCell(new BaseColor(146,204,74)));
        table2.addCell(getPdfBgColorCell(new BaseColor(172,204,64)));
        table2.addCell(getPdfBgColorCell(new BaseColor(188,204,45)));
        table2.addCell(getPdfBgColorCell(new BaseColor(206,204,32)));
        table2.addCell(getPdfBgColorCell(new BaseColor(229,203,17)));
        table2.addCell(getPdfBgColorCell(new BaseColor(243,205,12)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,220,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,210,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,190,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,170,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,150,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,130,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,110,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,90,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,70,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,60,0)));
        table2.addCell(getPdfBgColorCell(new BaseColor(255,40,0)));

        table.setHorizontalAlignment(Element.ALIGN_CENTER);


        PdfPCell pdfCell1 = new PdfPCell();
        pdfCell1.setPhrase(getColorFont(Font.BOLD,"等级测试",new BaseColor(12,91,175),11f));
        pdfCell1.setPaddingLeft(10f);
        pdfCell1.setMinimumHeight(25f);
        pdfCell1.setPaddingTop(6f);
        pdfCell1.disableBorderSide(8);


        PdfPCell pdfCell2 = new PdfPCell();
        pdfCell2.setPhrase(getColorFont(Font.BOLD,"J ava 菜鸡",new BaseColor(218,10,37),11f));
        pdfCell2.setPaddingLeft(10f);
        pdfCell2.setMinimumHeight(25f);
        pdfCell2.setPaddingTop(6f);
        pdfCell2.disableBorderSide(4);



        table0.addCell(pdfCell1);
        table0.addCell(pdfCell2);


        PdfPCell pdfPCell2 = new PdfPCell();
        pdfPCell2.setPhrase(getColorFont(Font.NORMAL,"水平",new BaseColor(12,91,175),10f));
        pdfPCell2.disableBorderSide(2);
        pdfPCell2.setPaddingLeft(10f);


        PdfPCell pdfPCell3 = new PdfPCell();
        int a = 5;

        if(a == 1){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ J AVA菜鸡",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(50);
        }else if(a == 2){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ J AVA入门",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(70);
        }else if(a == 3){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ J AVA中级",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(80);
        }else if(a == 4){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ J AVA高级",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(110);
        }else if(a == 5){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ 技术专家",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(220);
        }else if(a == 6){
            pdfPCell3.setPhrase(getColorFont(Font.NORMAL,"▼ 架构师",new BaseColor(12,91,175),10f));
            pdfPCell3.disableBorderSide(3);
            pdfPCell3.setPaddingLeft(410);
        }

        PdfPCell pdfPCell4 = new PdfPCell();
        pdfPCell4.addElement(table2);
        pdfPCell4.disableBorderSide(3);


        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(pdfPCell2);
        table.addCell(pdfPCell3);
        table.addCell(pdfPCell4);

        PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("初级"+"                                                                                                                   "+"架构"));
        pdfPCell5.disableBorderSide(1);
        pdfPCell5.setPaddingLeft(55);
        table.addCell(pdfPCell5);

        document.add(table0);
        document.add(table);
    }

    /**
     * @Description: 获取带颜色的单元格
     * @Param: [baseColor]
     * @Return: com.itextpdf.text.pdf.PdfPCell
     * @Author: Jiangsy
     * @Date: 2019/9/18
     **/
    private static PdfPCell getPdfBgColorCell(BaseColor baseColor){
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBackgroundColor(baseColor);
        pdfPCell.disableBorderSide(15);
        pdfPCell.setMinimumHeight(20);
        return pdfPCell;
    }
}

