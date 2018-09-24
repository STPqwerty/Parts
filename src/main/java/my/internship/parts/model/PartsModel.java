package my.internship.parts.model;

import java.util.List;

public class PartsModel {
    List<Parts> parts;
    int CompCount;
    int page = 0;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public int getCompCount() {
        return CompCount;
    }

    public void setCompCount(int compCount) {
        CompCount = compCount;
    }
}
