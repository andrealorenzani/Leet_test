package name.lorenzani.andrea.metaprep.DesignerPDFViewer;

import java.util.List;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int value = 1;
        for(int i=0; i<word.length(); i++){
            value = Math.max(value, h.get(word.charAt(i)-'a'));
        }
        return value * word.length();
    }

}
