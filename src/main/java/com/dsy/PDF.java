package com.dsy;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class PDF {

    //
    //    // 第四步 添加段落内容
    //    //Paragraph title = new Paragraph("优酷内容创作平台授权书和确认函", fontTitle);
    //    //title.setAlignment(Element.ALIGN_CENTER);
    //    //document.add(title);
    //    //
    //    //Chunk chunk = new Chunk("测试2222231312chunk", fontChinese);
    //    //////chunk.setBackground(BaseColor.GREEN);//文字背景色
    //    //////chunk.setLineHeight(10);//行高
    //    //chunk.setUnderline(1, 0);//下划线，或者文字任意文字的线条
    //    ////document.add(chunk);
    //    //
    //    //
    //    //Paragraph paragraph1 = new Paragraph();
    //    //Chunk chunk2 = new Chunk("被授权方：", fontChinese);
    //    //Chunk chunk3 = new Chunk("优酷信息技术（北京）有限公司(“优酷技术”)、浙江天猫技术有限公司(“天猫技术”)", fontChinese);
    //    //paragraph1.add(chunk2);
    //    //paragraph1.add(chunk3);
    //    //document.add(paragraph1);
    //    //
    //    //Paragraph paragraph = new Paragraph();
    //    //paragraph.add(chunk);
    //    //paragraph.add(new Chunk("2312323123131231", fontChinese));
    //    //document.add(paragraph);
    //    //
    //    //document.add(new Paragraph("\n"));
    //    //document.add(new Paragraph("授权方：" + "xxxxxx", fontChinese));
    //    //document.add(new Paragraph("地址：" + "xxxxx", fontChinese));
    //    //document.add(new Paragraph("联系人：xxxx", fontChinese));
    //    //document.add(new Paragraph("手机号：xxx", fontChinese));
    //    //
    //    //document.add(new Paragraph("\n"));
    //    //document.add(new Paragraph("大鱼号账号昵称：aaa", fontChinese));
    //    //document.add(new Paragraph("大鱼号账号ID：aaa", fontChinese));
    //    //document.add(new Paragraph("优酷昵称：aaa", fontChinese));
    //    //document.add(new Paragraph("优酷ID：aaa", fontChinese));
    //    //
    //    //document.add(new Paragraph("\n"));
    //    //document.add(new Paragraph("大鱼号账号昵称：bbb", fontChinese));
    //    //document.add(new Paragraph("大鱼号账号ID：bbb", fontChinese));
    //    //document.add(new Paragraph("优酷昵称：bbb", fontChinese));
    //    //document.add(new Paragraph("优酷ID：bbb", fontChinese));
    //
    //    String fileName = "12345.pdf";
    //    Document document = new Document();
    //    // 第二步 获取PdfWriter实例
    //    PdfWriter.getInstance(document, new FileOutputStream(fileName));
    //    // 第三步 打开文档
    //    document.open();
    //
    //    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    //    Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
    //    Font blueFont = new Font(bfChinese, 12, Font.NORMAL);
    //    blueFont.setColor(BaseColor.BLUE);
    //    Font fontTitle = new Font(bfChinese, 14, Font.BOLD);
    //    Paragraph paragraph2 = new Paragraph();
    //    Chunk chunk1 = new Chunk("1.1");
    //    paragraph2.add(chunk1);
    //    Chunk chunk4 = new Chunk("优酷账号&实名认证：", fontChinese);
    //    paragraph2.add(chunk4);
    //    Chunk chunk5 = new Chunk("授权方和/或其引入的创作者在被授权方优酷内容创作平台上传和分发内容，需要(1)首先注册相应的大鱼号账号；(2)大鱼账号映射生成一个优酷账号；该优酷账号需要授权方和/或其引入的创作者提供手机号进行实名认证；（3）如授权方为公司的，需要您向优酷提供营业执照复印件和法人代表身份证复印件进行认证；(4)请授权方理解，如授权方或/和授权方引入个人创作者涉及分账收入提现的，需要提供身份证号，缴纳个人所得税之用。",fontChinese);
    //    paragraph2.add(chunk5);
    //    paragraph2.setFirstLineIndent(-15);
    //    paragraph2.setIndentationLeft(20);
    //    document.add(paragraph2);
    //
    //    Chunk chunk21 = new Chunk("《百度》",blueFont);
    //    chunk21.setAnchor("www.baidu.com");
    //    chunk21.setUnderline(1,0);
    //    chunk21.setU
    //    document.add(chunk21);
    //
    //
    //    // 第五部 操作完成后必须执行文档关闭操作。
    //    document.close();
    //
    //}

    public static void main(String[] args) throws Exception {
        String templatePath = "/Users/dingsiye/Desktop/model.pdf";
        //生成的新文件路径
        String newPDFPath = "n.pdf";
        PdfReader reader = new PdfReader(templatePath);//读取pdf模板
        FileOutputStream out = new FileOutputStream(newPDFPath);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, bos);;
        AcroFields form = stamper.getAcroFields();

        //String[] str = {"丁斯也小军","小鲁","男","1994-00-00",
        //    "言阙资"
        //    ,"河北省唐山市"};
        //int i = 0;
        //java.util.Iterator<String> it = form.getFields().keySet().iterator();
        //while(it.hasNext()){
        //    String name = it.next();
        //    System.out.println(name);
        //    i = Math.min(i, 5);
        //    form.setField(name, str[i]);
        //    i++;
        //}
        //stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
        //insertImage(stamper, form);
        //stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
        //stamper.close();
        //
        //
        //
        //Document doc = new Document();
        //PdfCopy copy = new PdfCopy(doc, out);
        //doc.open();
        //copy.addDocument(new PdfReader(bos.toByteArray()));
        //doc.close();

    }



    public static void insertImage (PdfStamper stamper, AcroFields form) throws Exception
    {

        String imagePath = "/Users/dingsiye/Desktop/timg.jpeg";

        int page = form.getFieldPositions("fill_35").get(0).page;
        Rectangle signReact = form.getFieldPositions("fill_35").get(0).position;
        float x = signReact.getLeft();
        float y = signReact.getBottom();
        Image image = Image.getInstance(imagePath);
        PdfContentByte under = stamper.getOverContent(page);
        image.scaleToFit(signReact.getWidth(),signReact.getHeight());
        image.setAbsolutePosition(x,y);
        under.addImage(image);

    }
}
