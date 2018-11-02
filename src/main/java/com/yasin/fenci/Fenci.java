package com.yasin.fenci;

import com.alibaba.fastjson.JSON;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.dictionary.DictionaryFactory;
import org.apdplat.word.util.WordConfTools;
import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-11-01 15:25
 */
public class Fenci {

    @Test
    public void test(){

        WordConfTools.set("dic.path","src/main/resources/brand.txt");
        DictionaryFactory.reload();//更改词典路径之后，重新加载词典


        System.out.println("890890890980");
        System.out.println(JSON.toJSONString(WordSegmenter.seg("本田陆巡")));



    }




}
