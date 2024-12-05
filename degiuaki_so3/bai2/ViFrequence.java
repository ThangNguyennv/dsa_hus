package degiuaki_so3.bai2;

public class ViFrequence {
    private SymbolTable symbolTable;

    public ViFrequence() {
        symbolTable = new SymbolTable();
    }

//    Xử lí văn bản và đếm tần suất của các cặp ký tự liên tiếp
    public void analyzeText(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            String pair = text.substring(i, i + 2);
            symbolTable.addPair(pair);
        }
    }

    // Hiển thị tần suất xuất hiện của các cặp ký tự
    public void displayFrequencies() {
        symbolTable.disPlay();
    }

    // Kiểm tra tuần suất của 1 cặp ký tự
    public int getPairFrequency(String pair) {
        return symbolTable.getFrequency(pair);
    }
}
