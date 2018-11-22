package prs.corejava.thread;

import java.io.File;

/**
 * Created by zhangbin on 2017/7/6.
 */
public class FileSearchResult {

    private File f;
    private String line;
    private Integer lineNumber;

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "FileSearchResult{" +
                "f=" + f +
                ", line='" + line + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
