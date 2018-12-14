package com.yasin.no3learn.fenci;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class IkSegmentation {
    public static void main(String[] args) throws IOException {
        String text = "<三峡人家-清江画廊动车2日游>吊脚楼、民歌和土家幺妹、 住商圈酒店 跟";
        // 创建分词对象
        @SuppressWarnings("resource")
        Analyzer anal = new IKAnalyzer(true); // true　用智能分词，false细粒度
        Configuration cfg = DefaultConfig.getInstance();
//        System.out.println(cfg.getMainDictionary()); // 系统默认词库
//        System.out.println(cfg.getQuantifierDicionary());
        Dictionary.initial(cfg);
        StringReader reader = new StringReader(text);
        // 分词
        TokenStream ts = anal.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        // 遍历分词数据
        while (ts.incrementToken()) {
            System.out.print(term.toString() + "|");
        }
        reader.close();
        System.out.println();
    }
}