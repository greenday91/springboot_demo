package com.example.demo.spider.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenzy by
 */
public class JsoupUtil {

    private final static Map<String, String> jsoupHeader;

    static {
        jsoupHeader = new HashMap<>();
        jsoupHeader.put("Host", "http://info.bet007.com");
        jsoupHeader.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
        jsoupHeader.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        jsoupHeader.put("Accept-Language", "zh-cn,zh;q=0.5");
        jsoupHeader.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
        jsoupHeader.put("Connection", "keep-alive");
    }

    public static Document getDocument(String url,Integer timeout){
        try{
           return Jsoup.connect(url).headers(jsoupHeader).timeout(timeout).get();
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "https://sofifa.com/players?&showCol%5B%5D=pi" +
                "&showCol%5B%5D=ae&showCol%5B%5D=hi&showCol%5B%5D=wi&showCol%5B%5D=pf&showCol%5B%5D=oa" +
                "&showCol%5B%5D=pt&showCol%5B%5D=bo&showCol%5B%5D=bp&showCol%5B%5D=gu&showCol%5B%5D=jt" +
                "&showCol%5B%5D=le&showCol%5B%5D=vl&showCol%5B%5D=wg&showCol%5B%5D=rc&showCol%5B%5D=ta" +
                "&showCol%5B%5D=cr&showCol%5B%5D=fi&showCol%5B%5D=he&showCol%5B%5D=sh&showCol%5B%5D=vo" +
                "&showCol%5B%5D=ts&showCol%5B%5D=dr&showCol%5B%5D=cu&showCol%5B%5D=fr&showCol%5B%5D=lo" +
                "&showCol%5B%5D=bl&showCol%5B%5D=to&showCol%5B%5D=ac&showCol%5B%5D=sp&showCol%5B%5D=ag" +
                "&showCol%5B%5D=re&showCol%5B%5D=ba&showCol%5B%5D=tp&showCol%5B%5D=so&showCol%5B%5D=ju" +
                "&showCol%5B%5D=st&showCol%5B%5D=sr&showCol%5B%5D=ln&showCol%5B%5D=te&showCol%5B%5D=ar" +
                "&showCol%5B%5D=in&showCol%5B%5D=po&showCol%5B%5D=vi&showCol%5B%5D=pe&showCol%5B%5D=cm" +
                "&showCol%5B%5D=td&showCol%5B%5D=ma&showCol%5B%5D=sa&showCol%5B%5D=sl&showCol%5B%5D=tg" +
                "&showCol%5B%5D=gd&showCol%5B%5D=gh&showCol%5B%5D=gk&showCol%5B%5D=gp&showCol%5B%5D=gr" +
                "&showCol%5B%5D=tt&showCol%5B%5D=bs&showCol%5B%5D=wk&showCol%5B%5D=sk&showCol%5B%5D=aw" +
                "&showCol%5B%5D=dw&showCol%5B%5D=ir&showCol%5B%5D=pac&showCol%5B%5D=sho&showCol%5B%5D=pas" +
                "&showCol%5B%5D=dri&showCol%5B%5D=def&showCol%5B%5D=phy";

        Document document = JsoupUtil.getDocument(url,20000);
        Elements elements = document.getElementsByTag("table");
        System.out.println(elements);
//            e.getElementsByClass("col col-hi").text();
//            e.getElementsByClass("col col-wi").text();
//            e.getElementsByClass("col col-pf").text();
//            e.getElementsByClass("bp3-tag p p78").text();
//            e.getElementsByClass("pos pos10").text();
//            e.getElementsByClass("bp3-tag p p8").text();
//            e.getElementsByClass("col col-jt").text();
//            e.getElementsByClass("col col-le").text();
//            e.getElementsByClass("col col-vl").text();
//            e.getElementsByClass("col col-wg").text();
//            e.getElementsByClass("col col-rc").text();
       // System.out.println(elements.toString());
    }


}
