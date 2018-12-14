package com.yasin.no3learn.fenci;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-12-10 18:55
 */
public class Ansj {


    @Test
    public void dfdf() {
        try {
            DicLibrary.insert(DicLibrary.DEFAULT, "x3", "series", 1000);
            DicLibrary.insert(DicLibrary.DEFAULT, "宝马", "brand", 1000);

            Result result = DicAnalysis.parse("宝马x3");

            for (Term term : result.getTerms()) {


                System.out.println(term.getName());
                System.out.println(term.getNatureStr());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
