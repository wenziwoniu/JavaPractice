package javase.test.generic;

import java.util.ArrayList;
import java.util.List;

public class GlmapperGeneric<T> {

    public <T extends Number> void test(List<T> dest, List<T> src) {

    }

    public void test2(List<? extends Number> dest, List<? extends Number> src) {

    }

    public static void main(String[] args) {

        GlmapperGeneric<String> glmapperGeneric = new GlmapperGeneric<>();
        List<Long> dest = new ArrayList<>();
        List<Integer> src = new ArrayList<>();
        glmapperGeneric.test2(dest,src);

//        GlmapperGeneric<String> glmapperGeneric = new GlmapperGeneric<>();
//        List<String> dest = new ArrayList<>();
//        List<Number> src = new ArrayList<>();
//        glmapperGeneric.test2(dest,src);
    }
}
