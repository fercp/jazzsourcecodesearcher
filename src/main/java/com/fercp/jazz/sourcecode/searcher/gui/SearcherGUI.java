package com.fercp.jazz.sourcecode.searcher.gui;

public class SearcherGUI {
    private String keyword;
    private String extension;

    public SearcherGUI() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(final String extension) {
        this.extension = extension;
    }
}