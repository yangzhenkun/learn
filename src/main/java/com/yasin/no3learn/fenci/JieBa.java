package com.yasin.no3learn.fenci;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-12-10 18:27
 */
public class JieBa {

    @Test
    public void testDemo() {


        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[]{"玛莎拉蒂揽胜"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }
    }

}
